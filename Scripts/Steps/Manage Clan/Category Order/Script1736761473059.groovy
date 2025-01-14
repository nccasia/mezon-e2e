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
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.util.KeywordUtil

import java.util.ArrayList

WebUI.callTestCase(findTestCase('Steps/Manage Clan/Select a Clan'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Manage Clan/Delete Clan/div_Clan Header'))

WebElement switchSHowEmptyCategoriesElement = WebUI.findWebElement(findTestObject("Object Repository/Manage Clan/Category Order/switch_Show Empty Categories"))

Boolean isSHowEmptyCategories = switchSHowEmptyCategoriesElement.getAttribute("checked")

if (!isSHowEmptyCategories) {
	switchSHowEmptyCategoriesElement.click()
}

WebUI.click(findTestObject('Manage Channel/Create Role/button_Clan Setting'))

WebUI.click(findTestObject('Manage Clan/Category Order/button_Category Option'))

WebElement item1 = WebUI.findWebElement(findTestObject('Object Repository/Manage Clan/Category Order/div_First child of Category'))

WebElement item2 = WebUI.findWebElement(findTestObject('Object Repository/Manage Clan/Category Order/div_Second child of Category'))

WebDriver driver = DriverFactory.getWebDriver()

Actions actions = new Actions(driver)

actions.clickAndHold(item1).moveToElement(item2).release().build().perform()

WebUI.click(findTestObject("Object Repository/Manage Clan/Category Order/button_Save Changes"))

List<WebElement> categoryElementList = WebUI.findWebElements(findTestObject('Object Repository/Manage Clan/Category Order/div_categoryList Changed'), 15)

ArrayList<String> categoryListChanged = new ArrayList<>()

for (WebElement categoryElement : categoryElementList) {
	String categoryName = categoryElement.getText()
	categoryListChanged.add(categoryName)
}

WebUI.click(findTestObject("Object Repository/Manage Clan/Category Order/button_ESC"))

List<WebElement> categoryElementListCurrent = WebUI.findWebElements(findTestObject('Object Repository/Manage Clan/Category Order/div_Category List'), 15)

ArrayList<String> categoryListCurrent = new ArrayList<>()

for (WebElement categoryElement : categoryElementListCurrent) {
	String categoryName = categoryElement.getText()
	categoryListCurrent.add(categoryName)
}

String categoryListCurrentString = categoryListCurrent.toString()

String categoryListChangedString = categoryListChanged.toString()

if(!categoryListChangedString.equals(categoryListCurrentString)) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailed("Category order failed!")
}



