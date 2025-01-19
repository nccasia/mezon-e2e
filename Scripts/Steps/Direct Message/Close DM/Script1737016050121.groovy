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
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor

WebUI.callTestCase(findTestCase('Steps/Direct Message/Select conversation'), [:], FailureHandling.STOP_ON_FAILURE)

WebDriver driver = DriverFactory.getWebDriver()

JavascriptExecutor JS = (JavascriptExecutor) driver

WebElement selectedConversationElement = WebUI.findWebElement(findTestObject('Object Repository/Direact Message/Select conversation/div_Selected Conversation'))

String id = 'selected'

JS.executeScript('arguments[0].setAttribute(\'id\', arguments[1]);', selectedConversationElement, id)

String conversationSelectedXpath = "//*[@id='$id']"

TestObject conversationSelectedObj = CustomKeywords.'mezon.GetTestObject.withXpath'(conversationSelectedXpath)

WebUI.mouseOver(findTestObject('Object Repository/Direact Message/Select conversation/div_Selected Conversation'))

WebUI.click(findTestObject("Object Repository/Direact Message/Close DM/button_Close DM"))

WebUI.verifyElementNotPresent(conversationSelectedObj, 15)

