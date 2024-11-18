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

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://dev-mezon.nccsoft.vn/')

WebUI.click(findTestObject('Object Repository/Channel Message/Send emoji, sticker, GIF/Page_Mezon/Page_Mezon/a_Login'))

WebUI.setText(findTestObject('Object Repository/Channel Message/Send emoji, sticker, GIF/Page_Mezon/Page_Mezon/input_WELCOME BACK_userEmail'), 
    'E2E1762357@ncc.asia')

WebUI.setEncryptedText(findTestObject('Object Repository/Channel Message/Send emoji, sticker, GIF/Page_Mezon/Page_Mezon/input_WELCOME BACK_password'), 
    '9biZmnmyTHYoxEgCZK4szw==')

WebUI.click(findTestObject('Object Repository/Channel Message/Send emoji, sticker, GIF/Page_Mezon/Page_Mezon/button_Sign in'))

WebUI.click(findTestObject('Object Repository/Channel Message/Send emoji, sticker, GIF/Page_Mezon/Page_Mezon/div_T'))

WebUI.click(findTestObject('Object Repository/Channel Message/Send emoji, sticker, GIF/Page_Mezon/Page_Mezon/p_general'))

WebUI.click(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/svg__darkhovertext-white hovertext-black darktext-AEAEAE text-colorTextLightMode'))

WebUI.click(findTestObject('Object Repository/Channel Message/Send emoji, sticker, GIF/Page_Mezon/Page_Mezon/img_Emoji_w-full h-full aspect-square objec_3400aa'))

