package mezon;
import internal.GlobalVariable;
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint;
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase;
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData;
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject;
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject;

import com.kms.katalon.core.annotation.Keyword;
import com.kms.katalon.core.checkpoint.Checkpoint;
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords;
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords;
import com.kms.katalon.core.model.FailureHandling;
import com.kms.katalon.core.testcase.TestCase;
import com.kms.katalon.core.testdata.TestData;
import com.kms.katalon.core.testobject.TestObject;
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords;
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords;
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords;

class TestParams {
    public static String getParam(String param) {
        // if param is end with '-$EID' then replace it with GlobalVariable.testExecutionId
        if (param.contains("$EID")) {
            
            // cast object to string
            String testExecutionId = GlobalVariable.testExecutionId.toString();

            // if GlobalVariable.testExecutionId is empty, set it to current timestamp
            if (testExecutionId == null || testExecutionId.isEmpty()) {
                Long timestamp = System.currentTimeMillis();
                // convert Long to string
                GlobalVariable.testExecutionId = Long.toString(timestamp); 
            }
            // replace param with GlobalVariable.testExecutionId
            return param.replace("$EID", GlobalVariable.testExecutionId.toString());
        }

        return param;
    }
}