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

WebUI.callTestCase(findTestCase('Steps/Login_Logout and SignUp/Login with email and password'), [('email') : 'E2E1762357@ncc.asia'
        , ('password') : 'E2E1762357'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/div_Clan T'))

WebElement updateChannelElement = WebUI.findWebElement(findTestObject('Object Repository/Manage Channel/Create New Public Channel/div_New Channel'))

String channelId = updateChannelElement.getAttribute('id')

WebUI.rightClick(findTestObject('Object Repository/Manage Channel/Create New Public Channel/div_New Channel'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Manage Channel/Update Info Channel/button_Edit Channel'), 
    15)

WebUI.click(findTestObject('Manage Channel/Delete Channel/button_delete'))

WebUI.waitForElementPresent(findTestObject('Manage Channel/Delete Channel/div_delete modal'), 15)

WebUI.click(findTestObject('Manage Channel/Delete Channel/button_confirm delete'))

String channelDeletedXpath = "//*[@id='$channelId']"

TestObject channelDeletedObj = CustomKeywords.'mezon.GetTestObject.withXpath'(channelDeletedXpath)

WebUI.verifyElementNotPresent(channelDeletedObj, 15)

