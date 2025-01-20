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

WebDriver driver = DriverFactory.getWebDriver()

WebUI.click(findTestObject('Manage Channel/Leave Thread/div_Clan'))

WebElement channelElement = WebUI.findWebElement(findTestObject('Object Repository/Manage Channel/Leave Thread/div_channel'))

String channelId = channelElement.getAttribute('id')

channelElement.click()

WebUI.click(findTestObject('Manage Channel/Leave Thread/button_Thread Pannel'))

WebUI.click(findTestObject('Manage Channel/Leave Thread/button_Thread Item'))

String currentUrl = driver.getCurrentUrl()

String href = splice(currentUrl, '/chat/')

String threadSelectedXpath = "//*[@id='$channelId']/following-sibling::div[1]/div//*[contains(@href, '$href')]"

TestObject threadSelectedObj = CustomKeywords.'mezon.GetTestObject.withXpath'(threadSelectedXpath)

WebUI.rightClick(threadSelectedObj)

WebUI.click(findTestObject("Object Repository/Manage Channel/Leave Thread/button_Leave Thread Option"))

WebUI.click(findTestObject("Object Repository/Manage Channel/Leave Thread/button_Leave Thread"))

WebUI.verifyElementNotPresent(threadSelectedObj, 15)

def splice(String text, String keywordStart, String keyWordEnd = '') {
    int startIndex = text.indexOf(keywordStart) + keywordStart.size()

    int endIndex

    if (keyWordEnd) {
        endIndex = text.indexOf(keyWordEnd)
    } else {
        endIndex = text.size()
    }
    
    String textSpliced = text.substring(startIndex, endIndex)

    return textSpliced
}

