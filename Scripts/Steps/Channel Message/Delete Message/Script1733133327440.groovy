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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import org.openqa.selenium.WebElement as WebElement

WebUI.callTestCase(findTestCase('Steps/Channel Message/Send Message Text'), [:], FailureHandling.STOP_ON_FAILURE)

WebElement message = WebUI.findWebElement(findTestObject('Channel Message/Forward message to DM/div_latest_message'))

String messageId = message.getAttribute('id')

WebUI.mouseOver(findTestObject('Channel Message/Forward message to DM/div_latest_message'))

WebUI.rightClick(findTestObject('Channel Message/Forward message to DM/div_latest_message'))

if(GlobalVariable.isDirectMessage) {
	WebUI.click(findTestObject('Object Repository/Direact Message/Delete message/button_detele message'))
} else {
	WebUI.click(findTestObject('Object Repository/Channel Message/Delete Message/button_delete message'))	
}

if(GlobalVariable.isThread) {
	WebUI.verifyElementPresent(findTestObject('Object Repository/Channel Message/Delete Message/div_delete message container - thread'),
		10)

	WebElement deleteMessageContainer = WebUI.findWebElement(findTestObject('Object Repository/Channel Message/Delete Message/div_delete message container - thread'))

	String deleteMessageContainerId = deleteMessageContainer.getAttribute('id')

	Boolean isMessageNeedToDelete = deleteMessageContainerId.contains(messageId)

	if (!(isMessageNeedToDelete)) {
		KeywordUtil.markFailedAndStop("Error message - messageId: '$messageId';  MessageNeedToDelete: '$deleteMessageContainerId'")
	} 
	
	WebUI.click(findTestObject('Object Repository/Channel Message/Delete Message/button_delete - thread'))
} else {
	WebUI.verifyElementPresent(findTestObject('Object Repository/Channel Message/Delete Message/div_delete message container'), 
		10)
	
	WebElement deleteMessageContainer = WebUI.findWebElement(findTestObject('Object Repository/Channel Message/Delete Message/div_delete message container'))
	
	String deleteMessageContainerId = deleteMessageContainer.getAttribute('id')
	
	Boolean isMessageNeedToDelete = deleteMessageContainerId.contains(messageId)
		
	if (!(isMessageNeedToDelete)) {
		KeywordUtil.markFailedAndStop("Error message - messageId: '$messageId';  MessageNeedToDelete: '$deleteMessageContainerId'")
	}
	
	WebUI.click(findTestObject('Object Repository/Channel Message/Delete Message/button_delete'))
}

String messageDeletedXpath = "//*[@id='$messageId']"

TestObject messageDeletedObj = CustomKeywords.'mezon.GetTestObject.withXpath'(messageDeletedXpath)

WebUI.verifyElementNotPresent(messageDeletedObj, 15)

