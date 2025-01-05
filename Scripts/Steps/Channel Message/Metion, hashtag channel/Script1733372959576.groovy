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

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Channel Message/Mention, hashtag/textearea_Clan T_general'), '@')

if(GlobalVariable.isDirectMessage) {
	WebUI.verifyElementPresent(findTestObject('Object Repository/Direact Message/Mention Role/div_suggestions'), 15)
	
	WebUI.click(findTestObject('Object Repository/Direact Message/Mention Role/li_suggestion'))
} else {
	WebUI.verifyElementPresent(findTestObject('Object Repository/Channel Message/Mention Role/div_suggestions display'), 15)	
	
	WebUI.click(findTestObject('Channel Message/Mention, hashtag/li_mention'))
}


String mentionText = WebUI.findWebElement(findTestObject('Channel Message/Mention, hashtag/textearea_Clan T_general')).getText().trim()

WebUI.sendKeys(findTestObject('Channel Message/Mention, hashtag/textearea_Clan T_general'), Keys.chord(Keys.ENTER))

Boolean isSending = CustomKeywords.'mezon.SendingMessage.isSendingMessage'()

WebUI.takeScreenshot()

if(isSending) {
	KeywordUtil.markFailedAndStop('Sending message failed')
}

WebElement buttonMetionElement = WebUI.findWebElement(findTestObject('Channel Message/Mention, hashtag/button_mention'))

String buttonMetionText = buttonMetionElement.getText().trim()

WebUI.takeScreenshot()

if (buttonMetionText != mentionText) {
    KeywordUtil.markFailed("buttonMetionText: '${buttonMetionText}'; mentionText: '${mentionText}'")
}

WebUI.click(findTestObject('Channel Message/Mention, hashtag/button_mention'))

WebUI.takeScreenshot()

WebUI.verifyElementPresent(findTestObject('Channel Message/Mention, hashtag/div_popup'), 10)

WebUI.click(findTestObject('Channel Message/Mention, hashtag/textearea_Clan T_general'))

WebUI.setText(findTestObject('Channel Message/Mention, hashtag/textearea_Clan T_general'), '#')

if (GlobalVariable.isDirectMessage) {
	WebUI.verifyElementPresent(findTestObject('Object Repository/Direact Message/Mention Role/div_suggestions'), 15)
	
	WebUI.click(findTestObject('Object Repository/Direact Message/Mention Role/li_suggestion'))
} else {
	WebUI.verifyElementPresent(findTestObject('Object Repository/Channel Message/Mention Role/div_suggestions display'), 15)
	
	WebUI.click(findTestObject('Channel Message/Mention, hashtag/li_hashtag'))
}

WebUI.setText(findTestObject('Channel Message/Mention, hashtag/textearea_Clan T_general'), 'mezon')

String hashtagWithMessage = WebUI.findWebElement(findTestObject('Channel Message/Mention, hashtag/textearea_Clan T_general')).getText().replace('#', '').trim()

WebUI.sendKeys(findTestObject('Channel Message/Mention, hashtag/textearea_Clan T_general'), Keys.chord(Keys.ENTER))

isSending = CustomKeywords.'mezon.SendingMessage.isSendingMessage'()

WebUI.takeScreenshot()

if(isSending) {
	KeywordUtil.markFailedAndStop('Sending message failed')
}

WebElement spanLatestMessageElement = WebUI.findWebElement(findTestObject('Channel Message/Mention, hashtag/span_message'))

String LatestMessageText = spanLatestMessageElement.getText()

WebUI.takeScreenshot()

if (LatestMessageText != hashtagWithMessage) {
    KeywordUtil.markFailed("LatestMessageText: '${LatestMessageText}'; hashtagWithMessage: '${hashtagWithMessage}'")
}

