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

import mezon.TestParams

class ClanManagement {

	// When I create a clan with name "<clanName>"
	@When('I create a clan with name "(.*)"')
	def whenICreateAClanWithName(String clanName) {
		WebUI.callTestCase(findTestCase('Definitions/I create a clan with name'), [('clanName') : TestParams.getParam(clanName)], FailureHandling.STOP_ON_FAILURE)
	}

	// Then I should see the clan "<clanName>" in my clan list
	@Then('I should see the clan "(.*)" in my clan list')
	def thenIShouldSeeTheClanInMyClanList(String clanName) {
		WebUI.callTestCase(findTestCase('Definitions/I should see the clan in my clan list'), [('clanName') : TestParams.getParam(clanName)], FailureHandling.STOP_ON_FAILURE)
	}

	// And I should natigated to the clan "<clanName>" page
	@And('I should natigated to the clan "(.*)" page')
	def andIShouldNatigatedToTheClanPage(String clanName) {
		WebUI.callTestCase(findTestCase('Definitions/I should natigated to the clan page'), [('clanName') : TestParams.getParam(clanName)], FailureHandling.STOP_ON_FAILURE)
	}

	// When I select the clan "<clanName>"
	@When('I select the clan "(.*)"')
	def whenISelectTheClan(String clanName) {
		WebUI.callTestCase(findTestCase('Definitions/I select the clan'), [('clanName') : TestParams.getParam(clanName)], FailureHandling.STOP_ON_FAILURE)
	}

	// Given I am on the clan "<clanName>" page
	@Given('I am on the clan "(.*)" page')
	def givenIAmOnTheClanPage(String clanName) {
		WebUI.callTestCase(findTestCase('Definitions/I am on the clan page'), [('clanName') : TestParams.getParam(clanName)], FailureHandling.STOP_ON_FAILURE)
	}
}
