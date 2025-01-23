import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebUI.callTestCase(findTestCase('Steps/Login_Logout and SignUp/Login with email and password'), [('email') : 'E2E1762357@ncc.asia'
        , ('password') : 'E2E1762357'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/div_Clan T'))

WebUI.click(findTestObject('Object Repository/Channel Message/Send Message DM From Short Profile/div_Test Channel'))

WebUI.click(findTestObject('Object Repository/Channel Message/Send Message DM From Short Profile/div_avatar in message'))

String message = "hello"

CustomKeywords.'mezon.SendText.sendText'(findTestObject('Channel Message/Send Message DM From Short Profile/input_Send Message DM'), 
    message)

WebDriver driver = DriverFactory.getWebDriver()

String directMessageURL = "$GlobalVariable.host/chat/direct/message"

String isNavigated = false

for(int i = 0; i < 15; i++) {
	String currentURL = driver.getCurrentUrl()
	if(currentURL.contains(directMessageURL)) {
		isNavigated = true
		break
	}
	WebUI.delay(1)
}

if(!isNavigated) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailedAndStop("Not navigate to Direct Message!")
}

Boolean isSendMessageSuccess = false

for(int i = 0; i < 15; i++) {
	WebElement latestMessageDMElement = WebUI.findWebElement(findTestObject('Object Repository/Channel Message/Send Message DM From Short Profile/span_latest message DM'))
	
	String latestMessageDM = latestMessageDMElement.getText()
	
	if(latestMessageDM.equals(message)) {
		isSendMessageSuccess = true
		break
	}
	WebUI.delay(1)
}

if(!isSendMessageSuccess) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailedAndStop("Message is incorrect!")
}
