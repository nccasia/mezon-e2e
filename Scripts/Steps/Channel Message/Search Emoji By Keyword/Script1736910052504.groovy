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

WebUI.callTestCase(findTestCase('Steps/Channel Message/Select channel'), [:], FailureHandling.STOP_ON_FAILURE)

String emojiKeyword = "apple"

if(GlobalVariable.isDirectMessage) {
	WebUI.click(findTestObject('Object Repository/Direact Message/Send emoji/button_emoji pannel'))
	
	WebUI.verifyElementPresent(findTestObject('Object Repository/Direact Message/Send emoji/div_emojis display'), 15)
	
	WebUI.setText(findTestObject('Object Repository/Channel Message/Search Emoji By Keyword/input_Search Emoji in DM'), emojiKeyword)
	
	verifySearchEmoji(findTestObject('Object Repository/Channel Message/Search Emoji By Keyword/img_emoji result in DM'), emojiKeyword)
} else {
	WebUI.click(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/Button_Emojis pannel'))
	
	WebUI.verifyElementPresent(findTestObject('Object Repository/Channel Message/Send emoji, sticker, GIF/Page_Mezon/div_emojis list display'), 15)
	
	WebUI.setText(findTestObject('Object Repository/Channel Message/Search Emoji By Keyword/input_Search Emoji in Channel'), emojiKeyword)
	
	verifySearchEmoji(findTestObject("Object Repository/Channel Message/Search Emoji By Keyword/img_emoji result in Channel"), emojiKeyword)
}

def verifySearchEmoji (TestObject emojiItem, String emojiKeyword) {
	List<WebElement> results = WebUI.findWebElements(emojiItem, 15)
	Boolean isSuccess = true
	for (WebElement result : results) {
		String alt = result.getDomAttribute("alt")
		if(!alt.contains(emojiKeyword)) {
			isSuccess = false
		}
	}
	if(!isSuccess) {
		WebUI.takeScreenshot()
		KeywordUtil.markFailed("Error search emoji")
	}
}