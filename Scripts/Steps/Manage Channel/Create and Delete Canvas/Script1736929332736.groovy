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
import org.openqa.selenium.JavascriptExecutor
import com.kms.katalon.core.webui.driver.DriverFactory 

WebUI.callTestCase(findTestCase('Steps/Channel Message/Select channel'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Manage Channel/Create and Delete Canvas/button_Canvas Pannel'))

WebUI.click(findTestObject('Manage Channel/Create and Delete Canvas/Button_Create Canvas'))

String canvasTitle = 'new canvas'

WebUI.setText(findTestObject('Manage Channel/Create and Delete Canvas/textarea_Canvas Title'), canvasTitle)

WebElement canvasTitleBreadcrumbElement = WebUI.findWebElement(findTestObject('Object Repository/Manage Channel/Create and Delete Canvas/breadcrumb_Canvas Title'))

String canvasTitleBreadcrumb = canvasTitleBreadcrumbElement.getText()

if (!(canvasTitleBreadcrumb.equals(canvasTitle))) {
    WebUI.takeScreenshot()

    KeywordUtil.markFailedAndStop('Not Change Canvas Title!')
}

WebUI.click(findTestObject('Manage Channel/Create and Delete Canvas/button_Canvas Pannel'))

Boolean verifyNewCanvasPresent = false

for (int i = 0; i < 15; i++) {
    WebElement newCanvasElement = WebUI.findWebElement(findTestObject('Object Repository/Manage Channel/Create and Delete Canvas/div_New Canvas'))

    String newCanvas = newCanvasElement.getText()

    if (newCanvas.equals(canvasTitle)) {
        verifyNewCanvasPresent = true

        break
    }
    
    WebUI.delay(1)
}

if (!(verifyNewCanvasPresent)) {
    WebUI.takeScreenshot()

    KeywordUtil.markFailedAndStop('New Canvas not present!')
}

WebElement newCanvasElement = WebUI.findWebElement(findTestObject('Object Repository/Manage Channel/Create and Delete Canvas/div_canvas container'))

WebDriver driver = DriverFactory.getWebDriver()

JavascriptExecutor js = (JavascriptExecutor) driver

String newId = 'newCanvasId'

js.executeScript('arguments[0].setAttribute(\'id\', arguments[1]);', newCanvasElement, newId)

String canvasItemXpath = "//*[@id='$newId']"  

String buttonDeleteCanvasXpath = "//*[@id='$newId']/button[2]"

TestObject canvasItemObj = CustomKeywords.'mezon.GetTestObject.withXpath'(canvasItemXpath)

TestObject buttonDeleteCanvasObj =  CustomKeywords.'mezon.GetTestObject.withXpath'(buttonDeleteCanvasXpath)

WebUI.click(buttonDeleteCanvasObj)

WebUI.verifyElementNotPresent(canvasItemObj, 15)

