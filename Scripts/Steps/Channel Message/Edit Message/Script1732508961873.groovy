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
    'chi Phuong xinh dep')

WebElement divLastedElm = WebUI.findWebElement(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/div_lasted'))

String idMessage = divLastedElm.getAttribute('id')

WebUI.mouseOver(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/div_lasted'))

WebUI.click(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/button_more'))

if(GlobalVariable.isDirectMessage) {
	WebUI.click(findTestObject('Object Repository/Direact Message/Edit message/button_edit message'))
} else {
	WebUI.click(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/edit_btn'))	
}

String textareaEditMessageXpath = "//*[@id='$idMessage']/div/div[last()]/div/div[1]/div[2]/div/div[2]/div[2]/div/div/div/div/div/div[1]/div/textarea"

TestObject textareaEditMessageElement = CustomKeywords.'mezon.GetTestObject.withXpath'(textareaEditMessageXpath)

WebUI.sendKeys(textareaEditMessageElement, Keys.chord(
        Keys.CONTROL, 'a'))

String editMessage = 'hehe'

WebUI.sendKeys(textareaEditMessageElement, editMessage)

WebUI.takeScreenshot()

WebUI.sendKeys(textareaEditMessageElement, Keys.chord(
        Keys.ENTER))

String spanLasted = "//*[@id='$idMessage']/div/div[last()]/div/div[1]/div[2]/div/div[2]/div[2]/div/div/div/div/div/div/div/span/span"

TestObject spanLastedObj = CustomKeywords.'mezon.GetTestObject.withXpath'(spanLasted)

WebElement spanLastedElm = WebUI.findWebElement(spanLastedObj)

String editedMessage =  spanLastedElm.getText()

verifyEditMessage(idMessage)

if (!editedMessage.equals(editMessage)) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailed("Error edited message - editMessage: $editMessage; editedMessage: $editedMessage")
}

def verifyEditMessage(String idMessage) {
	Boolean isEdited = false
	for(int i = 0; i < 15; i++) {
		String spanEditedXpath = "//*[@id='$idMessage']/div/div[last()]/div/div[1]/div[2]/div/div[2]/div[2]/div/div/div/div/div/div/div/span/p"
				
		TestObject spanEditedObj =  CustomKeywords.'mezon.GetTestObject.withXpath'(spanEditedXpath)
				
		isEdited = WebUI.findWebElement(spanEditedObj).getText().contains('edited')
		if (isEdited) {
			return true
		}
		WebUI.delay(1)
	}
	WebUI.takeScreenshot()
	KeywordUtil.markFailed("Not present edited")
	return false
}

