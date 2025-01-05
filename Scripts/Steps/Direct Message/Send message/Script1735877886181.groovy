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

WebUI.callTestCase(findTestCase('Steps/Direct Message/Select conversation'), [:], FailureHandling.STOP_ON_FAILURE);

String message = 'xin chao';

CustomKeywords.'mezon.SendText.sendText'(findTestObject('Direact Message/usual/main chat_textarea'), message, Keys.chord(Keys.ENTER));

Boolean isSending =  CustomKeywords.'mezon.SendingMessage.isSendingMessage'();

WebUI.takeScreenshot();

if(isSending) {
	KeywordUtil.markFailedAndStop("Sending message failed");
}

String sentMessage =  WebUI.findWebElement(findTestObject('Object Repository/Direact Message/usual/span_message')).getText()

if(sentMessage != message) {
	KeywordUtil.markFailed("Error message! - message: '$message'; sentMessage: '$sentMessage'");
}
