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
import org.openqa.selenium.WebElement as WebElement

WebUI.callTestCase(findTestCase('Steps/Channel Message/Send Message Text'), [:], FailureHandling.STOP_ON_FAILURE)

WebElement sentMessageElement = WebUI.findWebElement(findTestObject('Object Repository/Channel Message/Edit, Reply, Forward, Copy, Delete Message/span_latest mes'))

String sentMessageText = sentMessageElement.getText()

WebUI.mouseOver(findTestObject('Object Repository/Channel Message/Edit, Reply, Forward, Copy, Delete Message/span_latest mes'))

WebUI.rightClick(findTestObject('Object Repository/Channel Message/Edit, Reply, Forward, Copy, Delete Message/span_latest mes'))

if (GlobalVariable.isDirectMessage) {
	WebUI.click(findTestObject('Object Repository/Direact Message/Copy message/button_copy text'))
} else {
	WebUI.click(findTestObject('Object Repository/Channel Message/Copy message/button_copy text'))	
}

WebUI.sendKeys(findTestObject('Object Repository/Channel Message/Edit, Reply, Forward, Copy, Delete Message/textarea_clanT_general'), 
    Keys.chord(Keys.CONTROL + 'v'))

String textCopied = WebUI.getText(findTestObject('Object Repository/Channel Message/Edit, Reply, Forward, Copy, Delete Message/textarea_clanT_general'))

WebUI.takeScreenshot()

if (textCopied != sentMessageText) {
    KeywordUtil.markFailed("Error copy message!- textCopied: '$textCopied'; sentMessageText: '$sentMessageText'")
}

