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
import org.openqa.selenium.By as By

WebUI.callTestCase(findTestCase('Steps/Channel Message/Select channel'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Channel Message/Send text to large for convert to file txt/textarea_Clan T_general channel'))

String emojiHref

if(GlobalVariable.isDirectMessage) {
	WebUI.click(findTestObject('Object Repository/Direact Message/Send emoji/button_emoji pannel'))
	
	WebUI.verifyElementPresent(findTestObject('Object Repository/Direact Message/Send emoji/div_emojis display'), 15)
	
	emojiHref = WebUI.findWebElement(findTestObject('Object Repository/Direact Message/Send emoji/img_emoji')).getAttribute('src')

	WebUI.click(findTestObject('Object Repository/Direact Message/Send emoji/img_emoji'))
} else {
	WebUI.click(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/Button_Emojis pannel'))	
	
	WebUI.verifyElementPresent(findTestObject('Object Repository/Channel Message/Send emoji, sticker, GIF/Page_Mezon/div_emojis list display'), 15)
	
	emojiHref = WebUI.findWebElement(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/emoji3')).findElement(By.tagName('img')).getAttribute('src')
	
	WebUI.click(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/emoji3'))
}

WebUI.sendKeys(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/textarea__channel T'), Keys.chord(Keys.ENTER))

Boolean isSending = CustomKeywords.'mezon.SendingMessage.isSendingMessage'()


if (isSending) {
	WebUI.takeScreenshot()
	
	KeywordUtil.markFailedAndStop("Sending message failed")
}

CustomKeywords.'mezon.VerifyHrefImgExists.verifyHrefImgExists'(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/div_latest message'), emojiHref)
