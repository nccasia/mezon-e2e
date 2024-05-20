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

WebUI.click(findTestObject('Object Repository/Page_Mezon/div_CCreate a Clan'))

WebUI.click(findTestObject('Object Repository/Page_Mezon/svg'))

WebUI.click(findTestObject('Object Repository/Page_Mezon/input_concat(Choose channel, , s type)_drone'))

WebUI.setText(findTestObject('Channel_management/Page_Mezon/Input_Channel_Name'), channelNamePrivate)

WebUI.click(findTestObject('Object Repository/Page_Mezon/input_Is private channel_id-c01'))

WebUI.click(findTestObject('Object Repository/Page_Mezon/span_Create Channel'))

WebUI.click(findTestObject('Object Repository/Page_Mezon/svg'))

WebUI.click(findTestObject('Object Repository/Page_Mezon/input_concat(Choose channel, , s type)_drone'))

WebUI.setText(findTestObject('Channel_management/Page_Mezon/Input_Channel_Name'), channelNamePublic)

WebUI.click(findTestObject('Object Repository/Page_Mezon/span_Create Channel'))

WebUI.click(findTestObject('Object Repository/Page_Mezon/svg'))

WebUI.setText(findTestObject('Channel_management/Page_Mezon/Input_Channel_Name'), channelNameCancel)

WebUI.click(findTestObject('Object Repository/Page_Mezon/input_concat(Choose channel, , s type)_drone'))

WebUI.click(findTestObject('Object Repository/Page_Mezon/button_Cancel'))

