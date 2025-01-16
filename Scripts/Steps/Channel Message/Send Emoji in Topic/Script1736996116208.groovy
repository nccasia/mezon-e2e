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

WebUI.callTestCase(findTestCase('Steps/Channel Message/Create and send msg to topic'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Channel Message/Send Emoji in Topic/button_Emoji Pannel'))

WebElement emojiElement = WebUI.findWebElement(findTestObject('Channel Message/Send Emoji in Topic/img_Emoji'))

String emojiSrc = emojiElement.getAttribute('src')

emojiElement.click()

WebUI.sendKeys(findTestObject('Channel Message/Send Emoji in Topic/textarea_Topic'), Keys.chord(Keys.ENTER))

Boolean isSending = CustomKeywords.'mezon.SendingMessage.isSendingMessage'(findTestObject('Object Repository/Channel Message/Send Emoji in Topic/div_latest message'))

if(isSending) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailedAndStop("Message is sending!")
}

WebElement emojiMessageElement = WebUI.findWebElement(findTestObject('Object Repository/Channel Message/Send Emoji in Topic/img_Emoji Message'))

String emojiMessageSrc = emojiMessageElement.getAttribute("src")

if (!emojiMessageSrc.equals(emojiSrc)) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailed("Error emoji!")
}
