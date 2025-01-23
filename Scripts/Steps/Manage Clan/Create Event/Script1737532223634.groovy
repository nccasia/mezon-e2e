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

WebUI.click(findTestObject('Manage Clan/Create Event/button_Event'))

WebUI.click(findTestObject('Manage Clan/Create Event/button_Create Event'))

WebUI.check(findTestObject('Manage Clan/Create Event/radio_SomeWhere'))

String location = CustomKeywords.'mezon.Random.text'('location')

WebUI.setText(findTestObject('Manage Clan/Create Event/input_Enter a Location'), location)

WebUI.click(findTestObject('Manage Clan/Create Event/button_next'))

String newEventTopic = CustomKeywords.'mezon.Random.text'('eventTopic')

WebUI.setText(findTestObject('Object Repository/Manage Clan/Create Event/input_Event Topic'), newEventTopic)

String description = CustomKeywords.'mezon.Random.text'('description')

WebUI.setText(findTestObject('Object Repository/Manage Clan/Create Event/textarea_description'), description)

String imagePath = CustomKeywords.'mezon.File.getPath'('\\Data Files\\Image\\banner.png')

WebUI.uploadFile(findTestObject('Object Repository/Manage Clan/Create Event/button_Upload Image'), imagePath)

WebUI.verifyElementPresent(findTestObject('Object Repository/Manage Clan/Create Event/img_Upload Image'), 15)

WebElement displayImageElement = WebUI.findWebElement(findTestObject('Object Repository/Manage Clan/Create Event/img_Upload Image'))

String displayImageSrc = displayImageElement.getAttribute('src')

WebUI.click(findTestObject('Manage Clan/Create Event/button_next'))

WebElement previewImageElement = WebUI.findWebElement(findTestObject('Object Repository/Manage Clan/Create Event/img_Preview Image'))

String previewImageSrc = previewImageElement.getAttribute('src')

if (!(previewImageSrc.equals(displayImageSrc))) {
    WebUI.takeScreenshot()
    KeywordUtil.markFailedAndStop('Error image')
}

WebElement previewTimeElement = WebUI.findWebElement(findTestObject('Object Repository/Manage Clan/Create Event/p_Preview Time'))

String previewEventTime = previewTimeElement.getText()

WebElement previewEventTopicElement = WebUI.findWebElement(findTestObject('Object Repository/Manage Clan/Create Event/p_Preview Event Topic'))

String previewEventTopic = previewEventTopicElement.getText()

if (!(previewEventTopic.equals(newEventTopic))) {
    WebUI.takeScreenshot()
    KeywordUtil.markFailedAndStop('Error description')
}

WebElement previewDescriptionElement = WebUI.findWebElement(findTestObject('Object Repository/Manage Clan/Create Event/p_Preview Description'))

String previewDescription = previewDescriptionElement.getText()

if (!(previewDescription.equals(description))) {
    WebUI.takeScreenshot()
    KeywordUtil.markFailedAndStop('Error description')
}

WebElement previewLocationElement = WebUI.findWebElement(findTestObject('Object Repository/Manage Clan/Create Event/p_Preview Location'))

String previewLocation = previewLocationElement.getText()

if (!(previewLocation.equals(location))) {
    WebUI.takeScreenshot()
    KeywordUtil.markFailedAndStop('Error description')
}

WebUI.click(findTestObject('Manage Clan/Create Event/button_next'))

WebUI.click(findTestObject('Manage Clan/Create Event/button_Event'))

WebElement eventTimeElement = WebUI.findWebElement(findTestObject('Object Repository/Manage Clan/Create Event/p_Display Event Time'))

String eventTime = eventTimeElement.getText()

if (!eventTime.equals(previewEventTime)) {
    WebUI.takeScreenshot()
    KeywordUtil.markFailedAndStop('Error display event time')
}

WebElement eventTopicElement = WebUI.findWebElement(findTestObject('Object Repository/Manage Clan/Create Event/p_Display Event Topic'))

String eventTopic = eventTopicElement.getText()

if (!(eventTopic.equals(previewEventTopic))) {
	println eventTopic
	println previewEventTopic
    WebUI.takeScreenshot()
    KeywordUtil.markFailedAndStop('Error display event topic')
}

WebElement eventDescriptionElement = WebUI.findWebElement(findTestObject('Object Repository/Manage Clan/Create Event/p_Display Description'))

String eventDescription = eventDescriptionElement.getText()

if (!(eventDescription.equals(previewDescription))) {
    WebUI.takeScreenshot()
    KeywordUtil.markFailedAndStop('Error display event description')
}

WebElement eventLocationElement = WebUI.findWebElement(findTestObject('Object Repository/Manage Clan/Create Event/p_Display Location'))

String eventLocation = eventLocationElement.getText()

if (!(eventLocation.equals(previewLocation))) {
    WebUI.takeScreenshot()
    KeywordUtil.markFailedAndStop('Error display event description')
}

WebUI.verifyElementPresent(findTestObject('Manage Clan/Create Event/image_Display Image'), 15)

