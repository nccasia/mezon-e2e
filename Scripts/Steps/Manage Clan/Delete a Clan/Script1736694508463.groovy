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

if(isCreateClan) {
	WebUI.callTestCase(findTestCase('Steps/Manage Clan/Create a Clan'), [:], FailureHandling.STOP_ON_FAILURE)	
}

WebUI.click(findTestObject('Object Repository/Manage Clan/Delete Clan/div_Clan Title'))

WebUI.click(findTestObject('Manage Channel/Create Role/button_Clan Setting'))

WebUI.click(findTestObject('Manage Clan/Delete Clan/button_Delete Clan Option'))

WebElement deleteClanElement = WebUI.findWebElement(findTestObject('Object Repository/Manage Clan/Delete Clan/div_Delete Clan'))

String deleteClan = deleteClanElement.getText()

int startIndex = deleteClan.indexOf('\'') + 1

int endIndex = deleteClan.indexOf('\'', startIndex)

String clanName = deleteClan.substring(startIndex, endIndex)

WebUI.setText(findTestObject('Manage Clan/Delete Clan/input_Delete Clan'), clanName)

WebUI.click(findTestObject('Object Repository/Manage Clan/Delete Clan/button_Delete Clan'))

String clanItemXpath = "//*[@id='menu']/div/div[3]//div/div/a/div/div[2]/div/img[@alt='$clanName']"

TestObject clanItemObj = CustomKeywords.'mezon.GetTestObject.withXpath'(clanItemXpath)

WebUI.verifyElementNotPresent(clanItemObj, 15)

