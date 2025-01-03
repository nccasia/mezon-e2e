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

WebUI.callTestCase(findTestCase('Steps/Login_Logout and SignUp/Login with email and password'), [('email') : 'E2E1762357@ncc.asia'
        , ('password') : 'E2E1762357'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Direact Message/Select conversation/input_search conversation'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Direact Message/Select conversation/input_search'), 
	15, FailureHandling.STOP_ON_FAILURE)

if (GlobalVariable.isDirectMessage) {
	WebUI.setText(findTestObject('Object Repository/Direact Message/Select conversation/input_search'), '@')
} else {
	WebUI.setText(findTestObject('Object Repository/Direact Message/Select conversation/input_search'), 'Group test')
}

WebUI.verifyElementPresent(findTestObject('Object Repository/Direact Message/Select conversation/span_conversation'),
	15, FailureHandling.STOP_ON_FAILURE)

WebElement conversationElement = WebUI.findWebElement(findTestObject('Object Repository/Direact Message/Select conversation/span_conversation'))

String conversationName = conversationElement.getText()

WebUI.click(findTestObject('Object Repository/Direact Message/Select conversation/div_converstion'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Direact Message/Select conversation/header_conversation name'),
	15, FailureHandling.STOP_ON_FAILURE)

WebElement conversationTitleElement = WebUI.findWebElement(findTestObject('Object Repository/Direact Message/Select conversation/header_conversation name'))

String conversationTitle = conversationTitleElement.getText()

WebUI.takeScreenshot()

if (conversationName != conversationTitle) {
	KeywordUtil.markFailed("Error conversation - conversationName: '$conversationName'; conversationTitle: '$conversationTitle'")
}

