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

CustomKeywords.'mezon.SendText.sendText'(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/textarea_clanT_general'), 
    'chi Phuong xinh dep', Keys.chord(Keys.ENTER))

TestObject divLastedObj = findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/div_lasted')

WebElement divLastedElm = WebUI.findWebElement(divLastedObj)

String idMessage = divLastedElm.getAttribute('id')

String spanLasted = "//*[@id='$idMessage']/div[1]/div[2]/div/div[2]/div[2]/div/div/div/div/div/div/span/span"

WebUI.mouseOver(divLastedObj)

WebUI.click(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/edit_btn'))

WebUI.sendKeys(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/textarea_need_edit'), Keys.chord(
        Keys.CONTROL, 'a'))

String editMessage = 'hehe'

WebUI.sendKeys(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/textarea_need_edit'), editMessage)

WebUI.sendKeys(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/textarea_need_edit'), Keys.chord(
        Keys.ENTER))

TestObject spanLastedObj = CustomKeywords.'mezon.GetTestObject.withXpath'(spanLasted)

WebElement spanLastedElm = WebUI.findWebElement(spanLastedObj)

if (editMessage == spanLastedElm.getText()) {
    KeywordUtil.markPassed('pass')
} else {
    KeywordUtil.markFailed('fail')
}


