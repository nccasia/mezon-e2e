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
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.callTestCase(findTestCase('Steps/Login_Logout and SignUp/Login with email and password'), [('email') : 'E2E1762357@ncc.asia'
        , ('password') : 'E2E1762357'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/div_Clan T'))

WebUI.click(findTestObject('Object Repository/Manage Channel/Create New Public Channel/button_Add Channel'))
if (channelType.equals("voice")) {	WebUI.check(findTestObject('Object Repository/Manage Channel/Create Channel With Type Voice, Stream, App/radio_Voice Type'))} else if (channelType.equals("stream")) { 	WebUI.check(findTestObject('Object Repository/Manage Channel/Create Channel With Type Voice, Stream, App/radio_Stream Type'))} else if (channelType.equals("app")) {	WebUI.check(findTestObject('Object Repository/Manage Channel/Create Channel With Type Voice, Stream, App/radio_Apps Type'))} else if (channelType.equals("text")) {	WebUI.check(findTestObject('Object Repository/Manage Channel/Create New Public Channel/radio_Channel Type_Text'))} else {
	KeywordUtil.markFailedAndStop("Channel Type invalid")
}

Random generator = new Random()

int randomNumber = generator.nextInt()

String newChannelName = "New $randomNumber"

WebUI.setText(findTestObject('Manage Channel/Create New Public Channel/input_Enter The Channel Name'), newChannelName)

if (channelType.equals("app")) { 
	WebUI.setText(findTestObject('Object Repository/Manage Channel/Create New Public Channel/input_App URL'), "https://mezon.ai")
} else if (channelType.equals("text")) {
	if(isPrivateChannel) {
		WebUI.click(findTestObject('Object Repository/Manage Channel/Create New Private Channel/switch_Is private channel'))
	}
}

WebUI.delay(1)

WebUI.click(findTestObject("Object Repository/Manage Channel/Create New Public Channel/button_Create Channel"))

Boolean verifyCreateNewChannelFail = true

WebElement newChannelElement

for (int i = 0; i < 15; i++) {
	newChannelElement = WebUI.findWebElement(findTestObject('Object Repository/Manage Channel/Create New Public Channel/div_New Channel'))
	
	String newChannelElementText = newChannelElement.getText()
	
	if(newChannelElementText == newChannelName) {
		String newChannelElementInnerHTML = newChannelElement.getAttribute('innerHTML')
		
		String ChannelSVG
		
		if (channelType.equals("voice")) {
			ChannelSVG = CustomKeywords.'mezon.ConvertFile.toString'('\\Data Files\\Svg\\Voice.svg')
		} else if (channelType.equals("stream")) {
			ChannelSVG = CustomKeywords.'mezon.ConvertFile.toString'('\\Data Files\\Svg\\Stream.svg')
		} else if (channelType.equals("app")) {
			ChannelSVG = CustomKeywords.'mezon.ConvertFile.toString'('\\Data Files\\Svg\\Apps.svg')
		} else {
			if(isPrivateChannel) {
				ChannelSVG = CustomKeywords.'mezon.ConvertFile.toString'('\\Data Files\\Svg\\Private Channel.svg')
			} else {				
				ChannelSVG = CustomKeywords.'mezon.ConvertFile.toString'('\\Data Files\\Svg\\Public Channel.svg')
			}
		}
		
		if(newChannelElementInnerHTML.contains(ChannelSVG)) {
			verifyCreateNewChannelFail = false
			break
		} else {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop("Channel Icon is wrong!")
		}
	}
	WebUI.delay(1)
}

if (verifyCreateNewChannelFail) {
	KeywordUtil.markFailedAndStop("New Channel not present!")
}

if(channelType.equals("voice")) {
	WebDriver driver = DriverFactory.getWebDriver()
	
	WebUI.delay(3)
	
	newChannelElement.click()
	
	Set<String> windowHandles = driver.getWindowHandles()
	String currentWindow = driver.getWindowHandle()
	
	for (String window : windowHandles) {
		if (!window.equals(currentWindow)) {
			driver.switchTo().window(window)
			break
		}
	}
	String expectedUrl = "https://meet.google.com"
	
	String actualUrl = driver.getCurrentUrl()
	
	if(!actualUrl.contains(expectedUrl)) {
		WebUI.takeScreenshot()
		
		KeywordUtil.markFailedAndStop("Link is wrong!")
	}
	driver.switchTo().window(currentWindow)
	
} else {
	if (channelType.equals("stream")) {
		newChannelElement.click()
	}
	WebElement titleNewChannelElement = WebUI.findWebElement(findTestObject("Object Repository/Manage Channel/Create New Public Channel/p_title new channel"))
			
	String titleNewChannelText = titleNewChannelElement.getText()
	
	if (titleNewChannelText != newChannelName) {
		WebUI.takeScreenshot()
		KeywordUtil.markFailedAndStop("New Channel Title is wrong!")
	}
}

String newChannelId = newChannelElement.getAttribute("id")

WebUI.rightClick(findTestObject('Object Repository/Manage Channel/Create New Public Channel/div_New Channel'))

if (channelType.equals("voice")) {
	WebUI.verifyElementPresent(findTestObject('Object Repository/Manage Channel/Delete Channel/button_Delete Voice Channel'), 15)
	WebUI.click(findTestObject('Object Repository/Manage Channel/Delete Channel/button_Delete Voice Channel'))
} else if (channelType.equals("stream") || channelType.equals("app")) {
	WebUI.verifyElementPresent(findTestObject('Object Repository/Manage Channel/Delete Channel/button_Delete Stream Channel'), 15)
	WebUI.click(findTestObject('Object Repository/Manage Channel/Delete Channel/button_Delete Stream Channel'))
}  else {
	WebUI.verifyElementPresent(findTestObject('Object Repository/Manage Channel/Delete Channel/button_delete'), 15)
	WebUI.click(findTestObject('Object Repository/Manage Channel/Delete Channel/button_delete'))
}

if(channelType.equals("text")) {
	WebUI.click(findTestObject('Object Repository/Manage Channel/Delete Channel/button_confirm delete'))
} else {
	WebUI.click(findTestObject('Object Repository/Manage Channel/Delete Channel/button_confirm delete app'))
}

String channelDeletedXpath = "//*[@id='$newChannelId']"

TestObject channelDeletedObj = CustomKeywords.'mezon.GetTestObject.withXpath'(channelDeletedXpath)

WebUI.verifyElementNotPresent(channelDeletedObj, 15)







