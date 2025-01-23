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

WebUI.click(findTestObject('User Profile/Change Clan Nickname/button_Setting'))

WebUI.click(findTestObject('User Profile/Change Clan Nickname/button_Profile Option'))

WebUI.click(findTestObject('User Profile/Change Clan Nickname/button_Clan Profile'))

WebElement previewAvatarClanElement = WebUI.findWebElement(findTestObject("Object Repository/User Profile/Change Avatar Clan/img_Preview Avatar Clan"))

String previewAvatar = previewAvatarClanElement.getAttribute("src")

String newAvatarClanFilePath = CustomKeywords.'mezon.File.getPath'("\\Data Files\\Image\\logo NCC.png")

WebUI.uploadFile(findTestObject("Object Repository/User Profile/Change Avatar Clan/input_Upload Avatar Clan"), newAvatarClanFilePath)

Boolean verifyUploadAvatarClan = false 

String previewAvatarChanged 

for (int i = 0; i < 15; i++) {
	previewAvatarClanElement = WebUI.findWebElement(findTestObject("Object Repository/User Profile/Change Avatar Clan/img_Preview Avatar Clan"))
	previewAvatarChanged = previewAvatarClanElement.getAttribute("src")
	if(!previewAvatarChanged.equals(previewAvatar)) {
		verifyUploadAvatarClan = true
		break
	}
	WebUI.delay(1)
}

previewAvatarChanged = spliceString(previewAvatarChanged, '/plain/')

if(!verifyUploadAvatarClan) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailedAndStop("Error: Preview avatar clan not changed!")
}

WebUI.click(findTestObject("Object Repository/User Profile/Change Clan Nickname/button_Save Changes"))

WebUI.verifyElementNotPresent(findTestObject("Object Repository/User Profile/Change Clan Nickname/button_Save Changes"), 15)

WebUI.click(findTestObject("Object Repository/User Profile/Change Clan Nickname/button_ESC"))

WebUI.callTestCase(findTestCase('Steps/Channel Message/Reply message'), [('isCalled') : true], FailureHandling.STOP_ON_FAILURE)

WebElement avatarInMessageElement = WebUI.findWebElement(findTestObject("Object Repository/User Profile/Change Avatar Clan/img_User Avatar in Message"))

String avatarInMessageSrc = avatarInMessageElement.getAttribute('src')

avatarInMessageSrc = spliceString(avatarInMessageSrc, '/plain/')

if(!avatarInMessageSrc.equals(previewAvatarChanged)) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailedAndStop("Error: avatar clan not changed!")
}

def spliceString(String text, String keywordStart, String keyWordEnd = "") {
	int startIndex = text.indexOf(keywordStart) + keywordStart.size()
	int endIndex
	if(keyWordEnd) {
		endIndex  = text.indexOf(keyWordEnd)
	} else {
		endIndex = text.size()
	}
	String textSpliced = text.substring(startIndex, endIndex)
	return textSpliced
}
