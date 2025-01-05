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

//WebUI.callTestCase(findTestCase('Steps/Login_Logout and SignUp/Login with email and password'), [('email') : GlobalVariable.email
//        , ('password') : GlobalVariable.password], FailureHandling.STOP_ON_FAILURE)
//
//WebUI.maximizeWindow()
//
//WebUI.click(findTestObject('Object Repository/Channel Message/Edit, Reply, Forward, Copy, Delete Message/div_clan_T'))

WebUI.callTestCase(findTestCase('Steps/Channel Message/Select channel'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/textarea_clanT_general'), '#')

if (GlobalVariable.isDirectMessage) {
	WebUI.verifyElementVisible(findTestObject('Object Repository/Direact Message/Mention Role/div_suggestions'),
		FailureHandling.STOP_ON_FAILURE)

	WebUI.click(findTestObject('Object Repository/Direact Message/Mention Role/li_suggestion'))

} else {
	WebUI.verifyElementVisible(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/div_text_channel'), 
			FailureHandling.STOP_ON_FAILURE)
	
	WebUI.click(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/div_text_channel_general'))
}

WebUI.setText(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/textarea_clanT_general'), '123456')

WebElement textAreaElm = WebUI.findWebElement(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/textarea_clanT_general'))

String testMsg = textAreaElm.getText().replace('#', '')

WebUI.sendKeys(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/textarea_clanT_general'), Keys.chord(Keys.ENTER))

Boolean isSending = CustomKeywords.'mezon.SendingMessage.isSendingMessage'()

WebUI.takeScreenshot()

if (isSending) {
	KeywordUtil.markFailedAndStop("Sending message failed")
}

WebElement lastMsgElm = WebUI.findWebElement(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/div_latest message'))

String lastMsg = lastMsgElm.getText()

WebElement htagMsgElm = WebUI.findWebElement(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/div_hashtag_message'))

String htagMsg = htagMsgElm.getText()

if (lastMsg != testMsg) {
    KeywordUtil.markFailed("Sent message wrong! - lastMsg: '${lastMsg}'; testMsg: '${testMsg}'")
}

