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

WebUI.callTestCase(findTestCase('Steps/Channel Message/Select channel'), [:], FailureHandling.STOP_ON_FAILURE)

if(GlobalVariable.isDirectMessage) {
	sendMessageBuzz()
	
	WebUI.verifyElementPresent(findTestObject('Object Repository/Direact Message/Send message Buzz/div_buzz'), 5)
} else {	
	String BuzzXpath = ''
	
	if (GlobalVariable.isThread) {
		BuzzXpath = "//*[@id='$GlobalVariable.channelID']/following-sibling::div[1]/div/div/div"
	} else {
		BuzzXpath = "//*[@id='$GlobalVariable.channelID']/a/div/div"
	}
	
	TestObject buzzElement = CustomKeywords.'mezon.GetTestObject.withXpath'(BuzzXpath)
	
	sendMessageBuzz()
	
	WebUI.verifyElementPresent(buzzElement, 15)
}

WebElement spanMessageBuzz = WebUI.findWebElement(findTestObject('Channel Message/Send message Buzz/span_message buzz'))

String messageBuzz = spanMessageBuzz.getText()

String colorText = spanMessageBuzz.getCssValue('color')

if (((messageBuzz != 'Buzz!!')) || (colorText != 'rgba(239, 68, 68, 1)')) {
	WebUI.takeScreenshot()
    KeywordUtil.markFailedAndStop("Error message - messageBuzz: '$messageBuzz'; colorText: $colorText")
}


def sendMessageBuzz() {
	WebUI.sendKeys(findTestObject('Channel Message/Page_Mezon/textarea_1'), Keys.chord(Keys.CONTROL, 'g'))
	
	Boolean isSending = CustomKeywords.'mezon.SendingMessage.isSendingMessage'()
	
	if (isSending) {
		WebUI.takeScreenshot()
		KeywordUtil.markFailedAndStop("Sending message failed")
	}
}
