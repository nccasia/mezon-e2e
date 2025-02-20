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
import org.openqa.selenium.By as By
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.callTestCase(findTestCase('Steps/Channel Message/Select channel'), [:], FailureHandling.STOP_ON_FAILURE)

String message_text = 'siuuu'

WebUI.setText(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/textarea__channel T'), message_text)

WebElement emoji1Button

if(GlobalVariable.isDirectMessage) {
	WebUI.click(findTestObject('Object Repository/Direact Message/Send emoji/button_emoji pannel'))
	
	WebUI.verifyElementPresent(findTestObject('Object Repository/Direact Message/Send emoji/div_emojis display'), 10)
	
	emoji1Button = WebUI.findWebElement(findTestObject('Object Repository/Direact Message/Send emoji/img_emoji'))
} else {
	WebUI.click(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/button_Emojis pannel'))	

	WebUI.verifyElementPresent(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/Emojis Pannel'), 10)

	emoji1Button = WebUI.findWebElement(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/emoji1'))
}

WebElement emojiImg = emoji1Button.findElement(By.tagName('img'))

String srcImg_emoji = emojiImg.getAttribute('src')

emoji1Button.click()

WebUI.sendKeys(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/textarea__channel T'), Keys.chord(Keys.ENTER))

Boolean isSending = CustomKeywords.'mezon.SendingMessage.isSendingMessage'()

if (isSending) {
	WebUI.takeScreenshot()
	
    KeywordUtil.markFailedAndStop('Sending message failed')
}

WebElement message_emoji = WebUI.findWebElement(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/div_Message with Emoji'))

String sentMess = message_emoji.getText()

WebElement img_tag = message_emoji.findElement(By.tagName('img'))

String hrefImg = img_tag.getAttribute('src')

if ((sentMess != message_text) && (hrefImg != srcImg_emoji)) {
	WebUI.takeScreenshot()
	
    KeywordUtil.markFailed("Error message - sentMess: '$sentMess'; message_text: '$message_text'; hrefImg: '$hrefImg'; srcImg_emoji: '$srcImg_emoji'")
}

