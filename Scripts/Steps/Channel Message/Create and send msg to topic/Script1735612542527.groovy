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

WebUI.mouseOver(findTestObject('Channel Message/Forward message to DM/div_latest_message'))

WebUI.click(findTestObject('Channel Message/Forward message to DM/button_more'))

WebUI.click(findTestObject('Channel Message/Create and send msg to topic/button_Topic discussion'))

String message =  "topic discussion"

CustomKeywords.'mezon.SendText.sendText'(findTestObject('Channel Message/Create and send msg to topic/textarea_topic discussion'), 
    message, Keys.chord(Keys.ENTER))

Boolean isSendMessageSuccess = false

for (int i = 0; i < 15; i++) {
	isSendMessageSuccess = WebUI.verifyElementInViewport(findTestObject('Object Repository/Channel Message/Create and send msg to topic/div_msg container'), 
		1, FailureHandling.OPTIONAL)
			
	if(isSendMessageSuccess) {
		break
	}
}

WebUI.takeScreenshot()

if(!isSendMessageSuccess) {
	KeywordUtil.markFailedAndStop("Sending message failed")
}

WebElement spanLatestMessageElement = WebUI.findWebElement(findTestObject('Object Repository/Channel Message/Create and send msg to topic/span_latest message'))

String spanLatestMessage = spanLatestMessageElement.getText()

WebUI.takeScreenshot()

if (spanLatestMessage != message) {
	KeywordUtil.markFailed("Error message - spanLatestMessage: '$spanLatestMessage'; message: '$message'")
}
