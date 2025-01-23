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

if(!isCalled) {
	WebUI.callTestCase(findTestCase('Steps/Channel Message/Send Message Text'), [:], FailureHandling.STOP_ON_FAILURE)	
}

WebUI.mouseOver(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/div_latest message'))

WebUI.click(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/button_more'))

if(GlobalVariable.isDirectMessage) {
	WebUI.click(findTestObject('Object Repository/Direact Message/Reply message/button_reply'))
	
	WebUI.verifyElementVisible(findTestObject('Object Repository/Direact Message/Reply message/div_replying to'))
} else {
	WebUI.click(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/buttion_more_reply'))
	
	WebUI.verifyElementVisible(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/div_Replying to'))
}

String replyMessage = 'toi la bot'

CustomKeywords.'mezon.SendText.sendText'(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/textarea__channel T'), 
    replyMessage)

Boolean isSending = CustomKeywords.'mezon.SendingMessage.isSendingMessage'()

if(isSending) {
	WebUI.takeScreenshot()
	
	KeywordUtil.markFailedAndStop('Sending message failed')
}

WebUI.verifyElementPresent(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/div_repy message'), 10)

WebElement repyMessageElement = WebUI.findWebElement(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/span_reply message'))

String sentMessage = repyMessageElement.getText()

if(replyMessage != sentMessage) {
	WebUI.takeScreenshot()
	
	KeywordUtil.markFailed("Error message - replyMessage: '$replyMessage'; sentMessage: '$sentMessage'")
}

