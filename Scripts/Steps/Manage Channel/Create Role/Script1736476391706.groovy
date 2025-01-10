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
import org.openqa.selenium.WebElement
import com.kms.katalon.core.util.KeywordUtil

WebUI.callTestCase(findTestCase('Steps/Login_Logout and SignUp/Login with email and password'), [('email') : 'E2E1762357@ncc.asia'
	, ('password') : 'E2E1762357'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/div_Clan T'))

WebUI.click(findTestObject('Object Repository/Manage Channel/Create Role/div_Clan Title'))

WebUI.click(findTestObject("Object Repository/Manage Channel/Create Role/button_Clan Setting"))

WebUI.click(findTestObject("Object Repository/Manage Channel/Create Role/button_Roles"))

WebUI.click(findTestObject("Object Repository/Manage Channel/Create Role/button_Create Role"))

WebUI.click(findTestObject("Object Repository/Manage Channel/Create Role/button_display"))

Random generator = new Random()

int randomNumber = generator.nextInt()

String role = "New $randomNumber"

WebUI.setText(findTestObject("Object Repository/Manage Channel/Create Role/input_Enter New Role"), role)

WebUI.click(findTestObject("Object Repository/Manage Channel/Create Role/button_Save Changes"))

WebUI.verifyElementNotPresent(findTestObject("Object Repository/Manage Channel/Create Role/div_Toast Error"), 3)

WebUI.click(findTestObject("Object Repository/Manage Channel/Create Role/button_Back"))

WebElement newRoleElement 

Boolean verifyNewRolePresent = false
for (int i = 0; i < 15; i++) {
	newRoleElement = WebUI.findWebElement(findTestObject("Object Repository/Manage Channel/Create Role/span_New Role"))
	String newRole = newRoleElement.getText()
	if(newRole.equals(role)) {
		verifyNewRolePresent = true
		break
	}
	WebUI.delay(1)
}

if(!verifyNewRolePresent) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailed("New Role not present!")
}

