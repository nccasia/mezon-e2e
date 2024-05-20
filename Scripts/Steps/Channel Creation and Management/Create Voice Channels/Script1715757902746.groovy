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

WebUI.click(findTestObject('Object Repository/Channel_management/Create Voice channel/Page_Mezon/div_'))

WebUI.click(findTestObject('Object Repository/Channel_management/Create Voice channel/Page_Mezon/div_CCreate a Clan'))

WebUI.click(findTestObject('Channel_management/Page_Mezon/svg_PUBLIC CHANNELS_w-4 h-4'))

WebUI.click(findTestObject('Object Repository/Channel_management/Create Voice channel/Page_Mezon/input_concat(Choose channel, , s type)_drone'))

WebUI.setText(findTestObject('Object Repository/Channel_management/Create Voice channel/Page_Mezon/input_concat(What is channel, , s name)_Inp_00fae1'), 
    voiceChannelPrivate)

WebUI.click(findTestObject('Object Repository/Channel_management/Create Voice channel/Page_Mezon/input_Is private channel_id-c01'))

WebUI.click(findTestObject('Object Repository/Channel_management/Create Voice channel/Page_Mezon/span_Create Channel'))

WebUI.click(findTestObject('Channel_management/Page_Mezon/svg_PUBLIC CHANNELS_w-4 h-4'))

WebUI.setText(findTestObject('Object Repository/Channel_management/Create Voice channel/Page_Mezon/input_concat(What is channel, , s name)_Inp_00fae1'), 
    voiceChannelPublic)

WebUI.click(findTestObject('Object Repository/Channel_management/Create Voice channel/Page_Mezon/input_concat(Choose channel, , s type)_drone'))

WebUI.click(findTestObject('Object Repository/Channel_management/Create Voice channel/Page_Mezon/span_Create Channel'))

WebUI.click(findTestObject('Channel_management/Page_Mezon/svg_PUBLIC CHANNELS_w-4 h-4'))

WebUI.click(findTestObject('Object Repository/Channel_management/Create Voice channel/Page_Mezon/input_concat(Choose channel, , s type)_drone'))

WebUI.setText(findTestObject('Object Repository/Channel_management/Create Voice channel/Page_Mezon/input_concat(What is channel, , s name)_Inp_00fae1'), 
    voiceChannelCancel)

WebUI.click(findTestObject('Object Repository/Channel_management/Create Voice channel/Page_Mezon/button_Cancel'))

