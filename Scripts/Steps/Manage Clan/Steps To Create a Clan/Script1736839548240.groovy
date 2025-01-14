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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.click(findTestObject('Manage Clan/Create a Clan/button_Add Clan'))

String clanImage = CustomKeywords.'mezon.File.getPath'('\\Data Files\\Image\\logo NCC.png')

WebUI.uploadFile(findTestObject('Manage Clan/Create a Clan/input_upload clan img'), clanImage)

WebUI.verifyElementPresent(findTestObject('Object Repository/Manage Clan/Create a Clan/img_clan avatar'), 15)

Random generator = new Random()

int randomNumber = generator.nextInt()

String newClan = "New Clan $randomNumber"

WebUI.setText(findTestObject('Manage Clan/Create a Clan/input_Enter Clan Name'), newClan)

WebUI.verifyElementNotPresent(findTestObject('Object Repository/Manage Clan/Create a Clan/p_Error New Clan Name'), 15)

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Manage Clan/Create a Clan/button_create clan'))

WebElement clanTitleElement = WebUI.findWebElement(findTestObject('Object Repository/Manage Clan/Create a Clan/p_Clan Title'))

String clanTitle = clanTitleElement.getText()

if (!(clanTitle.equals(newClan.toUpperCase()))) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailed('Error New Clan Name')
}
String clanItemXpath = "//*[@id='menu']/div/div[3]//div/div/a/div/div[2]/div/img[@alt='$newClan']"

TestObject clanItemObj = CustomKeywords.'mezon.GetTestObject.withXpath'(clanItemXpath)

WebUI.verifyElementPresent(clanItemObj, 15)