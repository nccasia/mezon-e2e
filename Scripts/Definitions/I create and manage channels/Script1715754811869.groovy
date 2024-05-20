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

WebUI.callTestCase(findTestCase('Steps/Clan Creation and Managemet/Create a Clan'), [('clanName') : 'New Clan Test', ('pathToImage') : 'E:\\Data_Test\\Images\\image-1.jpg'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Steps/Channel Creation and Management/Create Text channels'), [('channelNamePrivate') : 'wellcome_private'
        , ('channelNamePublic') : 'wellcome-public', ('channelNameCancel') : '@chan$%)-'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Steps/Channel Creation and Management/Create Voice Channels'), [('voiceChannelPrivate') : 'VietNam'
        , ('voiceChannelPublic') : 'HanQuoc', ('voiceChannelCancel') : 'VietHan$%^123'], FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()

