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

WebUI.callTestCase(findTestCase('Steps/Login_Logout and SignUp/Login with email and password'), [('email') : GlobalVariable.email
        , ('password') : GlobalVariable.password], FailureHandling.STOP_ON_FAILURE)

WebUI.maximizeWindow()

WebUI.click(findTestObject('Object Repository/Channel Message/Edit, Reply, Forward, Copy, Delete Message/div_clan_T'))

WebUI.sendKeys(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/textarea_clanT_general'), '@')

WebUI.verifyElementVisible(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/div_members'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/div_first_member'))

WebUI.setText(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/textarea_clanT_general'), 'Are you OK?')

TestObject textAreaObj = findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/textarea_clanT_general')

WebElement textAreaElm = WebUI.findWebElement(textAreaObj)

String testMsg = textAreaElm.getText()

WebUI.sendKeys(textAreaObj, Keys.chord(Keys.ENTER))

TestObject lastMsgObj = findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/div_latest message')

WebElement lastMsgElm = WebUI.findWebElement(lastMsgObj)

String lastMsg = lastMsgElm.getText()

TestObject mentionUserObj = findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/div_mention_user_message')

WebElement mentionUserElm = WebUI.findWebElement(mentionUserObj)

mentionUserElm.getCssValue('background-color')

String mentionUserMsg = mentionUserElm.getText()

println(mentionUserElm.getCssValue('background-color'))

println(lastMsg)

println(testMsg)

if ((lastMsg == testMsg) && ('rgba(0, 0, 0, 0)' == mentionUserElm.getCssValue('background-color'))) {
    KeywordUtil.markPassed('pass')
} else {
    KeywordUtil.markFailed('fail')
}

WebUI.click(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/button_show_user'))

WebUI.verifyElementVisible(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/div_show_user_profile'))

