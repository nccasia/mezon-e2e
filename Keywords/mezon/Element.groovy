package mezon

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.JavascriptExecutor
import internal.GlobalVariable

public class Element {
	@Keyword 
	def getXpath(WebElement Element) {
		WebDriver driver = DriverFactory.getWebDriver()
		JavascriptExecutor JS = (JavascriptExecutor) driver
		String getXPathScript = """
		    function getXPath(element) {
		        if (element.id !== '') {
		            return 'id(\"' + element.id + '\")';
		        }
		        if (element === document.body) {
		            return element.tagName;
		        }
		
		        var ix = 0;
		        var siblings = element.parentNode.childNodes;
		        for (var i = 0; i < siblings.length; i++) {
		            var sibling = siblings[i];
		            if (sibling === element) {
		                return getXPath(element.parentNode) + '/' + element.tagName + '[' + (ix + 1) + ']';
		            }
		            if (sibling.nodeType === 1 && sibling.tagName === element.tagName) {
		                ix++;
		            }
		        }
		    }
		    return getXPath(arguments[0]);
		"""
		String xpath = (String) JS.executeScript(getXPathScript, Element);
		return xpath
	}
}
