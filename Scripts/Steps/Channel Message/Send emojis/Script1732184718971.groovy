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

WebUI.callTestCase(findTestCase('Steps/Login_Logout and SignUp/Login with email and password'), [('email') : 'E2E1762357@ncc.asia'
        , ('password') : 'E2E1762357'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/div_channel T'))

WebUI.click(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/Button_Emojis pannel'))

TestObject emojiObj = findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/emoji3')

String emojiHref = WebUI.findWebElement(emojiObj, 0).findElement(By.tagName('img')).getAttribute('src')

WebUI.click(emojiObj)

WebUI.sendKeys(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/textarea__channel T'), Keys.chord(Keys.ENTER))

WebUI.verifyElementPresent(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/div_latest message'), 
    5)

String messageContainerXpath = '//*[@id=\'scrollLoading\']'

messageContainerObj = CustomKeywords.'mezon.GetTestObject.withXpath'(messageContainerXpath)

CustomKeywords.'mezon.VerifyHrefImgExists.verifyHrefImgExists'(messageContainerObj, emojiHref)

if (CustomKeywords.'mezon.SendingMessage.isSendingMessage'()) {
    KeywordUtil.markFailed('Message sending failed')
}

