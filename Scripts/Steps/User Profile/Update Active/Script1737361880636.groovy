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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import org.openqa.selenium.WebElement as WebElement

WebUI.callTestCase(findTestCase('Steps/Login_Logout and SignUp/Login with email and password'), [('email') : 'E2E1762357@ncc.asia'
        , ('password') : 'E2E1762357'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('User Profile/Update Active/div_Account'))

WebUI.click(findTestObject('User Profile/Update Active/div_active'))

WebElement activeOptionElement = WebUI.findWebElement(findTestObject('User Profile/Update Active/div_Active Option'))

String activeOption = activeOptionElement.getText()

activeOptionElement.click()

WebUI.click(findTestObject('User Profile/Update Active/div_Clear Time'))

Boolean verifyActiveChanged = false

String currentActive

for(int i = 0; i < 15; i++) {
	WebElement activeElement = WebUI.findWebElement(findTestObject('User Profile/Update Active/div_active'))
	currentActive = activeElement.getText()
	if(currentActive.equals(activeOption)) {
		verifyActiveChanged = true
		break
	}
	WebUI.delay(1)
}

if(!verifyActiveChanged) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailed("Error active - activeOption: $activeOption; currentActive: $currentActive")
}

