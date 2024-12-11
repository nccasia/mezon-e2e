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

WebUI.callTestCase(findTestCase('Steps/Login_Logout and SignUp/Login with email and password'), [('email') : 'E2E1762357@ncc.asia'
        , ('password') : 'E2E1762357'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/div_channel T'))

String message_text = 'siuuu'

WebUI.setText(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/textarea__channel T'), message_text)

WebUI.click(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/button_Emojis pannel'))

WebUI.verifyElementPresent(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/Emojis Pannel'), 3)

TestObject img_emoji_object = findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/emoji1')

WebElement emoji1 = WebUI.findWebElement(img_emoji_object)

String srcImg_emoji = emoji1.getAttribute('src')

WebUI.click(img_emoji_object)

WebUI.sendKeys(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/textarea__channel T'), Keys.chord(Keys.ENTER))

WebElement message_emoji = WebUI.findWebElement(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/div_Message with Emoji'))

WebElement img_tag = message_emoji.findElement(By.tagName('img'))

if ((message_emoji.getText() != message_text) && (img_tag.getAttribute('src') != srcImg_emoji)) {
    KeywordUtil.markFailed('FAILED!')
} else if  (CustomKeywords.'mezon.SendingMessage.isSendingMessage'()) {
    KeywordUtil.markFailed('Message sending failed!')
}

