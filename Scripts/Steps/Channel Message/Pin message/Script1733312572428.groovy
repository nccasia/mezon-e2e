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
import org.openqa.selenium.WebElement

WebUI.callTestCase(findTestCase('Steps/Channel Message/Select channel'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/textarea__channel T'))

WebUI.sendKeys(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/textarea__channel T'), 'Hi, Nguyen Phuoc Nguyen - message in thread')

WebUI.sendKeys(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/textarea__channel T'), Keys.chord(Keys.ENTER))

WebUI.rightClick(findTestObject('Channel Message/Channel message - Pin message/Last-msg'))

WebUI.click(findTestObject('Channel Message/Channel message - Pin message/div_Pin Message'))

WebUI.click(findTestObject('Channel Message/Channel message - Pin message/button_Oh yeah. Pin it'))


if (GlobalVariable.isChannelPrivate) {
	
	TestObject buttonPinMsgObj = CustomKeywords.'mezon.GetTestObject.withXpath'('//*[@id="main-layout"]/div/div[3]/div/div[1]/div[2]/div/div[1]/div[1]/div[6]')
	
	WebElement buttonPinMsgElement = WebUI.findWebElement(buttonPinMsgObj)
	
	buttonPinMsgElement.click()
	
} 
else {
	TestObject buttonPinMsgObj = CustomKeywords.'mezon.GetTestObject.withXpath'('//*[@id="main-layout"]/div/div[3]/div/div[1]/div[2]/div/div[1]/div[1]/div[5]')
	 
	 WebElement buttonPinMsgElement = WebUI.findWebElement(buttonPinMsgObj)
	 
	 buttonPinMsgElement.click()
}
