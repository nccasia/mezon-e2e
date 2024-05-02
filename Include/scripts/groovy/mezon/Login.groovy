package mezon

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

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

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

class Login {

    // Given I am logged in with "<email>" and "<password>"
    @Given('I am logged in with "(.*)" and "(.*)"')
    def givenIAmLoggedInWith(String email, String password) {
        WebUI.callTestCase(findTestCase('Definitions/I am logged in with'), [('email') : email
            , ('password') : password], FailureHandling.STOP_ON_FAILURE)
    }

    // Given The Login Page is opening
    @Given('The Login Page is opening')
    def givenIAmOnLoginPage() {
        WebUI.callTestCase(findTestCase('Definitions/The Login Page is opening'), [:], FailureHandling.STOP_ON_FAILURE)
    }

    // When I login with "<email>" and "<password>"
    @Then('Login page should display correctly')
    def givenLoginPageShouldDisplayCorrectly() {
        WebUI.callTestCase(findTestCase('Web UI/Login page should display correctly'), [:], FailureHandling.STOP_ON_FAILURE)
    }

}
