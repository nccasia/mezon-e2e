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

if (!(isCalled)) {
    WebUI.callTestCase(findTestCase('Steps/Manage Clan/Create Event'), [:], FailureHandling.STOP_ON_FAILURE)
}

String id = 'event'

CustomKeywords.'mezon.Attribute.add'(findTestObject('Object Repository/Manage Clan/Cancel Event/div_Event Container'), 'id', id)

String eventContainerXpath = "//*[@id='$id']"

TestObject eventContainerObj = CustomKeywords.'mezon.GetTestObject.withXpath'(eventContainerXpath)

WebUI.click(findTestObject('Manage Clan/Cancel Event/button_more'))

WebUI.click(findTestObject('Manage Clan/Cancel Event/button_Cancel Option'))

WebUI.click(findTestObject('Manage Clan/Cancel Event/button_Cancel Event'))

WebUI.verifyElementNotPresent(eventContainerObj, 15)



