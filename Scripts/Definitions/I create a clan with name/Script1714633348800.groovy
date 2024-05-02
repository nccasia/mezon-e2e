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

WebUI.click(findTestObject('Object Repository/Page_Mezon/div_'))

WebUI.click(findTestObject('Object Repository/Page_Mezon/div_Add Clan'))

WebUI.click(findTestObject('Object Repository/Page_Mezon/input_CLAN NAME_bg-bgPrimary font-400  px-1_0056bc'))

WebUI.setText(findTestObject('Object Repository/Page_Mezon/input_CLAN NAME_bg-bgPrimary font-400  px-1_0056bc'), clanName.toUpperCase())

WebUI.click(findTestObject('Object Repository/Page_Mezon/button_Create'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Mezon/p_Welcome to  general'), 0)

WebUI.delay(1)

WebUI.waitForElementPresent(findTestObject('Page_Mezon/div_E'), 0)

WebUI.verifyElementText(findTestObject('Object Repository/Page_Mezon/p_general'), 'general')

