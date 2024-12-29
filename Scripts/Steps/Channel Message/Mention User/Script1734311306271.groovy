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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.callTestCase(findTestCase('Steps/Channel Message/Select channel'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/textarea_clanT_general'), '@')

WebUI.takeScreenshot()

WebUI.verifyElementVisible(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/div_members'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/div_first_member'))

WebUI.setText(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/textarea_clanT_general'), 'Are you OK?')

WebElement textAreaElm = WebUI.findWebElement(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/textarea_clanT_general'))

String testMsg = textAreaElm.getText()

WebUI.sendKeys(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/textarea_clanT_general'), Keys.chord(Keys.ENTER))

Boolean isSending = CustomKeywords.'mezon.SendingMessage.isSendingMessage'()

WebUI.takeScreenshot()

if(isSending) {
	KeywordUtil.markFailedAndStop('Sending message failed')
}

WebElement lastMsgElm = WebUI.findWebElement(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/div_latest message'))

String lastMsg = lastMsgElm.getText()

WebElement mentionUserElm = WebUI.findWebElement(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/div_mention_user_message'))

String metionBg = mentionUserElm.getCssValue('background-color')

String mentionUserMsg = mentionUserElm.getText()

WebUI.takeScreenshot()

if ((lastMsg != testMsg) && ('rgba(60, 66, 112, 1)' != metionBg)) {
    KeywordUtil.markFailed("Error message - lastMsg: '$lastMsg'; testMsg: '$testMsg'; metionBackgroud: $metionBg")
}

WebUI.click(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/button_show_user'))

WebUI.takeScreenshot()

Boolean flag = WebUI.verifyElementPresent(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/div_show_user_profile'), 
    10)

if (!(flag)) {
    KeywordUtil.markFailed('User profile isn\'t present')
}



