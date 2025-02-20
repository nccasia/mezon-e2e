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

WebElement messageContainer = WebUI.findWebElement(findTestObject('Channel Message/Load more message/div_message container'))

messageContainer.click()

WebElement message = WebUI.findWebElement(findTestObject('Channel Message/Load more message/div_message'))

String firstMessageId = message.getAttribute("id")

int loopTimes = 50
	
for (int i = 0; i < loopTimes; i++) {
    WebUI.sendKeys(findTestObject('Channel Message/Load more message/div_message container'), Keys.chord(Keys.ARROW_UP))
}

Boolean isLoadMoreSuccess = false

for (int i = 0; i < 15; i++) {
	message = WebUI.findWebElement(findTestObject('Channel Message/Load more message/div_message'))
	
	String firstMessageLoadedId= message.getAttribute("id")
	println firstMessageId
	println firstMessageLoadedId
	if (!firstMessageLoadedId.equals(firstMessageId)) {
		isLoadMoreSuccess = true
		break
	}

	WebUI.delay(1)
}

if (!isLoadMoreSuccess) {
	WebUI.takeScreenshot()
	
    KeywordUtil.markFailed('Loading messages failed')
}

