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

WebUI.click(findTestObject('Object Repository/Channel Message/Page_Mezon/div_'))

WebUI.click(findTestObject('Object Repository/Channel Message/Page_Mezon/span_Test Clan'))

WebUI.uploadFile(findTestObject('Channel Message/Upload files'), PathToImage)

'Capturing the file name after upload and storing it in variable'
FilePath = WebUI.getAttribute(findTestObject('Channel Message/Upload files'), 'value')

WebUI.click(findTestObject('Channel Message/Page_Mezon/textarea_1'))

WebUI.setText(findTestObject('Object Repository/Channel Message/Page_Mezon/textarea_1'), Message)

WebUI.getAttribute(findTestObject('Channel Message/Page_Mezon/textarea_1'), '')

WebUI.sendKeys(findTestObject('Channel Message/Page_Mezon/textarea_1'), Keys.chord(Keys.ENTER))

WebUI.setText(findTestObject('Channel Message/Page_Mezon/textarea_1'), Message2)

WebUI.sendKeys(findTestObject('Channel Message/Page_Mezon/textarea_1'), Keys.chord(Keys.ENTER))

WebUI.uploadFile(findTestObject('Channel Message/Upload files'), PathToFile)

WebUI.click(findTestObject('Channel Message/Page_Mezon/textarea_1'))

WebUI.sendKeys(findTestObject('Channel Message/Page_Mezon/textarea_1'), Keys.chord(Keys.ENTER))

WebUI.uploadFile(findTestObject('Channel Message/Upload files'), PathToImage1)

WebUI.click(findTestObject('Channel Message/Page_Mezon/textarea_1'))

WebUI.sendKeys(findTestObject('Channel Message/Page_Mezon/textarea_1'), Keys.chord(Keys.ENTER))

WebUI.setText(findTestObject('Object Repository/Channel Message/Page_Mezon/textarea_1'), Message)

WebUI.sendKeys(findTestObject('Channel Message/Page_Mezon/textarea_1'), Keys.chord(Keys.ENTER))

WebUI.setText(findTestObject('Channel Message/Page_Mezon/textarea_1'), Message2)

WebUI.sendKeys(findTestObject('Channel Message/Page_Mezon/textarea_1'), Keys.chord(Keys.ENTER))

