package mezon
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException


class DomUtils {
    /**
     * Verify that has a child element with text
     * @param parent parent element
     * @param text text to verify
     * @return void
     */
    @Keyword
    def verifyChildrenByText(TestObject parrent, String text) {
        WebElement parentEl = WebUiBuiltInKeywords.findWebElement(parrent, 30)
        List<WebElement> childrenEl = parentEl.findElements(By.xpath(".//*"))

        for (WebElement childEl : childrenEl) {
            if (childEl.getText().equals(text)) {
                KeywordUtil.markPassed("Element has a child with text: " + text)
                return
            }
        }

        KeywordUtil.markFailed("Element does not have a child with text: " + text)
    }

    /**
     * find element by text content
     * @param TestObject parent
     * @param String text
     * @return WebElement
     */
    @Keyword
    def findElementByText(TestObject parent, String text) {
        WebElement parentEl = WebUiBuiltInKeywords.findWebElement(parent, 30)
        List<WebElement> childrenEl = parentEl.findElements(By.xpath(".//*"))

        for (WebElement childEl : childrenEl) {
            String elText = childEl.getText()
            String cleanElText = elText.replaceAll("\\s+", " ").trim()
            if (cleanElText.equals(text)) {
                return childEl
            }
        }

        KeywordUtil.markFailed("Element does not have a child with text: " + text)
    }
}