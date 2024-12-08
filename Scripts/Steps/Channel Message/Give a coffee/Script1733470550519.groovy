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

WebUI.callTestCase(findTestCase('Steps/Login_Logout and SignUp/Login with email and password'), [('email') : 'E2E1762357@ncc.asia'
        , ('password') : 'E2E1762357'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Channel Message/Give a coffee/div_Clan T'))

WebUI.click(findTestObject('Channel Message/Give a coffee/div_Clan T_ test give a coffee channel'))

try {
	WebUI.verifyElementPresent(findTestObject('Channel Message/Give a coffee/div_react give a coffee'), 0)
	
	TestObject reactGiveACoffeeObj = findTestObject('Channel Message/Give a coffee/div_react give a coffee')
	
	Number reactGiveACoffeeQuantity = Integer.valueOf(WebUI.findWebElement(reactGiveACoffeeObj).getText())
		
	WebUI.rightClick(findTestObject('Channel Message/Give a coffee/div_message'))
		
	WebUI.click(findTestObject('Channel Message/Give a coffee/div_give a coffee'))
		
	Number reactGiveACoffeeQuantityCurrent = Integer.valueOf(WebUI.findWebElement(reactGiveACoffeeObj).getText())
		
	if (reactGiveACoffeeQuantityCurrent - reactGiveACoffeeQuantity <= 0) {
		KeywordUtil.markFailedAndStop("Failed")
	}
} catch (error) {
	WebUI.rightClick(findTestObject('Channel Message/Give a coffee/div_message'))
	
	WebUI.click(findTestObject('Channel Message/Give a coffee/div_give a coffee'))
	
	TestObject reactGiveACoffeeObj = findTestObject('Channel Message/Give a coffee/div_react give a coffee')
	
	Number reactGiveACoffeeQuantity = Integer.valueOf(WebUI.findWebElement(reactGiveACoffeeObj).getText())
	
	if ( reactGiveACoffeeQuantity != 1) {
		KeywordUtil.markFailedAndStop("Failed")
	}
}


