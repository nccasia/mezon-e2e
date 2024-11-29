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
import com.kms.katalon.core.testobject.ConditionType as ConditionType

WebUI.callTestCase(findTestCase('Steps/Login_Logout and SignUp/Login with email and password'), [('email') : 'E2E1762357@ncc.asia'
        , ('password') : 'E2E1762357'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/div_channel T'))

WebUI.click(findTestObject('Object Repository/Channel Message/Send emoji, sticker, GIF/Page_Mezon/p_general'))

WebUI.click(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/div_sticker'))

TestObject stickerObj = findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/img_Emoji_w-full h-full aspect-square objec_3400aa')

String stickerHref = WebUI.findWebElement(stickerObj, 0).getAttribute('src')

WebUI.click(stickerObj)

String messageContainerXpath = '//*[@id=\'scrollLoading\']'

messageContainerObj = getTestObjectWithXpath(messageContainerXpath)

CustomKeywords.'mezon.VerifyHrefImgExists.verifyHrefImgExists'(messageContainerObj, stickerHref)

static TestObject getTestObjectWithXpath(String xpath) {
    return new TestObject().addProperty('xpath', ConditionType.EQUALS, xpath)
}

