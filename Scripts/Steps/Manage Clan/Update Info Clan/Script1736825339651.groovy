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
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

WebUI.callTestCase(findTestCase('Steps/Login_Logout and SignUp/Login with email and password'), [('email') : 'E2E1762357@ncc.asia'
        , ('password') : 'E2E1762357'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Manage Clan/Update Info Clan/div_Clan'))

WebUI.click(findTestObject('Manage Clan/Delete Clan/div_Clan Header'))

WebUI.click(findTestObject('Manage Channel/Create Role/button_Clan Setting'))

String logoFile = 'test logo.png'

String logoImagePath = (RunConfiguration.getProjectDir().replace('/', '\\') + '\\Data Files\\Image\\') + logoFile

WebUI.uploadFile(findTestObject('Manage Clan/Update Info Clan/input_Upload Clan Logo'), logoImagePath)

Random generator = new Random()

int randomNumber = generator.nextInt()

String newClanName = "new clan $randomNumber"

WebUI.setText(findTestObject('Manage Clan/Update Info Clan/input_Clan Name'), newClanName)

String bannerImage = 'banner.png'

String bannerImagePath = (RunConfiguration.getProjectDir().replace('/', '\\') + '\\Data Files\\Image\\') + bannerImage

WebUI.uploadFile(findTestObject('Object Repository/Manage Clan/Update Info Clan/input_Upload Banner Background'), bannerImagePath)

WebUI.click(findTestObject('Object Repository/Manage Clan/Update Info Clan/button_Save Changes'))

WebUI.click(findTestObject('Object Repository/Manage Clan/Update Info Clan/button_ESC'))

WebElement clanHeaderElement = WebUI.findWebElement(findTestObject('Manage Clan/Delete Clan/div_Clan Header'))

String clanNameCurrent = clanHeaderElement.getText().toLowerCase()

if (!(clanNameCurrent.equals(newClanName))) {
    KeywordUtil.markFailedAndStop('Not change clan name!')
}

WebUI.verifyElementPresent(findTestObject('Object Repository/Manage Clan/Update Info Clan/img_banner'), 15)

WebElement bannerElement = WebUI.findWebElement(findTestObject('Object Repository/Manage Clan/Update Info Clan/img_banner'))

String bannerHref = bannerElement.getAttribute('src')

if (!(bannerHref.contains(bannerImage))) {
    WebUI.takeScreenshot()

    KeywordUtil.markFailedAndStop('Error banner!')
}

WebDriver driver = DriverFactory.getWebDriver()

String currentURL = driver.getCurrentUrl()

String clanId = currentURL.split('/')[5]

String clanLogoXpath = "//*[@id='menu']/div/div[3]//div/div/a[@href='/chat/clans/$clanId']/div/div[2]/div/img"

TestObject clanLogoObj = CustomKeywords.'mezon.GetTestObject.withXpath'(clanLogoXpath)

WebElement clanLogo = WebUI.findWebElement(clanLogoObj)

String clanLogoSrc = clanLogo.getAttribute('src')

if (!(clanLogoSrc.contains(logoFile.replaceAll(' ', '_')))) {
    WebUI.takeScreenshot()

    KeywordUtil.markFailedAndStop('Error clan avatar!')
}


