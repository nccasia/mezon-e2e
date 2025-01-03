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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

WebUI.callTestCase(findTestCase('Steps/Channel Message/Select channel'), [:], FailureHandling.STOP_ON_FAILURE)

String filePath = RunConfiguration.getProjectDir().replace('/', '\\') + '\\Data Files\\Image\\logo NCC.png'

WebUI.uploadFile(findTestObject('Channel Message/Send file/input_upload file'), filePath)

WebUI.sendKeys(findTestObject('Channel Message/Send text to large for convert to file txt/textarea_Clan T_general channel'), 
    Keys.chord(Keys.ENTER))

Boolean isSending = CustomKeywords.'mezon.SendingMessage.isSendingMessage'()


if(isSending) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailedAndStop("Sending image failed!")
}

WebUI.takeScreenshot()

WebUI.verifyElementPresent(findTestObject('Channel Message/Send Media/img_latest message'), 10)


