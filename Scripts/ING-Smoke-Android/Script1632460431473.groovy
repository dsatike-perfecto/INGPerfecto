import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.ing.INGUtils as INGUtils
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.keyword.perfecto.PerfectoDriverManager as PerfectoDriverManager
import com.kms.katalon.keyword.perfecto.PerfectoKeywords as PerfectoKeywords
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import static com.ing.INGUtils.*

PerfectoKeywords.startExistingApplication(GlobalVariable.appId)

//if (getPlatformName().equalsIgnoreCase('ios')) {
//    if (Mobile.waitForElementPresent(getTestObject('loginpage/login_devSDK_txt'), 10)) {
//        Mobile.tap(getTestObject('loginpage/login_devSDK_OK'), 10)
//    }
//}

if (!(Mobile.waitForElementPresent(getTestObject('loginpage/login_register_title'), 10))) {
	setupAccount("12312");
} else {
    PerfectoKeywords.stepStart('Perform Login')

    INGUtils.EnterPin("12312")
}

if (Mobile.waitForElementPresent(getTestObject('homepage/home_close_btn'), 10)) {
    Mobile.tap(getTestObject('homepage/home_close_btn'), 10)
}

if (Mobile.waitForElementPresent(getTestObject('loginpage/login_skipit_btn'), 10)) {
    Mobile.tap(getTestObject('loginpage/login_skipit_btn'), 10)
}

PerfectoKeywords.stepStart('Verify Home screen')

boolean hometitle = Mobile.waitForElementPresent(getTestObject('homepage/home_maincontent_title'), 40)

PerfectoKeywords.reportiumAssert('Verify Home Screen', hometitle)

PerfectoKeywords.stepStart('Transfer Funds')

Mobile.tap(getTestObject('homepage/home_firstcard_view'), 10)

Mobile.tap(getTestObject('salespage/sales_transfer_btn'), 10)

Mobile.waitForElementPresent(getTestObject('transferpage/transfer_template_btn'), 10)

Mobile.tap(getTestObject('transferpage/transfer_template_btn'), 10)

Mobile.waitForElementPresent(getTestObject('transferpage/transfer_firsttemplate_view'), 10)

Mobile.tap(getTestObject('transferpage/transfer_firsttemplate_view'), 10)

Mobile.waitForElementPresent(getTestObject('transferpage/transfer_confirm_btn'), 10)

Mobile.tap(getTestObject('transferpage/transfer_confirm_btn'), 10)

Mobile.waitForElementPresent(getTestObject('amountpage/amount_title_txt'), 10)

Mobile.sendKeys(getTestObject('amountpage/amount_amount_input'), '1')

Mobile.tap(getTestObject('amountpage/amount_further_btn'), 10)

Mobile.waitForElementPresent(getTestObject('transferpage/transfer_purpose_input'), 10)

Mobile.sendKeys(getTestObject('transferpage/transfer_purpose_input'), 'NA')

Mobile.sendKeys(getTestObject('transferpage/transfer_reference_input'), 'NA')

Mobile.tap(getTestObject('amountpage/amount_further_btn'), 10)

Mobile.waitForElementPresent(getTestObject('transferpage/transfer_ataglance_txt'), 10)

Mobile.tap(getTestObject('amountpage/amount_further_btn'), 10)

Mobile.waitForElementPresent(getTestObject('loginpage/login_pin_1'), 20)

INGUtils.EnterPin("12312")

PerfectoKeywords.stepStart('Verify transfer success')

PerfectoKeywords.reportiumAssert('Verify transfer success image.', Mobile.waitForElementPresent(getTestObject('transferpage/transfer_success_img'), 
        10))

PerfectoKeywords.reportiumAssert('Verify transfer success text.', Mobile.waitForElementPresent(getTestObject('transferpage/transfer_success_txt'), 
        10))

PerfectoKeywords.stepStart('Navigate to sales screen')

Mobile.tap(getTestObject('transferpage/transfer_tosales_btn'), 10)

PerfectoKeywords.stepStart('Verify sales screen')

if (Mobile.waitForElementPresent(getTestObject('salespage/sales_transfer_btn'), 10)) {
    PerfectoKeywords.reportiumAssert('Verify sales page .', Mobile.waitForElementPresent(getTestObject('salespage/sales_transfer_btn'), 
            10))

    PerfectoKeywords.stepStart('Navigate to home screen')

    Mobile.tap(getTestObject('salespage/sales_back_btn'), 10)
}

PerfectoKeywords.stepStart('Verify Home screen')

PerfectoKeywords.reportiumAssert('Verify Home Screen', Mobile.waitForElementPresent(getTestObject('homepage/home_maincontent_title'), 
        40))


