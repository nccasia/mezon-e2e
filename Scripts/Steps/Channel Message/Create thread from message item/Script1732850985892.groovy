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
    String buttonThreadXpath = '//*[@id=\'main-layout\']/div/div[3]/div/div[1]/div[2]/div/div[1]/div[1]/div[2]'

    TestObject buttonThreadObj = CustomKeywords.'mezon.GetTestObject.withXpath'(buttonThreadXpath)

    WebElement buttonThreadElement = WebUI.findWebElement(buttonThreadObj)

    buttonThreadElement.click()

    String buttonCreateThreadXpath = '//*[@id=\'main-layout\']/div/div[3]/div/div[1]/div[2]/div/div[1]/div[1]/div[2]/div/div/div[1]/div[3]/button[1]'

    TestObject buttonCreateThreadObj = CustomKeywords.'mezon.GetTestObject.withXpath'(buttonCreateThreadXpath)
	
	WebElement buttonCreateThreadElement = WebUI.findWebElement(buttonCreateThreadObj)
	
	buttonCreateThreadElement.click()
} else {
    WebUI.click(findTestObject('Channel Message/Create thread from message item/div_button thread'))

    WebUI.click(findTestObject('Channel Message/Create thread from message item/button_create thread'))
}

Random generator = new Random()

String threadName = "vp-qn ${generator.nextInt()}"

WebUI.setText(findTestObject('Channel Message/Create thread from message item/input_name thread'), threadName)

WebUI.check(findTestObject('Channel Message/Create thread from message item/input_check private thread'))

CustomKeywords.'mezon.SendText.sendText'(findTestObject('Channel Message/Create thread from message item/texarea_send message'), 
    'helo ae qn', Keys.chord(Keys.ENTER))

WebElement threadsOfGeneral

if (GlobalVariable.isThread) {
    String threadContainerXpath = "//*[@id='$GlobalVariable.channelID']/following-sibling::div[1]"

    TestObject threadContainerObj = CustomKeywords.'mezon.GetTestObject.withXpath'(threadContainerXpath)

    threadsOfGeneral = WebUI.findWebElement(threadContainerObj)
} else {
    threadsOfGeneral = WebUI.findWebElement(findTestObject('Channel Message/Create thread from message item/div_threads_ general'))
}

List<WebElement> threads = threadsOfGeneral.findElements(By.tagName('div'))

WebElement newThread

for (WebElement thread : threads) {
    WebElement aTag = thread.findElement(By.tagName('a'))

    String value = aTag.getText().trim()

    if (value == threadName) {
        newThread = thread
    }
}

if (!(newThread)) {
    KeywordUtil.markFailedAndStop('Thread doesn\'t exist!')
}

newThread.click()

WebElement threadBreadCrumb = WebUI.findWebElement(findTestObject('Channel Message/Create thread from message item/p_Thread breadcrumb'))

String threadBreadCrumbText = threadBreadCrumb.getText()

if (threadBreadCrumbText != threadName) {
    KeywordUtil.markFailed('Failed')
}

