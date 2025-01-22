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

String fileName = 'File test.txt'

String filePath = CustomKeywords.'mezon.File.getPath'('\\Data Files\\Files Upload\\') + fileName

WebUI.uploadFile(findTestObject('Channel Message/Send file/input_upload file'), filePath)

WebUI.verifyElementPresent(findTestObject('Object Repository/Channel Message/Send text to large for convert to file txt/p_file name'), 
    15)

CustomKeywords.'mezon.SendText.sendText'(findTestObject('Channel Message/Send file/textarea_Clan T_general channel'), ' ')

Boolean isSending = CustomKeywords.'mezon.SendingMessage.isSendingMessage'()

if (isSending) {
    WebUI.takeScreenshot()

    KeywordUtil.markFailedAndStop('Sending file failed')
}

WebElement spanSentMessage = WebUI.findWebElement(findTestObject('Channel Message/Send file/span_sent message'))

String sentMessage = spanSentMessage.getText()

if (sentMessage != fileName) {
    WebUI.takeScreenshot()

    KeywordUtil.markFailed("Error message - sentMessage: '$sentMessage'; fileName: '$fileName'")
}



