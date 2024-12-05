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

WebUI.click(findTestObject('Channel Message/Mention, hashtag/li_mention'))

TestObject textareaObj = findTestObject('Channel Message/Mention, hashtag/textearea_Clan T_general')

String mentionText = WebUI.findWebElement(textareaObj).getText().trim()

WebUI.sendKeys(textareaObj, Keys.chord(Keys.ENTER))

TestObject buttonMetionObj = findTestObject('Channel Message/Mention, hashtag/button_mention')

WebElement buttonMetionElement = WebUI.findWebElement(buttonMetionObj)

String buttonMetionText = buttonMetionElement.getText().trim()

if (buttonMetionText != mentionText) {
    KeywordUtil.markFailed('Verify mention failed')
}

WebUI.click(buttonMetionObj)

WebUI.waitForElementPresent(findTestObject('Channel Message/Mention, hashtag/div_popup'), 5)

WebUI.click(findTestObject('Channel Message/Mention, hashtag/textearea_Clan T_general'))

WebUI.setText(findTestObject('Channel Message/Mention, hashtag/textearea_Clan T_general'), '#')

WebUI.click(findTestObject('Channel Message/Mention, hashtag/li_hashtag'))

WebUI.setText(findTestObject('Channel Message/Mention, hashtag/textearea_Clan T_general'), 'mezon')

String hashtagWithMessage = WebUI.findWebElement(textareaObj).getText().replace('#', '').trim()

WebUI.sendKeys(textareaObj, Keys.chord(Keys.ENTER))

TestObject spanLatestMessageObj = findTestObject('Channel Message/Mention, hashtag/span_message')

WebElement spanLatestMessageElement = WebUI.findWebElement(spanLatestMessageObj)

String LatestMessageText = spanLatestMessageElement.getText().trim()

if (LatestMessageText != hashtagWithMessage) {
    KeywordUtil.markFailed('Verify hashtag with message')

}

