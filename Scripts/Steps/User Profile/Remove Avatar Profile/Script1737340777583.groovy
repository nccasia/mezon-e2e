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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.callTestCase(findTestCase('Steps/Login_Logout and SignUp/Login with email and password'), [('email') : 'E2E1762357@ncc.asia'
        , ('password') : 'E2E1762357'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('User Profile/Change Display Name Profile/button_Setting'))

WebUI.click(findTestObject('User Profile/Change Clan Nickname/button_Profile Option'))

WebUI.click(findTestObject('User Profile/Change Display Name Profile/button_User Profile'))

WebElement previewAvatarElement = WebUI.findWebElement(findTestObject('Object Repository/User Profile/Remove Avatar Profile/img_Preview Avatar'))

String previewAvatarSrc = previewAvatarElement.getAttribute('src')

WebUI.click(findTestObject('User Profile/Remove Avatar Profile/button_Remove avatar'))

Boolean verifyRemoveAvatar = false

String previewAvatarSrcChanged

for (int i = 0; i < 15; i++) {
    previewAvatarElement = WebUI.findWebElement(findTestObject('Object Repository/User Profile/Remove Avatar Profile/img_Preview Avatar'))

    previewAvatarSrcChanged = previewAvatarElement.getAttribute('src')

    if (!(previewAvatarSrcChanged.equals(previewAvatarSrc))) {
        verifyRemoveAvatar = true

        break
    }
    
    WebUI.delay(1)
}

if (!(verifyRemoveAvatar)) {
    WebUI.takeScreenshot()

    KeywordUtil.markFailedAndStop('Not remove avatar')
}

previewAvatarSrcChanged = splice(previewAvatarSrcChanged, '/plain/')

WebUI.click(findTestObject('User Profile/Change Display Name Profile/button_Save Changes'))

WebUI.click(findTestObject('User Profile/Change Clan Nickname/button_ESC'))

WebElement avatarProfileElement = WebUI.findWebElement(findTestObject('Object Repository/User Profile/Remove Avatar Profile/img_Avatar Profile'))

String avatarProfileSrc = avatarProfileElement.getAttribute('src')

avatarProfileSrc = splice(avatarProfileSrc, '/plain/')

if (!(avatarProfileSrc.equals(previewAvatarSrcChanged))) {
    WebUI.takeScreenshot()

    KeywordUtil.markFailedAndStop('Not remove avatar')
}

def splice(String text, String keywordStart, String keyWordEnd = '') {
    int startIndex = text.indexOf(keywordStart) + keywordStart.size()

    int endIndex

    if (keyWordEnd) {
        endIndex = text.indexOf(keyWordEnd)
    } else {
        endIndex = text.size()
    }
    
    String textSpliced = text.substring(startIndex, endIndex)

    return textSpliced
}

