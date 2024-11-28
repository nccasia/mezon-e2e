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
import org.openqa.selenium.By as By
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver

WebUI.callTestCase(findTestCase('Steps/Channel Message/Send Message Text'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/div_lastest message'))

WebUI.click(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/button_more'))

WebUI.click(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/button_Forward option'))

WebUI.waitForElementPresent(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/div_Forward_modal'), 
    5)

WebUI.setText(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/input_forward modal_search'), 'channel')

WebUI.check(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/input_general_checkbox-item to forward'))

WebUI.click(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/button_Forward message_send'))

WebDriver driver = DriverFactory.getWebDriver()

WebElement Toast = WebUI.findWebElement(findTestObject('Channel Message/Edit, Reply, Forward, Copy, Delete Message/div_toast'), 5)

WebElement Toast_success = driver.findElement(By.className('Toastify__toast--success'))


