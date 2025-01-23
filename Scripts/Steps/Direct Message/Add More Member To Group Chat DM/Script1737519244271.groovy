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

WebUI.callTestCase(findTestCase('Steps/Direct Message/Select conversation'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Direact Message/Add More Member To Group Chat DM/button_Show Member List'))

WebUI.click(findTestObject('Direact Message/Add More Member To Group Chat DM/button_Add Friend To DM'))

String username = 'nga.nguyenthi'

WebUI.setText(findTestObject('Object Repository/Direact Message/Add More Member To Group Chat DM/input_Search'), username)

WebUI.check(findTestObject('Direact Message/Add More Member To Group Chat DM/checkbox_friend'))

WebUI.click(findTestObject('Direact Message/Add More Member To Group Chat DM/button_Add To Group Chat'))

List<WebElement> memberElementList = WebUI.findWebElements(findTestObject('Object Repository/Direact Message/Add More Member To Group Chat DM/div_Member'), 
    15)

Boolean verifyAddMemberToGroup = false

TestObject memberObj

String id = 'new-member'

for (WebElement memberElement : memberElementList) {
    String text = memberElement.getText()

    if (text.contains(username)) {
        verifyAddMemberToGroup = true
        String memberxpath = CustomKeywords.'mezon.Element.getXpath'(memberElement)
        memberObj = CustomKeywords.'mezon.GetTestObject.withXpath'(memberxpath)
		CustomKeywords.'mezon.Attribute.add'(memberObj, 'id', id)
        break
    }
}

if (!(verifyAddMemberToGroup)) {
    WebUI.takeScreenshot()

    KeywordUtil.markFailed('Not show member')
}

WebUI.rightClick(memberObj)

WebUI.click(findTestObject('Object Repository/Direact Message/Add More Member To Group Chat DM/button_Remove From Group'))

String removeMemberXpath = "//*[@id='$id']"

TestObject removeMemberObj = CustomKeywords.'mezon.GetTestObject.withXpath'(removeMemberXpath)

WebUI.verifyElementNotPresent(removeMemberObj, 15)
