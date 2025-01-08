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
import org.openqa.selenium.By as By
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import org.openqa.selenium.WebElement as WebElement

WebUI.callTestCase(findTestCase('Steps/Channel Message/Send Message Text'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('Channel Message/Reaction Message/div_latest message'))

if(GlobalVariable.isDirectMessage) {
	WebUI.click(findTestObject('Object Repository/Direact Message/Reaction Message/Button_reaction pannel'))
} else {
	WebUI.click(findTestObject('Channel Message/Reaction Message/button_reaction_pannel'))
}

String reactionHref = WebUI.findWebElement(findTestObject('Channel Message/Reaction Message/button_reaction')).findElement(By.tagName('img')).getAttribute('src')

WebUI.click(findTestObject('Channel Message/Reaction Message/button_reaction'))

WebUI.verifyElementPresent(findTestObject('Channel Message/Reaction Message/div_reacted'), 10)

String messageId = WebUI.getAttribute(findTestObject('Channel Message/Reaction Message/div_latest message'), 'id')

String reactionXpath = "//*[@id='$messageId']/div[2]/div/div"

TestObject reactionObj = CustomKeywords.'mezon.GetTestObject.withXpath'(reactionXpath)

WebUI.verifyElementPresent(reactionObj, 15)

WebElement reactionList = WebUI.findWebElement(reactionObj)

List<WebElement> imgTags = reactionList.findElements(By.tagName('img'))

boolean flag = false

for (WebElement img : imgTags) {
    String imgSrc = img.getAttribute('src')

    if (reactionHref == imgSrc) {
        flag = true
    }
}

if (!flag) {
	WebUI.takeScreenshot()
	
    KeywordUtil.markFailed('Reaction don\'t present')
}


