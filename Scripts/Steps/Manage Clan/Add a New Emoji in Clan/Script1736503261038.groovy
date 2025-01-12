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

WebUI.click(findTestObject('Object Repository/Manage Clan/Delete Clan/div_Clan Header'))

WebUI.click(findTestObject('Manage Channel/Create Role/button_Clan Setting'))

WebUI.click(findTestObject('Object Repository/Manage Clan/Add a New Emoji in Clan/button_Emoji Option'))

WebUI.click(findTestObject('Object Repository/Manage Clan/Add a New Emoji in Clan/button_Upload Emoji'))

String emoji = CustomKeywords.'mezon.File.getPath'('\\Data Files\\Image\\logo NCC.png')

String emojiName = "NCC"

WebUI.uploadFile(findTestObject('Manage Clan/Add a New Emoji in Clan/input_upload emoji'), emoji)

WebUI.setText(findTestObject('Object Repository/Manage Clan/Add a New Emoji in Clan/input_Emoji Name'), emojiName)

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Manage Clan/Add a New Emoji in Clan/button_Save Changes'))

WebUI.verifyElementPresent(findTestObject("Object Repository/Manage Clan/Add a New Emoji in Clan/div_Emoji item"), 15)

Boolean verifyNewEmojiPresent = false

for (int i = 0; i < 15; i++) {
	WebElement emojiItemNameElemement = WebUI.findWebElement(findTestObject("Object Repository/Manage Clan/Add a New Emoji in Clan/p_Emoji Item Name"))

	String emojiItemName = emojiItemNameElemement.getText()
	if(emojiItemName.equals(emojiName)) {
		verifyNewEmojiPresent = true
		break
	}
	WebUI.delay(1)
}

if(!verifyNewEmojiPresent) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailed("New emoji not present")
}
