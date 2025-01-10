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

WebUI.callTestCase(findTestCase('Steps/Manage Channel/Create New Private Channel'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.rightClick(findTestObject('Manage Channel/Create New Public Channel/div_New Channel'))

WebUI.click(findTestObject('Manage Channel/Update Info Channel/button_Edit Channel'))

WebUI.click(findTestObject('Manage Channel/Toggle Private Or Publish Channel/button_Permissions Option'))

WebUI.click(findTestObject('Manage Channel/Add Member To Channel in Private Channel/button_Add Members Or Roles'))

String role = 'role 1'

WebUI.setText(findTestObject('Manage Channel/Add Member To Channel in Private Channel/input_Search Members or Roles'), role)

WebUI.check(findTestObject('Manage Channel/Add Member To Channel in Private Channel/checkbox_Member'))

WebUI.click(findTestObject('Manage Channel/Add Member To Channel in Private Channel/button_Done'))

WebElement RoleNameElememt = WebUI.findWebElement(findTestObject('Object Repository/Manage Channel/Add Role in Channel/div_Role Name'))

String RoleName = RoleNameElememt.getText().toLowerCase()

String RoleInnerHTML = RoleNameElememt.getAttribute('innerHTML')

String RoleSVG = CustomKeywords.'mezon.ConvertFile.toString'("\\Data Files\\Svg\\Role image.svg")

if (!(RoleName.equals(role)) && !RoleInnerHTML.contains(RoleSVG)) {
    WebUI.takeScreenshot()
    KeywordUtil.markFailedAndStop('Add Role Failed! or error Icon')
}



