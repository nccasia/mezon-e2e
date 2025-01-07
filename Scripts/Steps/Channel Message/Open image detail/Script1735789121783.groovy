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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import org.openqa.selenium.WebElement as WebElement

WebUI.callTestCase(findTestCase('Steps/Channel Message/Send image'), [:], FailureHandling.STOP_ON_FAILURE)

WebElement image = WebUI.findWebElement(findTestObject('Channel Message/Send Media/img_latest message'))

String HOST = "https://cdn.mezon.vn"

String imageSrc = cutUrl( HOST, image.getAttribute("src"))

image.click()

WebUI.verifyElementPresent(findTestObject('Channel Message/Send Media/img_latest message'), 10)

WebElement imageOfImageDetailModal = WebUI.findWebElement(findTestObject('Object Repository/Channel Message/Open image detail/modal_image detail'))

String imageOfImageDetailModalSrc = cutUrl( HOST, imageOfImageDetailModal.getAttribute("src"))

WebElement selectedImage = WebUI.findWebElement(findTestObject('Object Repository/Channel Message/Open image detail/image selected'))

String selectedImageSrc = cutUrl( HOST, selectedImage.getAttribute("src"))

if (imageSrc != imageOfImageDetailModalSrc || imageSrc != selectedImageSrc) {
	WebUI.takeScreenshot()
	
	KeywordUtil.markFailedAndStop("Error message - imageSrc: '$imageSrc'; imageOfImageDetailModalSrc: '$imageOfImageDetailModalSrc'; selectedImageSrc: '$selectedImageSrc'")
}

WebElement divNotSelectedImg =  WebUI.findWebElement(findTestObject('Object Repository/Channel Message/Open image detail/div_image not selected'))

WebElement notSelectedImg  = divNotSelectedImg.findElement(By.xpath('./div/img'))

String notSelectedImgSrc = cutUrl( HOST, notSelectedImg.getAttribute('src')) 

divNotSelectedImg.click()

imageOfImageDetailModalSrc = cutUrl( HOST, imageOfImageDetailModal.getAttribute("src"))

if (notSelectedImgSrc != imageOfImageDetailModalSrc) {
	WebUI.takeScreenshot()
	
	KeywordUtil.markFailed("Error image selected")
}

def cutUrl(String keyword, String url) {
	int index = url.indexOf(keyword);
	if (index == -1) {
		KeywordUtil.markFailedAndStop("keyword not inside URL");
		return "";
	} else {
		String result = url.substring(index);
		return result
	}
}

