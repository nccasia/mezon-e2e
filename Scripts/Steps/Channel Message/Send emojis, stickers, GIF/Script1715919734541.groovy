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

WebUI.click(findTestObject('Object Repository/Channel Message/Send emoji, stricker, GIF/Page_Mezon/div_'))

WebUI.click(findTestObject('Object Repository/Channel Message/Send emoji, stricker, GIF/Page_Mezon/span_Test Clan'))

WebUI.uploadFile(findTestObject('Channel Message/Upload files'), Emoji1)

WebUI.uploadFile(findTestObject('Channel Message/Upload files'), Sticker1)

WebUI.click(findTestObject('Channel Message/Send emoji, stricker, GIF/Page_Mezon/textarea_'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Channel Message/Send emoji, stricker, GIF/Page_Mezon/textarea_'), Keys.chord(Keys.ENTER))

WebUI.uploadFile(findTestObject('Channel Message/Upload files'), GIF1)

WebUI.click(findTestObject('Channel Message/Page_Mezon/textarea_1'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Channel Message/Page_Mezon/textarea_1'), Keys.chord(Keys.ENTER))

WebUI.uploadFile(findTestObject('Channel Message/Upload files'), Emoji2)

WebUI.uploadFile(findTestObject('Channel Message/Upload files'), Emoji3)

WebUI.uploadFile(findTestObject('Channel Message/Upload files'), Emoji3)

WebUI.click(findTestObject('Channel Message/Page_Mezon/textarea_1'))

WebUI.sendKeys(findTestObject('Channel Message/Send emoji, stricker, GIF/Page_Mezon/textarea_'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Channel Message/Send emoji, stricker, GIF/Page_Mezon/button_Stickers'))

WebUI.click(findTestObject('Object Repository/Channel Message/Send emoji, stricker, GIF/Page_Mezon/button_Gifs'))

WebUI.click(findTestObject('Object Repository/Channel Message/Send emoji, stricker, GIF/Page_Mezon/button_Emoji'))

WebUI.uploadFile(findTestObject('Channel Message/Upload files'), Emoji1)

WebUI.click(findTestObject('Channel Message/Page_Mezon/textarea_1'))

WebUI.sendKeys(findTestObject('Channel Message/Page_Mezon/textarea_1'), Keys.chord(Keys.ENTER))

