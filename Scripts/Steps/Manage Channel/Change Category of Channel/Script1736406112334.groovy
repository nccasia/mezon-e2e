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

WebUI.callTestCase(findTestCase('Steps/Manage Channel/Create New Public Channel'), [:], FailureHandling.STOP_ON_FAILURE)

WebElement channelElement = WebUI.findWebElement(findTestObject('Object Repository/Manage Channel/Create New Public Channel/div_New Channel'))

String channelId = channelElement.getAttribute('id')

String channelInnerHTML = channelElement.getAttribute("innerHTML")

WebUI.rightClick(findTestObject('Object Repository/Manage Channel/Create New Public Channel/div_New Channel'))

WebUI.click(findTestObject('Object Repository/Manage Channel/Update Info Channel/button_Edit Channel'))

WebUI.click(findTestObject('Object Repository/Manage Channel/Change Category of Channel/button_Category'))

WebElement optionHeaderElement = WebUI.findWebElement(findTestObject('Object Repository/Manage Channel/Change Category of Channel/header_option'))

String optionHeader = optionHeaderElement.getText()

if (!(optionHeader.equals('Category'))) {
    WebUI.takeScreenshot()

    KeywordUtil.markFailedAndStop('Error Header!')
}

WebUI.click(findTestObject('Object Repository/Manage Channel/Change Category of Channel/div_category of channel'))

WebUI.click(findTestObject('Object Repository/Manage Channel/Change Category of Channel/div_category option'))

String channelchangedCategoryxpath = "//*[@id='channelList']/div/div/div[1]/div[2]/div/div/div/div/div/div[4]/div/div/div/div[2]/div[@id='$channelId']"

TestObject channelchangedCategoryObj = CustomKeywords.'mezon.GetTestObject.withXpath'(channelchangedCategoryxpath)

WebUI.verifyElementPresent(channelchangedCategoryObj, 15)

WebElement channelchangedCategoryElement = WebUI.findWebElement(channelchangedCategoryObj)

String channelchangedCategoryInnerHTML = channelchangedCategoryElement.getAttribute("innerHTML")

if(!channelchangedCategoryInnerHTML.equals(channelInnerHTML)) {
	WebUI.takeScreenshot()
	
	KeywordUtil.markFailedAndStop('Error Icon or channel Name!')
}

