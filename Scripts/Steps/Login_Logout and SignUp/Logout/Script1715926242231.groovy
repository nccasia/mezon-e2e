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

WebUI.click(findTestObject('Logout/Page_Mezon/svg_Online_ml-auto w-18px h-18px opacity-80_40011d'))

WebUI.click(findTestObject('Logout/Page_Mezon/button_X'))

WebUI.click(findTestObject('Logout/Page_Mezon/svg_Online_ml-auto w-18px h-18px opacity-80_40011d'))

'Scroll to \'Log out\' button'
WebUI.scrollToElement(findTestObject('Logout/Page_Mezon/button_Log Out'), 3)

WebUI.click(findTestObject('Logout/Page_Mezon/button_Log Out'))

WebUI.click(findTestObject('Logout/Page_Mezon/button_Cancel'))

WebUI.click(findTestObject('Logout/Page_Mezon/button_Log Out'))

WebUI.click(findTestObject('Logout/Page_Mezon/Button_accept_logout'))

WebUI.verifyElementText(findTestObject('Logout/Page_Mezon/h1_WELCOME BACK'), 'WELCOME BACK')

WebUI.verifyElementText(findTestObject('Page_Mezon/p_So glad to meet you again'), 'So glad to meet you again!')

WebUI.closeBrowser()

