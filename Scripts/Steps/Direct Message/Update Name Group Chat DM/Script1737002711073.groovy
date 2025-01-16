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
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.JavascriptExecutor 

WebUI.callTestCase(findTestCase('Steps/Direct Message/Create DM or Group Chat'), [('isCreateGroupChat') : true], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Direact Message/Update Name Group Chat DM/h2_Group Name'))

String newGroupName = CustomKeywords.'mezon.Random.text'('group')

CustomKeywords.'mezon.SendText.sendText'(findTestObject('Direact Message/Update Name Group Chat DM/input_Group Name'), newGroupName, 
    Keys.chord(Keys.ENTER))

WebElement groupNameElement = WebUI.findWebElement(findTestObject('Direact Message/Update Name Group Chat DM/h2_Group Name'))

String groupName = groupNameElement.getText()

if (!(groupName.equals(newGroupName))) {
    WebUI.takeScreenshot()

    KeywordUtil.markFailedAndStop('Not change group name')
}

WebElement selectedConversationElement = WebUI.findWebElement(findTestObject('Object Repository/Direact Message/Update Name Group Chat DM/div_Selected Conversation'))

WebDriver driver = DriverFactory.getWebDriver()

JavascriptExecutor JS = (JavascriptExecutor) driver

String id = 'selected'

JS.executeScript('arguments[0].setAttribute(\'id\', arguments[1]);', selectedConversationElement, id)

String groupNameSelectedXpath = "//*[@id='$id']/div/div/div[2]/div[2]/div/p/span"

TestObject groupNameSelectedObj = CustomKeywords.'mezon.GetTestObject.withXpath'(groupNameSelectedXpath)

WebElement groupNameSelectedElement = WebUI.findWebElement(groupNameSelectedObj)

String groupNameSelected = groupNameSelectedElement.getText()

if (!(groupNameSelected.equals(newGroupName))) {
    WebUI.takeScreenshot()

    KeywordUtil.markFailed('Not change group name')
}

WebUI.callTestCase(findTestCase('Steps/Direct Message/Leave Group'), [('isCalled') : true], FailureHandling.STOP_ON_FAILURE)

