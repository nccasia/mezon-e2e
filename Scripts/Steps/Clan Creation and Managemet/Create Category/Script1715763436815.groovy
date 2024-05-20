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

WebUI.click(findTestObject('Object Repository/Clan management/Create category/Page_Mezon/div_'))

WebUI.click(findTestObject('Object Repository/Clan management/Create category/Page_Mezon/span_NewClan'))

WebUI.click(findTestObject('Object Repository/Clan management/Create category/Page_Mezon/path_N_Vector'))

WebUI.click(findTestObject('Clan management/Create category/Page_Mezon/li_Create Category'))

WebUI.setText(findTestObject('Object Repository/Clan management/Create category/Page_Mezon/input_concat(What is category, , s name)_da_69c088'), 
    CategoryName)

WebUI.click(findTestObject('Object Repository/Clan management/Create category/Page_Mezon/button_Create Category'))

WebUI.click(findTestObject('Object Repository/Clan management/Create category/Page_Mezon/path_N_Vector'))

WebUI.click(findTestObject('Object Repository/Clan management/Create category/Page_Mezon/li_Create Category'))

WebUI.setText(findTestObject('Object Repository/Clan management/Create category/Page_Mezon/input_concat(What is category, , s name)_da_69c088'), 
    CategoryName)

WebUI.click(findTestObject('Object Repository/Clan management/Create category/Page_Mezon/button_Cancel'))

