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

WebUI.callTestCase(findTestCase('Steps/Login_Logout and SignUp/Login with email and password'), [('email') : 'E2E1762357@ncc.asia'
        , ('password') : 'E2E1762357'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Direact Message/Create DM or Group Chat/button_create DM'))

String username1 = 'huy.lyquang'

String displayName1 = selectUsername(username1)

String username2 = 'nga.nguyenthi'

String displayName2

if (isCreateGroupChat) {
    displayName2 = selectUsername(username2)
}

WebUI.click(findTestObject('Object Repository/Direact Message/Create DM or Group Chat/button_create DM or Group Chat'))

WebElement conversationNameElement = WebUI.findWebElement(findTestObject('Object Repository/Direact Message/Create DM or Group Chat/h2_conversation name'))

String conversationName = conversationNameElement.getText()

Boolean verifyCreateDMorGroup = false

for (int i = 0; i < 15; i++) {
	if(isCreateGroupChat) {
		if (conversationName.contains(displayName1) && conversationName.contains(displayName2)) {
			verifyCreateDMorGroup = true
			break
		}
		WebUI.delay(1)
	} else {
		println conversationName
		println displayName1
		if (conversationName.equals(displayName1)) {
			verifyCreateDMorGroup = true
			break
		}
		WebUI.delay(1)
	}
}

if (!(verifyCreateDMorGroup)) {
    WebUI.takeScreenshot()
    KeywordUtil.markFailed('Create DM or Group chat failed!')
}

if(isCreateGroupChat) {
	WebUI.callTestCase(findTestCase('Steps/Direct Message/Leave Group'), [('isCalled') : true], FailureHandling.STOP_ON_FAILURE)
}

def selectUsername(String username) {
    WebUI.setText(findTestObject('Object Repository/Direact Message/Create DM or Group Chat/input_search username'), username)
	
    WebUI.check(findTestObject('Object Repository/Direact Message/Create DM or Group Chat/checkox_item'))
	
    WebElement displayNameElement = WebUI.findWebElement(findTestObject("Object Repository/Direact Message/Create DM or Group Chat/div_Display Name"))
	
	String displayName = displayNameElement.getText()
	
	return displayName
		
}

