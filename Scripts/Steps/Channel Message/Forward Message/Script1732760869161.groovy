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

WebUI.callTestCase(findTestCase('Steps/Channel Message/Send Message Text'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/div_latest message'))

WebUI.click(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/button_more'))

if(GlobalVariable.isDirectMessage) {
	WebUI.click(findTestObject('Object Repository/Direact Message/Forward message/button_forward message'))
} else {
	WebUI.click(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/button_Forward option'))
}

WebUI.setText(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/input_forward modal_search'), '#')

WebUI.check(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/checkBox_forward message to channel'))

WebUI.click(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/button_Forward message_send'))

WebUI.waitForElementPresent(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/div_toast container_ forward message to chanel'), 
    10)

WebUI.takeScreenshot()

WebUI.verifyElementPresent(findTestObject('Channel Message/Forward message to DM/Toast success'), 10)
