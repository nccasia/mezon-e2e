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
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

WebUI.callTestCase(findTestCase('Steps/Channel Message/Select channel'), [:], FailureHandling.STOP_ON_FAILURE)

String fileMediaPath = RunConfiguration.getProjectDir().replace('/', '\\') + '\\Data Files\\Media Upload\\Test case - reaction message.mp4'
String fileImgPath = RunConfiguration.getProjectDir().replace('/', '\\') + '\\Data Files\\Media Upload\\logo NCC.png'

println RunConfiguration.getProjectDir()
List splitFilePath = fileMediaPath.split('\\\\')

WebUI.uploadFile(findTestObject('Channel Message/Send Media/input_upload'), fileMediaPath)

WebUI.sendKeys(findTestObject('Channel Message/Send Media/textarea_Clan T_general channel'), Keys.chord(Keys.ENTER))

TestObject videoObj = findTestObject('Channel Message/Send Media/video_latest message')

WebElement videoElement = WebUI.findWebElement(videoObj)

WebUI.uploadFile(findTestObject('Channel Message/Send Media/input_upload'), fileImgPath)

WebUI.sendKeys(findTestObject('Channel Message/Send Media/textarea_Clan T_general channel'), Keys.chord(Keys.ENTER))

TestObject imgObj = findTestObject('Channel Message/Send Media/img_latest message')

WebElement imgElement = WebUI.findWebElement(imgObj)
