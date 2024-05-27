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

'check rotaion between buttons'
WebUI.click(findTestObject('Object Repository/Channel Message/Send emoji, sticker, GIF/Page_Mezon/button_Emoji'))

WebUI.click(findTestObject('Object Repository/Channel Message/Send emoji, sticker, GIF/Page_Mezon/button_Gifs'))

WebUI.click(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/button_Stickers'))

WebUI.click(findTestObject('Object Repository/Channel Message/Send emoji, sticker, GIF/Page_Mezon/button_Emoji'))

WebUI.click(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/emoji'))

WebUI.click(findTestObject('Object Repository/Channel Message/Send emoji, sticker, GIF/Page_Mezon/button_Emoji'))

WebUI.click(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/emoji1'))

WebUI.click(findTestObject('Object Repository/Channel Message/Send emoji, sticker, GIF/Page_Mezon/button_Emoji'))

WebUI.click(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/emoji2'))

WebUI.sendKeys(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/textarea_'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/button_Stickers'))

WebUI.click(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/Stickers'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/button_Stickers'))

WebUI.click(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/Sticker2'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Channel Message/Send emoji, sticker, GIF/Page_Mezon/button_Gifs'))

WebUI.click(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/group_GIF'))

WebUI.click(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/GIF'))

