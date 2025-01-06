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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.callTestCase(findTestCase('Steps/Channel Message/Select channel'), [:], FailureHandling.STOP_ON_FAILURE)

String stickerHref

if(GlobalVariable.isDirectMessage) {
	WebUI.click(findTestObject('Object Repository/Direact Message/Send Sticker/button_Sticker pannel'))
	
	WebUI.verifyElementPresent(findTestObject('Object Repository/Direact Message/Send emoji/div_emojis display'), 15)

	stickerHref = WebUI.findWebElement(findTestObject('Object Repository/Direact Message/Send Sticker/img_sticker')).getAttribute('src')
	
	WebUI.click(findTestObject('Object Repository/Direact Message/Send Sticker/img_sticker'))
} else {
	WebUI.click(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/button_sticker pannel'))	

	WebUI.verifyElementPresent(findTestObject('Object Repository/Channel Message/Send emoji, sticker, GIF/Page_Mezon/div_gif, emoji sticker display'), 15)
	
	stickerHref = WebUI.findWebElement(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/img_Sticker')).getAttribute('src')
	
	WebUI.click(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/img_Sticker'))
}


Boolean isSending = CustomKeywords.'mezon.SendingMessage.isSendingMessage'()

WebUI.takeScreenshot()

if (isSending) {
	KeywordUtil.markFailedAndStop("Sending sticker failed")
}

CustomKeywords.'mezon.VerifyHrefImgExists.verifyHrefImgExists'(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/div_lasted'), stickerHref)
