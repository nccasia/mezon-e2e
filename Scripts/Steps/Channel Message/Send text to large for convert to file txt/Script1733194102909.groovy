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
import org.openqa.selenium.WebElement
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import java.awt.Toolkit; 
import java.awt.datatransfer.StringSelection;

WebUI.callTestCase(findTestCase('Steps/Channel Message/Select channel'), [:], FailureHandling.STOP_ON_FAILURE)

String largeMessage = '1 - Khi vào công ty nhân sự sẽ ký cam kết bảo mật trước khi làm việc, nhân viên  cần tuân theo các điều khoản trong cam kết để thực hiện đúng. Email công ty cấp cho mỗi cá nhân là bảo mật. Không được sử dụng email  của công ty vào các mục đích cá nhân. Mỗi nhân viên có trách nhiệm bảo mật mật  mã, nội dung của email cá nhân không được để cho người khác biết. Trường hợp  do sơ sót tiết lộ thông tin sẽ chịu trách nhiệm trước BGĐ. Mỗi cá nhân sẽ được phân quyền để tiếp cận thông tin nội bộ phù hợp vị trí  của mình. Không được tìm cách xâm nhập, tìm hiểu thông tin của công ty không  liên quan đến công việc, lĩnh vực của mình. Nếu vi phạm sẽ chịu trách nhiệm  trước BGĐ1 - Khi vào công ty nhân sự sẽ ký cam kết bảo mật trước khi làm việc, nhân viên  cần tuân theo các điều khoản trong cam kết để thực hiện đúng. Email công ty cấp cho mỗi cá nhân là bảo mật. Không được sử dụng email  của công ty vào các mục đích cá nhân. Mỗi nhân viên có trách nhiệm bảo mật mật  mã, nội dung của email cá nhân không được để cho người khác biết. Trường hợp  do sơ sót tiết lộ thông tin sẽ chịu trách nhiệm trước BGĐ. Mỗi cá nhân sẽ được phân quyền để tiếp cận thông tin nội bộ phù hợp vị trí  của mình. Không được tìm cách xâm nhập, tìm hiểu thông tin của công ty không  liên quan đến công việc, lĩnh vực của mình. Nếu vi phạm sẽ chịu trách nhiệm  trước BGĐ1 - Khi vào công ty nhân sự sẽ ký cam kết bảo mật trước khi làm việc, nhân viên  cần tuân theo các điều khoản trong cam kết để thực hiện đúng. Email công ty cấp cho mỗi cá nhân là bảo mật. Không được sử dụng email  của công ty vào các mục đích cá nhân. Mỗi nhân viên có trách nhiệm bảo mật mật  mã, nội dung của email cá nhân không được để cho người khác biết. Trường hợp  do sơ sót tiết lộ thông tin sẽ chịu trách nhiệm trước BGĐ. Mỗi cá nhân sẽ được phân quyền để tiếp cận thông tin nội bộ phù hợp vị trí  của mình. Không được tìm cách xâm nhập, tìm hiểu thông tin của công ty không  liên quan đến công việc, lĩnh vực của mình. Nếu vi phạm sẽ chịu trách nhiệm  trước BGĐ1 - Khi vào công ty nhân sự sẽ ký cam kết bảo mật trước khi làm việc, nhân viên  cần tuân theo các điều khoản trong cam kết để thực hiện đúng. Email công ty cấp cho mỗi cá nhân là bảo mật. Không được sử dụng email  của công ty vào các mục đích cá nhân. Mỗi nhân viên có trách nhiệm bảo mật mật  mã, nội dung của email cá nhân không được để cho người khác biết. Trường hợp  do sơ sót tiết lộ thông tin sẽ chịu trách nhiệm trước BGĐ. Mỗi cá nhân sẽ được phân quyền để tiếp cận thông tin nội bộ phù hợp vị trí  của mình. Không được tìm cách xâm nhập, tìm hiểu thông tin của công ty không  liên quan đến công việc, lĩnh vực của mình. Nếu vi phạm sẽ chịu trách nhiệm  trước BGĐ1 - Khi vào công ty nhân sự sẽ ký cam kết bảo mật trước khi làm việc, nhân viên  cần tuân theo các điều khoản trong cam kết để thực hiện đúng. Email công ty cấp cho mỗi cá nhân là bảo mật. Không được sử dụng email  của công ty vào các mục đích cá nhân. Mỗi nhân viên có trách nhiệm bảo mật mật  mã, nội dung của email cá nhân không được để cho người khác biết. Trường hợp  do sơ sót tiết lộ thông tin sẽ chịu trách nhiệm trước BGĐ. Mỗi cá nhân sẽ được phân quyền để tiếp cận thông tin nội bộ phù hợp vị trí  của mình. Không được tìm cách xâm nhập, tìm hiểu thông tin của công ty không  liên quan đến công việc, lĩnh vực của mình. Nếu vi phạm sẽ chịu trách nhiệm  trước BGĐ1 - Khi vào công ty nhân sự sẽ ký cam kết bảo mật trước khi làm việc, nhân viên  cần tuân theo các điều khoản trong cam kết để thực hiện đúng. Email công ty cấp cho mỗi cá nhân là bảo mật. Không được sử dụng email  của công ty vào các mục đích cá nhân. Mỗi nhân viên có trách nhiệm bảo mật mật  mã, nội dung của email cá nhân không được để cho người khác biết. Trường hợp  do sơ sót tiết lộ thông tin sẽ chịu trách nhiệm trước BGĐ. Mỗi cá nhân sẽ được phân quyền để tiếp cận thông tin nội bộ phù hợp vị trí  của mình. Không được tìm cách xâm nhập, tìm hiểu thông tin của công ty không  liên quan đến công việc, lĩnh vực của mình. Nếu vi phạm sẽ chịu trách nhiệm  trước BGĐ1 - Khi vào công ty nhân sự sẽ ký cam kết bảo mật trước khi làm việc, nhân viên  cần tuân theo các điều khoản trong cam kết để thực hiện đúng. Email công ty cấp cho mỗi cá nhân là bảo mật. Không được sử dụng email  của công ty vào các mục đích cá nhân. Mỗi nhân viên có trách nhiệm bảo mật mật  mã, nội dung của email cá nhân không được để cho người khác biết. Trường hợp  do sơ sót tiết lộ thông tin sẽ chịu trách nhiệm trước BGĐ. Mỗi cá nhân sẽ được phân quyền để tiếp cận thông tin nội bộ phù hợp vị trí  của mình. Không được tìm cách xâm nhập, tìm hiểu thông tin của công ty không  liên quan đến công việc, lĩnh vực của mình. Nếu vi phạm sẽ chịu trách nhiệm  trước BGĐ1 - Khi vào công ty nhân sự sẽ ký cam kết bảo mật trước khi làm việc, nhân viên  cần tuân theo các điều khoản trong cam kết để thực hiện đúng. Email công ty cấp cho mỗi cá nhân là bảo mật. Không được sử dụng email  của công ty vào các mục đích cá nhân. Mỗi nhân viên có trách nhiệm bảo mật mật  mã, nội dung của email cá nhân không được để cho người khác biết. Trường hợp  do sơ sót tiết lộ thông tin sẽ chịu trách nhiệm trước BGĐ. Mỗi cá nhân sẽ được phân quyền để tiếp cận thông tin nội bộ phù hợp vị trí  của mình. Không được tìm cách xâm nhập, tìm hiểu thông tin của công ty không  liên quan đến công việc, lĩnh vực của mình. Nếu vi phạm sẽ chịu trách nhiệm  trước BGĐ1 - Khi vào công ty nhân sự sẽ ký cam kết bảo mật trước khi làm việc, nhân viên  cần tuân theo các điều khoản trong cam kết để thực hiện đúng. Email công ty cấp cho mỗi cá nhân là bảo mật. Không được sử dụng email  của công ty vào các mục đích cá nhân. Mỗi nhân viên có trách nhiệm bảo mật mật  mã, nội dung của email cá nhân không được để cho người khác biết. Trường hợp  do sơ sót tiết lộ thông tin sẽ chịu trách nhiệm trước BGĐ. Mỗi cá nhân sẽ được phân quyền để tiếp cận thông tin nội bộ phù hợp vị trí  của mình. Không được tìm cách xâm nhập, tìm hiểu thông tin của công ty không  liên quan đến công việc, lĩnh vực của mình. Nếu vi phạm sẽ chịu trách nhiệm  trước BGĐ1 - Khi vào công ty nhân sự sẽ ký cam kết bảo mật trước khi làm việc, nhân viên  cần tuân theo các điều khoản trong cam kết để thực hiện đúng. Email công ty cấp cho mỗi cá nhân là bảo mật. Không được sử dụng email  của công ty vào các mục đích cá nhân. Mỗi nhân viên có trách nhiệm bảo mật mật  mã, nội dung của email cá nhân không được để cho người khác biết. Trường hợp  do sơ sót tiết lộ thông tin sẽ chịu trách nhiệm trước BGĐ. Mỗi cá nhân sẽ được phân quyền để tiếp cận thông tin nội bộ phù hợp vị trí  của mình. Không được tìm cách xâm nhập, tìm hiểu thông tin của công ty không  liên quan đến công việc, lĩnh vực của mình. Nếu vi phạm sẽ chịu trách nhiệm  trước BGĐ1 - Khi vào công ty nhân sự sẽ ký cam kết bảo mật trước khi làm việc, nhân viên  cần tuân theo các điều khoản trong cam kết để thực hiện đúng. Email công ty cấp cho mỗi cá nhân là bảo mật. Không được sử dụng email  của công ty vào các mục đích cá nhân. Mỗi nhân viên có trách nhiệm bảo mật mật  mã, nội dung của email cá nhân không được để cho người khác biết. Trường hợp  do sơ sót tiết lộ thông tin sẽ chịu trách nhiệm trước BGĐ. Mỗi cá nhân sẽ được phân quyền để tiếp cận thông tin nội bộ phù hợp vị trí  của mình. Không được tìm cách xâm nhập, tìm hiểu thông tin của công ty không  liên quan đến công việc, lĩnh vực của mình. Nếu vi phạm sẽ chịu trách nhiệm  trước BGĐ'

StringSelection stringSelection = new StringSelection(largeMessage);

Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

WebUI.sendKeys(findTestObject('Channel Message/Send text to large for convert to file txt/textarea_Clan T_general channel'),
    Keys.chord(Keys.CONTROL, 'v'))

WebUI.waitForElementPresent(findTestObject('Channel Message/Send text to large for convert to file txt/p_file name'), 10)

String fileName = WebUI.getText(findTestObject('Channel Message/Send text to large for convert to file txt/p_file name'))

WebUI.sendKeys(findTestObject('Channel Message/Send text to large for convert to file txt/textarea_Clan T_general channel'), 
    Keys.chord(Keys.ENTER))

Boolean check = fileName.endsWith('.txt')

WebUI.delay(3)

WebElement p_fileName = WebUI.findWebElement(findTestObject('Channel Message/Send text to large for convert to file txt/div_latest message'))

String sentFileName = p_fileName.getText() 

if (sentFileName == fileName && check) {
    KeywordUtil.markPassed('Passed')
} else {
    KeywordUtil.markFailed('Failed')
}

