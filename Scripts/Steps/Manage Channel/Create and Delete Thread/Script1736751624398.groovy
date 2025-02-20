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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.callTestCase(findTestCase('Steps/Channel Message/Select channel'), [:], FailureHandling.STOP_ON_FAILURE)

if (GlobalVariable.isThread) {
	
	WebUI.click(findTestObject('Channel Message/Create thread from message item/button_thread pannel - thread'))
	WebUI.click(findTestObject('Channel Message/Create thread from message item/button_create thread -thread'))
	
} else {
	if(GlobalVariable.isPrivateChannel) {
		WebUI.click(findTestObject('Channel Message/Create thread from message item/button_thread pannel - channel private'))
		WebUI.click(findTestObject('Channel Message/Create thread from message item/button_create thread - channel private'))
	} else {
		WebUI.click(findTestObject('Channel Message/Create thread from message item/button_thread pannel - channel public'))
		WebUI.click(findTestObject('Channel Message/Create thread from message item/button_create thread - channel public'))
	}
}

Random generator = new Random()

int randomNumber = generator.nextInt()

String threadName = "vp-qn $randomNumber"

WebUI.setText(findTestObject('Channel Message/Create thread from message item/input_name thread'), threadName)

WebUI.check(findTestObject('Channel Message/Create thread from message item/input_check private thread'))

CustomKeywords.'mezon.SendText.sendText'(findTestObject('Channel Message/Create thread from message item/texarea_send message'), 
    'helo ae qn', Keys.chord(Keys.ENTER))

WebElement threadTitleElement = WebUI.findWebElement(findTestObject("Object Repository/Manage Channel/Create and Delete a Thread/span_Thread Title"))

String threadTitle = threadTitleElement.getText()

if(!threadTitle.equalsIgnoreCase(threadName)) {
	WebUI.takeScreenshot()
	
	KeywordUtil.markFailedAndStop('New Thread Title is wrong!')
}

String newthreadXpath = "//*[@id='$GlobalVariable.channelID']/following-sibling::div[1]/div[last()]"

TestObject newthreadObj = CustomKeywords.'mezon.GetTestObject.withXpath'(newthreadXpath)

Boolean verifyNewThreadPresent = false

WebElement newthreadElement

for(int i = 0; i < 15; i++ ) {
	newthreadElement = WebUI.findWebElement(newthreadObj)
	
	String newThreadName = newthreadElement.getText()
	
	if (newThreadName.equals(threadName)) {
		verifyNewThreadPresent = true
		break
	}
	WebUI.delay(1)
}

if (verifyNewThreadPresent) {
	newthreadElement.click()
} else {
	WebUI.takeScreenshot()
		
	KeywordUtil.markFailedAndStop('New thread not present!')
}

WebElement threadBreadCrumb = WebUI.findWebElement(findTestObject('Channel Message/Create thread from message item/p_Thread breadcrumb'))

String threadBreadCrumbText = threadBreadCrumb.getText()

if (threadBreadCrumbText != threadName) {
	WebUI.takeScreenshot()
	
    KeywordUtil.markFailed("Error thread! - threadName: '$threadName'; threadBreadCrumbText: '$threadBreadCrumbText'")
}

String threadId = newthreadElement.getAttribute("id")

String deleteleThreadXpath = "//*[@id='$threadId']"

TestObject deleteleThreadObj = CustomKeywords.'mezon.GetTestObject.withXpath'(deleteleThreadXpath)

WebUI.rightClick(newthreadObj)

WebUI.click(findTestObject("Object Repository/Manage Channel/Create and Delete a Thread/button_Delete Thread Option"))

WebUI.click(findTestObject("Object Repository/Manage Channel/Create and Delete a Thread/button_Delete Thread"))

WebUI.verifyElementNotPresent(deleteleThreadObj, 15)

