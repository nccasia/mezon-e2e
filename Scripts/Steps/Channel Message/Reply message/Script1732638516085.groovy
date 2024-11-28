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

WebUI.callTestCase(findTestCase('Steps/Channel Message/Send Message Text'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/div_latest message'), 
    5)

WebUI.mouseOver(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/div_latest message'))

WebUI.click(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/button_more'))

WebUI.click(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/buttion_more_reply'))

WebUI.verifyElementVisible(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/div_Replying to'))

CustomKeywords.'mezon.SendText.sendText'(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/textarea__channel T'), 
    'toi la bot', Keys.chord(Keys.ENTER))

WebUI.waitForElementVisible(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/div_latest message'), 
    5)

WebUI.verifyTextPresent('toi la bot', true)

