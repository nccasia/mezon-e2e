import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext
import com.kms.katalon.core.configuration.RunConfiguration

import java.io.File
import java.nio.file.Files
import java.nio.file.StandardCopyOption
import java.util.ArrayList
import java.util.List

class TestIdTestListener {
    /**
     * Executes before every test suite starts.
     * @param testSuiteContext: related information of the executed test suite.
     */
    @BeforeTestSuite
    def handleBeforeTestSuite(TestSuiteContext testSuiteContext) {
        Long timestamp = System.currentTimeMillis();
        
        // convert Long to string
        GlobalVariable.testExecutionId = Long.toString(timestamp);

        // process the feature files
        this.handleFeatureFilesBeforeTestSuite();
    }

    /**
     * Executes after every test suite ends.
     * @param testSuiteContext: related information of the executed test suite.
     */
    @AfterTestSuite
    def handleAfterTestSuite(TestSuiteContext testSuiteContext) {
        // restore the feature files
        this.handleFeatureFilesAfterTestSuite();
    }

    /**
     * handle feature files before test suite
     */
    def handleFeatureFilesBeforeTestSuite() {
        String projectDir = RunConfiguration.getProjectDir();
        
        // list all feature files
        List<File> featureFiles = this.listAllFeatureFiles(new File(projectDir, "/Include/features"));

        // backup the feature files
        this.backupFeatureFiles(featureFiles);

        // process the feature files
        this.processFeatureFiles(featureFiles);
    }    

    /** 
     * handle feature files after test suite
     */
    def handleFeatureFilesAfterTestSuite() {
        String projectDir = RunConfiguration.getProjectDir();
        
        // list all feature files
        List<File> featureFiles = this.listAllFeatureFiles(new File(projectDir, "/Include/features"));

        // restore the feature files
        this.restoreFeatureFiles(featureFiles);
    }

    /**
     * List all .feature files in the project
     * @Param path: the path to the project
     * @Return List<File>: list of .feature files
     */
    def List<File> listAllFeatureFiles(File path) {
        List<File> featureFiles = new ArrayList<File>();
        File folder = path;
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile() && file.getName().endsWith(".feature")) {
                featureFiles.add(file);
            }
        }
        return featureFiles;
    }

    /**
     * backup the feature files
     * @Param files: list of file to the feature files
     */
    def backupFeatureFiles(List<File> files) {
        for (File file : files) {
            this.backupFeatureFile(file);
        }
    }

    /**
     * Backup a feature file
     * @Param file: the feature file
     */
    def backupFeatureFile(File file) {
        String backupPath = file.getAbsolutePath() + ".bak";
        this.copyFile(file, new File(backupPath));
    }

    /**
     * Copy a file
     * @Param source: the source file
     * @Param dest: the destination file path
     */
    def copyFile(File source, File dest) {
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    /**
     * Restore the feature files
     * @Param files: list of files to the feature files
     */
    def restoreFeatureFiles(List<File> files) {
        for (File file : files) {
            this.restoreFeatureFile(file)
        }
    }

    /**
     * Restore a feature file
     * @Param file: the feature file
     */
    def restoreFeatureFile(File file) {
        String backupPath = file.getAbsolutePath() + ".bak";
        this.copyFile(new File(backupPath), file);
        // remove the backup file
        File backupFile = new File(backupPath);
        backupFile.delete();
    }

    /**
     * Process feature files, loop through each line and process the line updating the file content
     * @Param files: list of files to the feature files
     */
    def processFeatureFiles(List<File> files) {
        for (File file : files) {
            List<String> newContent = this.processFeatureFile(file);
            
            // write the new content to the file
            this.writeLines(file, newContent);
        }
    }

    /**
     * Process a feature file, loop through each line and process the line and return the new content
     * @Param file: the feature file
     * @Return List<String>: the new content of the file
     */
    def processFeatureFile(File file) {
        List<String> lines = this.readLines(file);
        List<String> newContent = new ArrayList<String>();
        for (String line : lines) {
            newContent.add(this.processLine(line));
        }
        return newContent;
    }

    /**
     * Process a line, replace the $EID with the testExecutionId
     * @Param line: the line to process
     * @Return String: the new line
     */
    def processLine(String line) {
        String newLine = line.replace('$EID', GlobalVariable.testExecutionId);
        return newLine;
    }

    /**
     * Read all lines of a file
     * @Param file: the file to read
     * @Return List<String>: list of lines in the file
     */
    def List<String> readLines(File file) {
        return Files.readAllLines(file.toPath());
    }

    /**
     * Write lines to a file
     * @Param file: the file to write to
     * @Param lines: the lines to write
     */
    def writeLines(File file, List<String> lines) {
        Files.write(file.toPath(), lines);
    }
}
