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

WebUI.click(findTestObject('User Profile/Update Custom Status/div_account'))

WebUI.click(findTestObject('User Profile/Update Custom Status/div_Set Custom Status'))

String customStatus = CustomKeywords.'mezon.Random.text'('status')

WebUI.setText(findTestObject('User Profile/Update Custom Status/input_Custom Status'), customStatus)

WebUI.click(findTestObject('User Profile/Update Custom Status/button_Save'))

WebUI.click(findTestObject('User Profile/Update Custom Status/div_account'))

WebUI.verifyElementPresent(findTestObject('Object Repository/User Profile/Update Custom Status/span_Display Custom Status'), 
    15)

WebElement displayCustomStatusElement = WebUI.findWebElement(findTestObject('Object Repository/User Profile/Update Custom Status/span_Display Custom Status'))

String displayCustomStatus = displayCustomStatusElement.getText()

if (!(displayCustomStatus.equals(customStatus))) {
    WebUI.takeScreenshot()
    KeywordUtil.markFailed("Error: custom status - displayCustomStatus: $displayCustomStatus;  customStatus: $customStatus")
}



