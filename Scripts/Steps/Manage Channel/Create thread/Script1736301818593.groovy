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


if (GlobalVariable.isThread) {
	
	WebUI.click(findTestObject('Channel Message/Create thread from message item/button_thread pannel - thread'))
	WebUI.click(findTestObject('Channel Message/Create thread from message item/button_create thread -thread'))
	
} else {
	if(GlobalVariable.isChannelPrivate) {
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

WebElement threadsOfGeneral

String threadContainerXpath = "//*[@id='$GlobalVariable.channelID']/following-sibling::div[1]"

TestObject threadContainerObj = CustomKeywords.'mezon.GetTestObject.withXpath'(threadContainerXpath)

threadsOfGeneral = WebUI.findWebElement(threadContainerObj)

WebElement newThread = checkNewThreadPresent(threadsOfGeneral, threadName, 3, 1)

if (newThread) {
	newThread.click()
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

def checkNewThreadPresent(WebElement threadsContainer, String threadName, int timeout, int interval) {
	int waited = 0;
	WebElement newThread
	while (waited < timeout) {
		List<WebElement> threads = threadsContainer.findElements(By.tagName('div'))
		for (WebElement thread : threads) {
			String value = thread.getAttribute("innerText")
			if (value == threadName) {
				return thread
			}
		}
		try {
			Thread.sleep(interval * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		waited += interval;
	}
	return newThread;
}

