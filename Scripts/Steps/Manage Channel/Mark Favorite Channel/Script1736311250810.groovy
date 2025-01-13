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
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.callTestCase(findTestCase('Steps/Manage Channel/Create and Delete New Private Channel'), [:], FailureHandling.STOP_ON_FAILURE)

WebElement ChannelElement = WebUI.findWebElement(findTestObject('Object Repository/Manage Channel/Create New Public Channel/div_New Channel'), 
    15)

WebElement ChannelSVGContainerElement = WebUI.findWebElement(findTestObject('Object Repository/Manage Channel/Mark Favorite Channel/div_new Channel SVG Container'),
	15)

String ChannelName = ChannelElement.getText()

String ChannelSVG = ChannelSVGContainerElement.getAttribute('innerHTML')

WebUI.rightClick(findTestObject('Manage Channel/Create New Public Channel/div_New Channel'))

WebUI.click(findTestObject('Object Repository/Manage Channel/Mark Favorite Channel/button_Mark Favorite'))

Boolean verifyMarkFavoriteChannel = false

for (int i = 0; i < 15; i++) {
	try {
		WebElement newFavoriteChannelElement = WebUI.findWebElement(findTestObject('Object Repository/Manage Channel/Mark Favorite Channel/div_New Favorite Channel'), 
			1)
		
		WebElement newFavoriteChannelSVGContainerElement = WebUI.findWebElement(findTestObject('Object Repository/Manage Channel/Mark Favorite Channel/div_New Favorite Channel SVG Container'),
			1)
		
		String favoriteChannelName = newFavoriteChannelElement.getText()
		
		String newFavoriteChannelSVG = newFavoriteChannelSVGContainerElement.getAttribute("innerHTML")
		if (favoriteChannelName.equals(ChannelName) && newFavoriteChannelSVG.equals(ChannelSVG)) {
			verifyMarkFavoriteChannel = true
			break
		}
		WebUI.delay(1)
	} catch (e) {
		WebUI.delay(1)
	}
}

if (!(verifyMarkFavoriteChannel)) {
    WebUI.takeScreenshot()
    KeywordUtil.markFailedAndStop('Mark Favorite Channel Failed!')
}

