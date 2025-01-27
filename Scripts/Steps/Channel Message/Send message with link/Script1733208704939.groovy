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

String text = 'mezon:'

String link = 'https://mezon.ai'

String message = "$text $link"

CustomKeywords.'mezon.SendText.sendText'(findTestObject('Channel Message/Send message with link/textarea_Clan T_general channel'), 
    message)

Boolean isSending = CustomKeywords.'mezon.SendingMessage.isSendingMessage'()

if (isSending) {
	WebUI.takeScreenshot()
	
	KeywordUtil.markFailedAndStop("Sending message failed")
}

WebElement spanLatestMessageElement = WebUI.findWebElement(findTestObject('Channel Message/Send message with link/span_latest message'))

String sentMessage = spanLatestMessageElement.getText()

WebElement aTag = spanLatestMessageElement.findElement(By.tagName('a'))

String sentLink = aTag.getText()

if ((link != sentLink) && ( sentMessage!= message)) {
	WebUI.takeScreenshot()
	
    KeywordUtil.markFailed("Error message! - link: '$link'; sentLink: '$sentLink'; sentMessage: '$sentMessage'; message: '$message'")
}

