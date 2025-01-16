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

WebUI.callTestCase(findTestCase('Steps/Manage Clan/Select a Clan'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Manage Clan/Delete Clan/div_Clan Header'))

WebUI.click(findTestObject('Object Repository/Manage Clan/Category Order/switch_Show Empty Categories'))

WebUI.click(findTestObject('Manage Clan/Create Category/button_Create Category Option'))

String categoryName = CustomKeywords.'mezon.Random.text'('new category')

WebUI.setText(findTestObject('Manage Clan/Create Category/input_Enter Category Name'), categoryName)

if (isPrivate) {
    WebUI.click(findTestObject('Object Repository/Manage Clan/Create Category/switch_Private Category'))
}

WebUI.click(findTestObject('Manage Clan/Create Category/button_Create Category'))

Boolean verifyNewCategoryPresent = false

for (int i = 0; i < 15; i++) {
    WebElement newCategoryElement = WebUI.findWebElement(findTestObject('Object Repository/Manage Clan/Create Category/span_New Category'))

    String newCategory = newCategoryElement.getText().toLowerCase()

    if (newCategory.equals(categoryName)) {
        verifyNewCategoryPresent = true
		break
    }
	WebUI.delay(1)
}

if (!verifyNewCategoryPresent) {
    WebUI.takeScreenshot()
    KeywordUtil.markFailed('New category not present!')
}

WebUI.callTestCase(findTestCase('Steps/Manage Clan/Delete Category'), [('isCalled') : true], FailureHandling.STOP_ON_FAILURE)

