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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.callTestCase(findTestCase('Steps/Channel Message/Pin message'), [:], FailureHandling.STOP_ON_FAILURE)

String textPinMessage = ''

if (GlobalVariable.isThread) {
    WebUI.click(findTestObject('Channel Message/Jump to pin message/button_pin panel_Thread'))

    textPinMessage = getTextPinMessage(findTestObject('Channel Message/Jump to pin message/div_text pin message_thread'))

    WebUI.click(findTestObject('Channel Message/Jump to pin message/button_jump_thread'))
} else if (GlobalVariable.isChannelPrivate) {
    WebUI.click(findTestObject('Channel Message/Jump to pin message/button_pin panel channel Private'))

    textPinMessage = getTextPinMessage(findTestObject('Channel Message/Jump to pin message/div_text pin message_channel private'))

    WebUI.click(findTestObject('Channel Message/Jump to pin message/button_jump_channel private'))
} else {
    WebUI.click(findTestObject('Channel Message/Jump to pin message/button_pin panel channel Public'))

    textPinMessage = getTextPinMessage(findTestObject('Channel Message/Jump to pin message/div_text pin message_channel public'))

    WebUI.click(findTestObject('Channel Message/Jump to pin message/button_jump_channel public'))
}

WebUI.takeScreenshot()

WebUI.verifyElementPresent(findTestObject('Object Repository/Channel Message/Jump to pin message/div_message jumped'), 10)

WebElement messageJumpedElement = WebUI.findWebElement(findTestObject('Object Repository/Channel Message/Jump to pin message/div_message jumped'))

String textMessage = messageJumpedElement.getAttribute('innerText')

WebUI.takeScreenshot()

if (!(textMessage.contains(textPinMessage))) {
    KeywordUtil.markFailed("Error jump to pin message! - textMessage: '$textMessage'; textPinMessage: '$textPinMessage'")
}

println "Error jump to pin message! - textMessage: '$textMessage'; textPinMessage: '$textPinMessage'"
def getTextPinMessage(TestObject pinMessageObj) {
    WebElement pinMessageElement = WebUI.findWebElement(pinMessageObj)

    String text = pinMessageElement.getAttribute('innerText')

    return text
}

