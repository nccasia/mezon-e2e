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

WebUI.click(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/div_Clan T'))

WebElement ChannelElement = WebUI.findWebElement(findTestObject('Object Repository/Manage Channel/Create New Public Channel/div_New Channel'))

String channelId = ChannelElement.getAttribute('id')

WebUI.rightClick(findTestObject('Object Repository/Manage Channel/Create New Public Channel/div_New Channel'))

WebUI.click(findTestObject('Object Repository/Manage Channel/Update Info Channel/button_Edit Channel'))

WebUI.click(findTestObject('Object Repository/Manage Channel/Toggle Private Or Publish Channel/button_Permissions Option'))

WebUI.click(findTestObject('Object Repository/Manage Channel/Toggle Private Or Publish Channel/switch_Private Channel'))

WebElement SwitchPrivateElement = WebUI.findWebElement(findTestObject('Object Repository/Manage Channel/Toggle Private Or Publish Channel/switch_Private Channel'))

Boolean SwitchPrivateChecked = SwitchPrivateElement.getAttribute("checked")

if (SwitchPrivateChecked) {
	WebUI.verifyElementPresent(findTestObject('Object Repository/Manage Channel/Toggle Private Or Publish Channel/div_Management Member Or Role'),
		15)
} else {
	WebUI.verifyElementNotPresent(findTestObject('Object Repository/Manage Channel/Toggle Private Or Publish Channel/div_Management Member Or Role'),
		15)
}

WebUI.click(findTestObject('Object Repository/Manage Channel/Toggle Private Or Publish Channel/button_Save Changes'))

if (SwitchPrivateChecked) {
	WebUI.verifyElementPresent(findTestObject('Manage Channel/Toggle Private Or Publish Channel/div_Advanced Permissions'),
		15)
} else {
	WebUI.verifyElementNotPresent(findTestObject('Manage Channel/Toggle Private Or Publish Channel/div_Advanced Permissions'),
		15)	
}

String ChannelSVG 

String LockSVG

if (SwitchPrivateChecked) {
	ChannelSVG = CustomKeywords.'mezon.ConvertFile.toString'('\\Data Files\\Svg\\Private Channel.svg')
} else {
	ChannelSVG = CustomKeywords.'mezon.ConvertFile.toString'('\\Data Files\\Svg\\Public Channel.svg')
	LockSVG = CustomKeywords.'mezon.ConvertFile.toString'('\\Data Files\\Svg\\Lock.svg')
}

Boolean verifyChangePrivateChannelImage = false

for (int i = 0; i < 15; i++) {
	WebElement EditingChannelTitleElement = WebUI.findWebElement(findTestObject('Object Repository/Manage Channel/Toggle Private Or Publish Channel/div_Editing Channel Title'))
		
	String EditingChannelTitleInnerHTML = EditingChannelTitleElement.getAttribute('innerHTML')
	
	if(SwitchPrivateChecked) {
		if (EditingChannelTitleInnerHTML.contains(ChannelSVG)) {
			verifyChangePrivateChannelImage = true
			break
		}
	} else {
		if (EditingChannelTitleInnerHTML.contains(ChannelSVG) && !EditingChannelTitleInnerHTML.contains(LockSVG)) {
			verifyChangePrivateChannelImage = true
			break
		}
	}
	
	WebUI.delay(1)
}

if (!verifyChangePrivateChannelImage) {
	WebUI.takeScreenshot()
	
	KeywordUtil.markFailedAndStop('Don\'t change a channel svg')
}

WebUI.click(findTestObject('Object Repository/Manage Channel/Toggle Private Or Publish Channel/button_ESC'))

TestObject ChannelChangedToPrivateObj = CustomKeywords.'mezon.GetTestObject.withXpath'("//*[@id='$channelId']")

verifyChangePrivateChannelImage = false

for (int i = 0; i < 15; i++) {
	WebElement ChannelChangedToPrivateElement = WebUI.findWebElement(ChannelChangedToPrivateObj)

	String ChannelChangedToPrivateInnerHTML = ChannelChangedToPrivateElement.getAttribute("innerHTML")
	
	if(SwitchPrivateChecked) {
		if (ChannelChangedToPrivateInnerHTML.contains(ChannelSVG)) {
			verifyChangePrivateChannelImage = true
			break
		}
	} else {
		if (ChannelChangedToPrivateInnerHTML.contains(ChannelSVG) && !ChannelChangedToPrivateInnerHTML.contains(LockSVG)) {
			verifyChangePrivateChannelImage = true
			break
		}
	}
	
	WebUI.delay(1)
}

if (!verifyChangePrivateChannelImage) {
	WebUI.takeScreenshot()
	
	KeywordUtil.markFailedAndStop('Don\'t change a channel svg')
}
