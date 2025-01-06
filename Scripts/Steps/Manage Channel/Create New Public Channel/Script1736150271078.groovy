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

WebUI.callTestCase(findTestCase('Steps/Login_Logout and SignUp/Login with email and password'), [('email') : 'E2E1762357@ncc.asia'
        , ('password') : 'E2E1762357'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/div_Clan T'))

WebUI.click(findTestObject('Object Repository/Manage Channel/Create New Public Channel/button_Add Channel'))

WebUI.check(findTestObject('Object Repository/Manage Channel/Create New Public Channel/radio_Channel Type_Text'))

Random generator = new Random()

int randomNumber = generator.nextInt()

String newChannelName = "New $randomNumber"

WebUI.setText(findTestObject('Manage Channel/Create New Public Channel/input_Enter The Channel Name'), newChannelName)

WebUI.click(findTestObject("Object Repository/Manage Channel/Create New Public Channel/button_Create Channel"))

Boolean verifyCreateNewChannelFail = true

for (int i = 0; i < 15; i++) {
	WebElement newChannelElement = WebUI.findWebElement(findTestObject('Object Repository/Manage Channel/Create New Public Channel/div_New Channel'))
	
	String newChannelElementText = newChannelElement.getText()
	
	if(newChannelElementText == newChannelName) {
		String newChannelElementInnerHTML = newChannelElement.getAttribute('innerHTML')
		
		String publicChannelSVG = CustomKeywords.'mezon.ConvertFile.toString'('\\Data Files\\Svg\\Public Channel.svg')
		
		if(newChannelElementInnerHTML.contains(publicChannelSVG)) {
			verifyCreateNewChannelFail = false
			break
		} else {
			KeywordUtil.markFailedAndStop("Channel Icon is wrong!")
		}
	}
	WebUI.delay(1)
}

if (verifyCreateNewChannelFail) {
	KeywordUtil.markFailedAndStop("New Channel not present!")
}

WebElement titleNewChannelElement = WebUI.findWebElement(findTestObject("Object Repository/Manage Channel/Create New Public Channel/p_title new channel"))

String titleNewChannelText = titleNewChannelElement.getText()

WebUI.takeScreenshot()

if (titleNewChannelText != newChannelName) {
	KeywordUtil.markFailedAndStop("New Channel Title is wrong!")
}


