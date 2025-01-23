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
import org.openqa.selenium.WebElement as WebElement


if (GlobalVariable.isDirectMessage) {
	WebUI.callTestCase(findTestCase('Steps/Direct Message/Select conversation'), [:], FailureHandling.STOP_ON_FAILURE)
	
} else {
	WebUI.callTestCase(findTestCase('Steps/Login_Logout and SignUp/Login with email and password'), [('email') : 'E2E1762357@ncc.asia'
		, ('password') : 'E2E1762357'], FailureHandling.STOP_ON_FAILURE)
	
    WebUI.click(findTestObject('Channel Message/Send emoji, sticker, GIF/Page_Mezon/div_Clan T'))

    WebElement channel = WebUI.findWebElement(GlobalVariable.channel)

    channel.click()

    GlobalVariable.channelID = channel.getAttribute('id')

    if (GlobalVariable.isChannelPrivate && GlobalVariable.isThread) {
        WebUI.click(findTestObject('Channel Message/Select thread/button_thread pannel - private'))

        if (GlobalVariable.isThreadPrivate) {
            WebUI.setText(findTestObject('Channel Message/Select channel and send message/input_ search thread - Channel Private'), 
                'Private Thread')
        } else {
            WebUI.setText(findTestObject('Channel Message/Select channel and send message/input_ search thread - Channel Private'), 
                'Public Thread')
        }
        
        WebUI.click(findTestObject('Channel Message/Select thread/div_thread private'))
    } else if (!(GlobalVariable.isChannelPrivate) && GlobalVariable.isThread) {
        WebUI.click(findTestObject('Channel Message/Select thread/button_thread pannel'))

        if (GlobalVariable.isThreadPrivate) {
            WebUI.setText(findTestObject('Channel Message/Select channel and send message/input_search thread - channel Public'), 
                'Private Thread')
        } else {
            WebUI.setText(findTestObject('Channel Message/Select channel and send message/input_search thread - channel Public'), 
                'Public Thread')
        }
        
        WebUI.click(findTestObject('Channel Message/Select thread/div_thread'))
    }
}

