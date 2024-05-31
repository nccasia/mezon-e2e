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
// Import Selenium WebElement
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

'select channel general'
WebUI.click(findTestObject('Channel Message/Page_Mezon/span_channel'))

WebUI.click(findTestObject('Channel Message/Select channel and send message/span_general'))

WebUI.click(findTestObject('Channel Message/Page_Mezon/span_channel'))

// Find the list of WebElements
List<WebElement> listMember = WebUI.findWebElements(findTestObject('Object Repository/Channel Message/Page_Mezon/quantity_members'), 
    0)

// Get the count of found elements
int count = listMember.size()

// Check if the count is greater than or equal to 2
if (count >= 2) {
    // Click on the second member if the condition is true
    WebUI.click(findTestObject('Object Repository/Channel Message/Page_Mezon/p_member2'))

    WebUI.setText(findTestObject('Channel Message/Page_Mezon/Input_ROLES'), Message1)

    WebUI.sendKeys(findTestObject('Object Repository/Channel Message/Page_Mezon/send_text'), Keys.chord(Keys.ENTER))

    // Wait for a brief moment to ensure the message is sent and displayed
    WebUI.delay(2)

    WebUI.click(findTestObject('Object Repository/Channel Message/Page_Mezon/img_DM_clan'))

    WebUI.click(findTestObject('Channel Message/Page_Mezon/DM_member_1'))

    // Find all div elements matching the class
    List<WebElement> boxTextelements = WebUI.findWebElements(findTestObject('Object Repository/Channel Message/Page_Mezon/Box_text'), 
        0)

    // Check if the list is not empty
    if (!(boxTextelements.isEmpty())) {
        // Get the last element in the list
        WebElement lastDivElement = boxTextelements.get(boxTextelements.size() - 1)

        // Optionally, you can click on the last div element or perform other actions
        WebUI.executeJavaScript('arguments[0].click();', Arrays.asList(lastDivElement))

        //Get the text of the last div element
        String lastDivText = lastDivElement.getText().trim()

        if (lastDivText.equals(Message1)) {
            return true
        } else {
            KeywordUtil.markFailed((('The message does not match the expected text. Expected: ' + Message1) + ', but got: ') + 
                lastDivText)

            return false
        }
    }
}

