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

WebUI.callTestCase(findTestCase('Steps/Login_Logout and SignUp/Login with email and password'), [('email') : 'E2E1762357@ncc.asia'
        , ('password') : 'E2E1762357'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Steps/Channel Message/Send message'), [('Message') : 'welcome to my channel'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Steps/Channel Message/Edit, Reply, Forward, Copy, Delete message'), [('Message_1') : 'Test send message successfully'
        , ('Message_edit_1') : 'message after editing', ('Message_edit_2') : 'Edited messages are saved using the ENTER key'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Web UI/Channel message display'), [('PUBLIC_CHANNEL') : 'PUBLIC CHANNEL', ('general') : 'general'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Steps/Channel Message/Send emojis, stickers, GIF'), [('Emoji1') : 'E:\\Data_Test\\Emoji-Sticker-GIF\\arrow_right.png'
        , ('Emoji2') : 'E:\\Data_Test\\Emoji-Sticker-GIF\\fox_face.png', ('Emoji3') : 'E:\\Data_Test\\Emoji-Sticker-GIF\\monkey.png'
        , ('Sticker1') : 'E:\\Data_Test\\Emoji-Sticker-GIF\\Sticker-1.gif', ('Sticker2') : '', ('Sticker3') : '', ('GIF1') : 'E:\\Data_Test\\Emoji-Sticker-GIF\\goodbye-thank-you.gif'
        , ('GIF2') : '', ('GIF3') : ''], FailureHandling.STOP_ON_FAILURE)

'select channel and send message for one person in the channel'
WebUI.callTestCase(findTestCase('Steps/Channel Message/Select channel and send message'), [('Message1') : 'Hi my friend'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Steps/Login_Logout and SignUp/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

