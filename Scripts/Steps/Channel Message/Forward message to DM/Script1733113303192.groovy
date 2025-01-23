import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import java.awt.Checkbox as Checkbox
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

if (GlobalVariable.isDirectMessage) {
	WebUI.callTestCase(findTestCase('Steps/Direct Message/Select conversation'), [:], FailureHandling.STOP_ON_FAILURE)
    WebUI.callTestCase(findTestCase('Steps/Channel Message/Send Message Text'), [('isCalled') : true], FailureHandling.STOP_ON_FAILURE)
} else {
    WebUI.callTestCase(findTestCase('Steps/Channel Message/Send Message Text'), [:], FailureHandling.STOP_ON_FAILURE)
}

WebUI.mouseOver(findTestObject('Channel Message/Forward message to DM/div_latest_message'))
WebUI.click(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/button_more'))

if (GlobalVariable.isDirectMessage) {
    WebUI.click(findTestObject('Object Repository/Direact Message/Forward message/button_forward message'))
} else {
    WebUI.click(findTestObject('Channel Message/Forward message to DM/button_forward'))
}

if(isForwardToChannel) {
	WebUI.setText(findTestObject('Object Repository/Channel Message/Forward message to DM/input_Search'), '#forward channel')
} else {	
	WebUI.setText(findTestObject('Object Repository/Channel Message/Forward message to DM/input_Search'), '@')
}

WebElement checkboxSearchResultElement = WebUI.findWebElement(findTestObject('Object Repository/Channel Message/Forward message to DM/checkbox_Search Result'))

String checkboxSearchResultId = checkboxSearchResultElement.getAttribute('id')

String[] splitID = checkboxSearchResultId.split('-')

String conversationId = splitID[(splitID.size() - 1)]

checkboxSearchResultElement.click()

WebElement forwardMessageElement = WebUI.findWebElement(findTestObject('Object Repository/Channel Message/Forward message to DM/span_Forward Message'))

String forwardMessage = forwardMessageElement.getText()

WebUI.click(findTestObject('Channel Message/Forward message to DM/button_send_forward_message'))

WebUI.verifyElementPresent(findTestObject('Channel Message/Forward message to DM/Toast success'), 10)

String navigateToUrl

if (isForwardToChannel) {
	String clanId = "1840652023322644480"
	navigateToUrl = "$GlobalVariable.host/chat/clans/$clanId/channels/$conversationId"
} else {
	navigateToUrl = "$GlobalVariable.host/chat/direct/message/$conversationId/3"
}

WebUI.navigateToUrl(navigateToUrl)

WebUI.verifyElementPresent(findTestObject('Object Repository/Channel Message/Forward message to DM/div_Forward Tag'), 10)

WebElement forwardedMessageElement = WebUI.findWebElement(findTestObject('Object Repository/Channel Message/Forward message to DM/span_Message Forwarded'))

String forwardedMessage = forwardedMessageElement.getText()

if (!(forwardedMessage.equals(forwardMessage))) {
    WebUI.takeScreenshot()
    KeywordUtil.markFailed("Error forward message - forwardedMessage: $forwardedMessage; forwardMessage: $forwardMessage")
}

