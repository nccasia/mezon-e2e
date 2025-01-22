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
import java.awt.Toolkit as Toolkit
import java.awt.datatransfer.StringSelection as StringSelection

WebUI.callTestCase(findTestCase('Steps/Channel Message/Select channel'), [:], FailureHandling.STOP_ON_FAILURE)

String text = 'send message with markdown'

StringSelection MessageWithMarkdown = new StringSelection("$markdownType\n$text\n$markdownType")

Toolkit.getDefaultToolkit().getSystemClipboard().setContents(MessageWithMarkdown, null)

WebUI.sendKeys(findTestObject('Object Repository/Channel Message/Send text to large for convert to file txt/textarea_Clan T_general channel'),
	Keys.chord(Keys.CONTROL + 'v'))

WebUI.sendKeys(findTestObject('Object Repository/Channel Message/Send text to large for convert to file txt/textarea_Clan T_general channel'),
	Keys.chord(Keys.ENTER))

WebUI.delay(2)

Boolean isSending = CustomKeywords.'mezon.SendingMessage.isSendingMessage'()

if (isSending) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailedAndStop("Send Message With Markdown failed")
}

Boolean verifySendMessageWithMarkdown = false

if (markdownType.equals("```")) {
	WebUI.verifyElementPresent(findTestObject('Object Repository/Channel Message/Send Message With Markdown/div_triple markdown'),
			1)	
} else {
	WebUI.verifyElementPresent(findTestObject('Object Repository/Channel Message/Send Message With Markdown/span_single markdown'),
			1)
}

WebElement MessageWithMarkdownElement = WebUI.findWebElement(findTestObject('Object Repository/Channel Message/Send Message With Markdown/div_Message'))

String message = MessageWithMarkdownElement.getText()

if (message.equals(text)) {
	verifySendMessageWithMarkdown = true
}

if (!verifySendMessageWithMarkdown) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailedAndStop("Message is wrong!")
}

