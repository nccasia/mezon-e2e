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

WebUI.callTestCase(findTestCase('Steps/Manage Channel/Create New Private Channel'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.rightClick(findTestObject('Object Repository/Manage Channel/Create New Public Channel/div_New Channel'))

WebUI.click(findTestObject('Object Repository/Manage Channel/Update Info Channel/button_Edit Channel'))

WebUI.click(findTestObject('Object Repository/Manage Channel/Add Member To Channel in Private Channel/button_Permissions'))

WebUI.click(findTestObject('Object Repository/Manage Channel/Add Member To Channel in Private Channel/button_Add Members Or Roles'))

WebUI.verifyElementPresent(findTestObject('Manage Channel/Add Member To Channel in Private Channel/div_Add Members Or Roles Modal'), 
    15)

WebUI.setText(findTestObject("Object Repository/Manage Channel/Add Member To Channel in Private Channel/input_Search Members or Roles"), '@')

WebElement usernameOfMemberElement = WebUI.findWebElement(findTestObject("Object Repository/Manage Channel/Add Member To Channel in Private Channel/p_Username of Member"))

String usernameOfMember = usernameOfMemberElement.getText()

WebUI.check(findTestObject("Object Repository/Manage Channel/Add Member To Channel in Private Channel/checkbox_Member"))

WebUI.click(findTestObject('Object Repository/Manage Channel/Add Member To Channel in Private Channel/button_Done'))

WebElement newUsernameOfMemberElement = WebUI.findWebElement(findTestObject("Object Repository/Manage Channel/Add Member To Channel in Private Channel/div_new Member added"))

String newUsernameOfMember = newUsernameOfMemberElement.getText()

Boolean verifyNewMemberAdded = false

for (int i = 0; i < 15; i++) {
	if(newUsernameOfMember == usernameOfMember) {
		verifyNewMemberAdded = true
		break
	}
	WebUI.delay(1)
}

if(!verifyNewMemberAdded) {
	WebUI.takeScreenshot()
	
	KeywordUtil.markFailedAndStop("Add Member Failed")
}

