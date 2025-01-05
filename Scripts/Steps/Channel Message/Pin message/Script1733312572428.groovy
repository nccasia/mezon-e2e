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

WebUI.callTestCase(findTestCase('Steps/Channel Message/Send Message Text'), [:], FailureHandling.STOP_ON_FAILURE)

WebElement messageElement = WebUI.findWebElement(findTestObject('Channel Message/Jump to pin message/div_message need to pin'))

String messageId = messageElement.getAttribute('id')

WebUI.mouseOver(findTestObject('Channel Message/Jump to pin message/div_message need to pin'))

WebUI.click(findTestObject('Object Repository/Channel Message/Forward message to DM/button_more'))

if(GlobalVariable.isDirectMessage) {
	WebUI.click(findTestObject('Object Repository/Direact Message/Pin message/buttton_pin message'))
} else {
	WebUI.click(findTestObject('Channel Message/Jump to pin message/button_pin message'))
}

if (GlobalVariable.isThread) {
    WebUI.click(findTestObject('Object Repository/Channel Message/Jump to pin message/button_create pin _thread'))
} else {
    WebUI.click(findTestObject('Channel Message/Jump to pin message/button_create pin'))
}

Boolean isSending = CustomKeywords.'mezon.SendingMessage.isSendingMessage'()

WebUI.takeScreenshot()

if (isSending) {
    KeywordUtil.markFailedAndStop('pin message failed')
}

WebElement pinMessageContainer = WebUI.findWebElement(findTestObject('Channel Message/Jump to pin message/div_pin message icon container'))

String pinMessageSVGElemt = pinMessageContainer.getAttribute('innerHTML')

String pinMessageSVG = CustomKeywords.'mezon.ConvertFile.toString'('\\Data Files\\Svg\\pin message.svg')

WebUI.takeScreenshot()

if (pinMessageSVGElemt != pinMessageSVG) {
    KeywordUtil.markFailedAndStop('Pin message icon not present')
}
