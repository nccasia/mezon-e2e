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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import org.openqa.selenium.WebElement as WebElement

if(!isCalled) {
	WebUI.callTestCase(findTestCase('Steps/Manage Clan/Select a Clan'), [:], FailureHandling.STOP_ON_FAILURE)	
}

WebElement categoryElement = WebUI.findWebElement(findTestObject("Manage Clan/Create Category/span_New Category"))

String category = categoryElement.getText().toLowerCase()

WebUI.rightClick(findTestObject('Manage Clan/Create Category/span_New Category'))

WebUI.click(findTestObject('Manage Clan/Delete Category/button_Delete Category Option'))

WebElement deleteCategoryElement = WebUI.findWebElement(findTestObject("Object Repository/Manage Clan/Delete Category/b_Category Name needs to be delete"))

String deleteCategory = deleteCategoryElement.getText().toLowerCase()

if(!deleteCategory.equals(category)) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailedAndStop("Not the category that needs to be deleted")
}

WebUI.click(findTestObject('Manage Clan/Delete Category/button_Delete Category'))

Boolean verifyDeleteCategory = false

for(int i = 0; i < 15; i++) {
	categoryElement = WebUI.findWebElement(findTestObject("Manage Clan/Create Category/span_New Category"))
	
	category = categoryElement.getText().toLowerCase()
	
	if(!category.equals(deleteCategory)) {
		verifyDeleteCategory = true
		break
	}
	WebUI.delay(1)
}

if(!verifyDeleteCategory) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailed("Delete category Failed!")
}


