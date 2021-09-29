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

//PerfectoKeywords.stepStart("Change Env")
//Mobile.waitForElementPresent(getTestObject"login_env_btn")), 10);
//if(!Mobile.getText(getTestObject"login_env_btn")),10).equals("32T")) {
//	Mobile.tap(getTestObject"login_env_btn")),10);
//	Mobile.scrollToText("32T")
//	Mobile.tap(getTestObject"login_env_option")),10);
//	PerfectoKeywords.reportiumAssert("Verify Env changed", Mobile.getText(getTestObject"login_env_btn")),10).equals("32T"))
//}
//PerfectoKeywords.stepStart("Perform Login")
//Mobile.tap(getTestObject"login_imacustomer_btn")),20)
//Mobile.tap(getTestObject"login_depotnumber_input")),10)
//Mobile.sendKeys(getTestObject"login_depotnumber_input")),"5411106180")
//Mobile.sendKeys(getTestObject"login_password_input")),"123456")
//Mobile.tap(getTestObject"login_login_btn")),10)
//boolean successMsg = Mobile.waitForElementPresent(getTestObject"login_loginsuccess_txt")), 40);
//PerfectoKeywords.reportiumAssert("Verify Env changed", successMsg)
//Mobile.tap(getTestObject"login_tomobilepin_btn")),10)
//PerfectoKeywords.stepStart("Setup Pin")
//if(Mobile.waitForElementPresent(getTestObject"login_swipe_img")),10)) {
//	for(int i =0;i<4;i++) {
//		INGUtils.swipe("90%,50%","10%,50%");
//		Mobile.waitForElementPresent(getTestObject"login_swipe_img")),10)
//	}
//}
//Mobile.waitForElementPresent(getTestObject"login_selectmobilepin_btn")),10)
//Mobile.tap(getTestObject"login_selectmobilepin_btn")),10)
//
//Mobile.tap(getTestObject"login_pin_1")),10);
//Mobile.tap(getTestObject"login_pin_2")),10);
//Mobile.tap(getTestObject"login_pin_3")),10);
//Mobile.tap(getTestObject"login_pin_1")),10);
//Mobile.tap(getTestObject"login_pin_2")),10);
//
//Mobile.waitForElementPresent(getTestObject"login_confirmpin_txt")),10)



//if(Mobile.waitForElementPresent(getTestObject("login_useitan_btn")),10)) {
//	Mobile.tap(getTestObject("login_useitan_btn")),10)
//}
//Mobile.waitForElementPresent(getTestObject("login_enteraitan_btn")),10)
//Mobile.tap(getTestObject"login_enteraitan_btn")),10)
////login_enteraitan_btn
//PerfectoKeywords.stepStart("Setup iTan")
//String itanText = Mobile.getText(getTestObject"login_enteritan_txt")),10)
//String num = itanText.split("Geben Sie bitte iTAN Nr. ")[1].split(" ")[0]
//if(num.toCharArray().length==2) {
//	num = "0000"+num
//}else if(num.toCharArray().length==3) {
//	num="000"+num
//}else {
//	num="00000"+num
//}
//for(int i = 0; i< num.size() ;i++) {
//	Mobile.tap(getTestObject"login_pin_"+num.charAt(i))),10);
//}
//Mobile.waitForElementPresent(getTestObject"login_enteritan2_txt")),10)
//itanText = Mobile.getText(getTestObject"login_enteritan2_txt")),10)
////Und jetzt bitte iTAN Nr. 27.
//
//num = itanText.split("Und jetzt bitte iTAN Nr. ")[1].replace(".","")
//if(num.toCharArray().length==2) {
//	num = "0000"+num
//}else if(num.toCharArray().length==3) {
//	num="000"+num
//}else {
//	num="00000"+num
//}
//for(int i = 0; i< num.size() ;i++) {
//	Mobile.tap(getTestObject"login_pin_"+num.charAt(i))),10);
//}
//Mobile.tap(getTestObject"login_tomaincontent_btn")),10)