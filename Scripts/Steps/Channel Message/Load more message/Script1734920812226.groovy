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

List<WebElement> messagesCurrent = WebUI.findWebElements(findTestObject('Channel Message/Load more message/div_message'), 
    10)

int messagesCurrentQuantity = messagesCurrent.size()

WebUI.click(findTestObject('Channel Message/Load more message/div_message container'))

int loopTimes = 10
	
for (int i = 0; i < loopTimes; i++) {
    WebUI.sendKeys(findTestObject('Channel Message/Load more message/div_message container'), Keys.chord(Keys.ARROW_UP))
}

WebUI.takeScreenshot()

Boolean isLoadMoreSuccess = false

for (int i = 0; i < 15; i++) {
	List<WebElement> messagesLoaded = WebUI.findWebElements(findTestObject('Channel Message/Load more message/div_message'), 10)
	
	int messagesLoadedQuatity = messagesLoaded.size()
	
	if(messagesLoadedQuatity > messagesCurrentQuantity) {
		isLoadMoreSuccess = true
		break
	}
	WebUI.delay(1)
}

if (!isLoadMoreSuccess) {
	println isLoadMoreSuccess
    KeywordUtil.markFailed('Loading messages failed')
}

