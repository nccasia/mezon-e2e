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
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.callTestCase(findTestCase('Steps/Channel Message/Select channel'), [:], FailureHandling.STOP_ON_FAILURE)

String fileMediaPath = CustomKeywords.'mezon.File.getPath'('\\Data Files\\Media Upload\\Video1.mp4') 

List<String> filePaths = [fileMediaPath, fileMediaPath]

String combinedFilePaths = filePaths.join('\n')

WebUI.uploadFile(findTestObject('Channel Message/Send file/input_upload file'), combinedFilePaths)

WebUI.sendKeys(findTestObject('Channel Message/Send file/textarea_Clan T_general channel'), Keys.chord(Keys.ENTER))

Boolean isSending = CustomKeywords.'mezon.SendingMessage.isSendingMessage'()

if (isSending) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailedAndStop("Sending files failed")
}

WebElement latestMessageElement = WebUI.findWebElement(findTestObject('Channel Message/Send multiple file media/div_latest message'))

List<WebElement> videoTagList = latestMessageElement.findElements(By.tagName('video'))


if (filePaths.size() != videoTagList.size()) {
	WebUI.takeScreenshot()
    KeywordUtil.markFailed('Miss file media!')
}

