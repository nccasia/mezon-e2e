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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import java.nio.file.Files as Files
import java.nio.file.Paths as Paths

WebUI.callTestCase(findTestCase('Steps/Channel Message/Select channel'), [:], FailureHandling.STOP_ON_FAILURE)

WebElement textAreaElem = WebUI.findWebElement(findTestObject('Channel Message/Send file/textarea_Clan T_general channel'))

WebUI.setText(findTestObject('Channel Message/Send file/textarea_Clan T_general channel'), '@')

WebUI.verifyElementPresent(findTestObject('Channel Message/Mention Role/div_mention box'), 5)

WebElement mentionBoxElem = WebUI.findWebElement(findTestObject('Channel Message/Mention Role/div_mention box'))

List<WebElement> liTagList = mentionBoxElem.findElements(By.tagName('li'))

String svgFilePath = RunConfiguration.getProjectDir().replace('/', '\\') + '\\Data Files\\Svg\\Role image.svg'

String svgContentFromFile = new String(Files.readAllBytes(Paths.get(svgFilePath)))

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
    catch (error) {
        println(error.message)
    } 
}

String textOfTextArea = textAreaElem.getText().trim()

WebUI.sendKeys(findTestObject('Channel Message/Send file/textarea_Clan T_general channel'), Keys.chord(Keys.ENTER))

Boolean isSending = CustomKeywords.'mezon.SendingMessage.isSendingMessage'()

if (isSending) {
	KeywordUtil.markFailedAndStop("Sending message failed")
}

WebElement latestMessageElem = WebUI.findWebElement(findTestObject('Channel Message/Send multiple file media/div_latest message'))

String textLatestMessage = latestMessageElem.getText()

if (textLatestMessage != textOfTextArea) {
    KeywordUtil.markFailedAndStop("Error message! - textLatestMessage: '${textLatestMessage}'; textOfTextArea: '${textOfTextArea}'")
}

