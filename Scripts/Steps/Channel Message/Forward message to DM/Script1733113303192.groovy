import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import java.awt.Checkbox as Checkbox
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
import org.openqa.selenium.By as By
import com.kms.katalon.core.testobject.ConditionType as ConditionType

WebUI.callTestCase(findTestCase('Steps/Channel Message/Send Message Text'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('Channel Message/Forward message to DM/div_latest_message'))

WebUI.click(findTestObject('Channel Message/Forward message to DM/button_more'))

WebUI.click(findTestObject('Channel Message/Forward message to DM/button_forward'))

WebUI.waitForElementVisible(findTestObject('Channel Message/Forward message to DM/div_forward_container'), 5)

TestObject forwardContainerObj = findTestObject('Channel Message/Forward message to DM/div_forward_container')

List<WebElement> forwardList = WebUI.findWebElement(forwardContainerObj).findElements(By.tagName('div'))

for (int i = 1; i <= forwardList.size(); i++) {
    WebElement forward = forwardList.get(i)

    String spanUsernameXpath = "/html/body/div[3]/div/div/div/div/div[2]/div/div[$i]/div/div/span"

    TestObject spanUsernameObj = getTestObjectWithXpath(spanUsernameXpath)

    String spanUsernameValue = WebUI.findWebElement(spanUsernameObj).getText()

    if (spanUsernameValue !== '') {
        String checkBoxXpath = "/html/body/div[3]/div/div/div/div/div[2]/div/div[$i]/input"

        TestObject checkBoxObj = getTestObjectWithXpath(checkBoxXpath)

        WebUI.check(checkBoxObj)

        break
    }
}

WebUI.click(findTestObject('Channel Message/Forward message to DM/button_send_forward_message'))

WebUI.waitForElementPresent(findTestObject('Channel Message/Forward message to DM/div_toast_success'), 5)

static TestObject getTestObjectWithXpath(String xpath) {
    return new TestObject().addProperty('xpath', ConditionType.EQUALS, xpath)
}

