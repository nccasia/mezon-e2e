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
import internal.GlobalVariable

import org.openqa.selenium.By
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.util.KeywordUtil
import org.openqa.selenium.WebElement
import com.kms.katalon.core.util.KeywordUtil


WebUI.callTestCase(findTestCase('Steps/Channel Message/Send Message Text'), [:], FailureHandling.STOP_ON_FAILURE)

TestObject object = findTestObject('Channel Message/Reaction Message/div_latest message')

WebUI.mouseOver(object)

WebUI.click(findTestObject('Channel Message/Reaction Message/button_reaction_pannel'))

TestObject button_reaction_Obj = findTestObject('Channel Message/Reaction Message/button_reaction')

String reactionHref = WebUI.findWebElement(button_reaction_Obj).findElement(By.tagName("img")).getAttribute("src")

WebUI.click(button_reaction_Obj)

WebUI.waitForElementVisible(findTestObject('Channel Message/Reaction Message/div_reacted'), 3)

message = WebUI.findWebElements(object, 3)

messageId = WebUI.getAttribute(object, 'id')

reactionXpath = "//*[@id='${messageId}']/div[2]/div/div"


public static TestObject getTestObjectWithXpath(String xpath) {
	return new TestObject().addProperty('xpath', ConditionType.EQUALS, xpath)
}

reactionObj = getTestObjectWithXpath(reactionXpath)

WebUI.verifyElementVisible(reactionObj)

WebElement reactionList = WebUI.findWebElement(reactionObj, 0)

List<WebElement> imgTags = reactionList.findElements(By.tagName('img'))

boolean  flag = false

for (WebElement img : imgTags) { 
	String imgSrc = img.getAttribute('src')
	if(reactionHref == imgSrc) {
		flag = true
	}
}

if (flag) {
	KeywordUtil.markPassed("correct!")
} else {
	println('false')
	KeywordUtil.markFailed("incorrect!")
}









