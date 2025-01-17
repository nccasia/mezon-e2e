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

WebUI.click(findTestObject('User Profile/Change Display Name Profile/button_Setting'))

WebUI.click(findTestObject('User Profile/Change Clan Nickname/button_Profile Option'))

WebUI.click(findTestObject('Object Repository/User Profile/Change Display Name Profile/button_User Profile'))

String newDisplayName = CustomKeywords.'mezon.Random.text'('display name')

WebUI.setText(findTestObject('User Profile/Change Display Name Profile/input_Display Name Profile'), newDisplayName)

WebElement previewDisplayNameElement = WebUI.findWebElement(findTestObject("Object Repository/User Profile/Change Display Name Profile/p_Preview Display Name"))

String previewDisplayName = previewDisplayNameElement.getText()

if(!previewDisplayName.equals(newDisplayName)) {
	WebUI.takeScreenshot()
    KeywordUtil.markFailedAndStop('Error: preview display name not changes')
}

WebUI.click(findTestObject('Object Repository/User Profile/Change Display Name Profile/button_Save Changes'))

WebUI.verifyElementNotPresent(findTestObject("Object Repository/User Profile/Change Display Name Profile/button_Save Changes"), 15)

WebUI.click(findTestObject('Object Repository/User Profile/Change Clan Nickname/button_ESC'))

WebElement displayNameElement = WebUI.findWebElement(findTestObject("Object Repository/User Profile/Change Display Name Profile/p_Display Name"))

String displayName = displayNameElement.getText()

if(!displayName.equals(newDisplayName)) {
	WebUI.takeScreenshot()
    KeywordUtil.markFailedAndStop('Error: display name not changes')
}

