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

import internal.GlobalVariable

import java.nio.file.Files
import java.nio.file.Paths
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
//import java.nio.file.Files as Files
//import java.nio.file.Paths as Paths
import java.io.File;
public class VerifySaveImage {

	@Keyword
	def verifySaveImage(String downloadPath, String filename) {

		int timeout = 5; // Timeout in seconds
		int interval = 1;
		Boolean isDownloaded = waitForSaveImage(downloadPath, filename, timeout, interval)
		if (isDownloaded) {
			KeywordUtil.markPassed("Download successful")
		} else {
			KeywordUtil.markFailedAndStop("Download failed")
		}
	}
	
	public static boolean waitForSaveImage(String downloadPath, String fileName, int timeout, int interval) {
		int waited = 0;
		while (waited < timeout) {
			File dir = new File(downloadPath);
			File[] files = dir.listFiles();
			for (String file : files) {
				String fl = file.replace("${downloadPath}\\", '')
				if (fl.startsWith(fileName) && fl.endsWith('.png')) {
					return true;
				}
			}
			try {
				Thread.sleep(interval * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			waited += interval;
		}
		return false;
	}
}
