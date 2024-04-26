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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://dev-mezon.nccsoft.vn/guess/login')

WebUI.setText(findTestObject('Object Repository/Page_Mezon/input_WELCOME BACK_userEmail'), userEmail)

WebUI.click(findTestObject('Object Repository/Page_Mezon/div_WELCOME BACK_flex-row justify-start ite_4a6a2f'))

WebUI.click(findTestObject('Object Repository/Page_Mezon/div_WELCOME BACKSo glad to meet you againCo_a266bd'))

WebUI.setText(findTestObject('Object Repository/Page_Mezon/input_WELCOME BACK_password'), userPassword)

WebUI.click(findTestObject('Object Repository/Page_Mezon/button_Sign in'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Mezon/button_Friends'), 0)

WebUI.closeBrowser()

