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

WebUI.callTestCase(findTestCase('Steps/Manage Clan/Select a Clan'), [:], FailureHandling.STOP_ON_FAILURE)

WebElement clanNameElement = WebUI.findWebElement(findTestObject('Object Repository/User Profile/Change Clan Nickname/p_Clan Name'))

String clanName = clanNameElement.getText()

WebUI.click(findTestObject('User Profile/Change Clan Nickname/button_Setting'))

WebUI.click(findTestObject('User Profile/Change Clan Nickname/button_Profile Option'))

WebUI.click(findTestObject('Object Repository/User Profile/Change Clan Nickname/dropdown_Clans'))

WebElement selectClanElement = WebUI.findWebElement(findTestObject('Object Repository/User Profile/Change Clan Nickname/dropdown_Clans'))

List<WebElement> ClanOptionsElement = selectClanElement.findElements(By.tagName('option'))

for (WebElement ClanOptionElement : ClanOptionsElement) {
    String ClanOption = ClanOptionElement.getAttribute('value').toUpperCase()

    if (ClanOption.equals(clanName)) {
        ClanOptionElement.click()

        break
    }
}

String newClanNickname = CustomKeywords.'mezon.Random.text'('nickname')

WebUI.setText(findTestObject('User Profile/Change Clan Nickname/input_Enter Nickname'), newClanNickname)

WebElement previewClanNicknameElement = WebUI.findWebElement(findTestObject('Object Repository/User Profile/Change Clan Nickname/p_Preview Clan Nickname'))

String previewClanNickname = previewClanNicknameElement.getText()

if (!(previewClanNickname.equals(newClanNickname))) {
    WebUI.takeScreenshot()
    KeywordUtil.markFailedAndStop('Error preview clan nickname')
}

WebUI.click(findTestObject('User Profile/Change Clan Nickname/button_Save Changes'))

WebUI.verifyElementNotPresent(findTestObject('User Profile/Change Clan Nickname/button_Save Changes'), 15)

WebUI.click(findTestObject('User Profile/Change Clan Nickname/button_ESC'))

WebUI.callTestCase(findTestCase('Steps/Channel Message/Reply message'), [('isCalled') : true], FailureHandling.STOP_ON_FAILURE)

WebElement displayNameInMessageElement = WebUI.findWebElement(findTestObject('Object Repository/User Profile/Change Clan Nickname/span_displayName in message'))

String displayName = displayNameInMessageElement.getText()

if(!displayName.equals(newClanNickname)) {
	WebUI.takeScreenshot()
    KeywordUtil.markFailed('Error display clan nickname')
}


