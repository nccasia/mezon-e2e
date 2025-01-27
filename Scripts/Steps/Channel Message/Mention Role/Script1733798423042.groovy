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

WebUI.callTestCase(findTestCase('Steps/Channel Message/Select channel'), [:], FailureHandling.STOP_ON_FAILURE)

WebElement textAreaElem = WebUI.findWebElement(findTestObject('Channel Message/Send file/textarea_Clan T_general channel'))

WebUI.setText(findTestObject('Channel Message/Send file/textarea_Clan T_general channel'), '@')

WebElement mentionBoxElem

if (GlobalVariable.isDirectMessage) {
    WebUI.verifyElementPresent(findTestObject('Object Repository/Direact Message/Mention Role/div_suggestions'), 15)

    mentionBoxElem = WebUI.findWebElement(findTestObject('Object Repository/Direact Message/Mention Role/div_suggestions'))
} else {
    WebUI.verifyElementPresent(findTestObject('Channel Message/Mention Role/div_mention box'), 15)

    mentionBoxElem = WebUI.findWebElement(findTestObject('Channel Message/Mention Role/div_mention box'))
}

List<WebElement> liTagList = mentionBoxElem.findElements(By.tagName('li'))

String svgContentFromFile = CustomKeywords.'mezon.ConvertFile.toString'('\\Data Files\\Svg\\Role image.svg')

for (WebElement liTag : liTagList) {
    String liId = liTag.getAttribute('id')

    try {
        String svgXpath = "//*[@id='$liId']/div/div/div"

        TestObject svgObj = CustomKeywords.'mezon.GetTestObject.withXpath'(svgXpath)

        WebElement svg = WebUI.findWebElement(svgObj)

        String svgContentFromWeb = svg.getAttribute('innerHTML')

        if (svgContentFromWeb == svgContentFromFile) {
            liTag.click()

            break
        }
    }
    catch (def error) {
        println(error.message)
    } 
}

String textOfTextArea = textAreaElem.getText().trim()

WebUI.sendKeys(findTestObject('Channel Message/Send file/textarea_Clan T_general channel'), Keys.chord(Keys.ENTER))

Boolean isSending = CustomKeywords.'mezon.SendingMessage.isSendingMessage'()

if (isSending) {
    WebUI.takeScreenshot()

    KeywordUtil.markFailedAndStop('Sending message failed')
}

WebElement latestMessageElem = WebUI.findWebElement(findTestObject('Object Repository/Channel Message/Mention Role/span_metion role message'))

String textLatestMessage = latestMessageElem.getText()

if (textLatestMessage != textOfTextArea) {
    WebUI.takeScreenshot()

    KeywordUtil.markFailedAndStop("Error message! - textLatestMessage: '$textLatestMessage'; textOfTextArea: '$textOfTextArea'")
}



