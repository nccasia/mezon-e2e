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
import java.nio.file.Files as Files
import java.nio.file.Paths as Paths

WebUI.callTestCase(findTestCase('Steps/Channel Message/Select channel'), [:], FailureHandling.STOP_ON_FAILURE)

String imagePath = CustomKeywords.'mezon.File.getPath'('\\Data Files\\Image\\logo NCC.png')

WebUI.uploadFile(findTestObject('Channel Message/Send Media/input_upload'), imagePath)

CustomKeywords.'mezon.SendText.sendText'(findTestObject('Channel Message/Send message with link/textarea_Clan T_general channel'), ' ')

Boolean isSending = CustomKeywords.'mezon.SendingMessage.isSendingMessage'()

if (isSending) {
    WebUI.takeScreenshot()
    KeywordUtil.markFailedAndStop('Sending message failed')
}

WebUI.rightClick(findTestObject('Channel Message/Save image/img_message'))

if (GlobalVariable.isDirectMessage) {
    WebUI.click(findTestObject('Object Repository/Direact Message/Save image/Button_save image'))
} else {
    WebUI.click(findTestObject('Channel Message/Save image/div_save image'))
}

String home = System.getProperty('user.home')

String userDownloads = new File(home + '/Downloads/')

CustomKeywords.'mezon.VerifySaveImage.verifySaveImage'(userDownloads, 'image')



