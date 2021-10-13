package com.ing

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.By
import org.openqa.selenium.remote.RemoteWebDriver

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileAbstractKeyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.keyword.perfecto.PerfectoDriverManager
import com.kms.katalon.keyword.perfecto.PerfectoKeywords

import internal.GlobalVariable
import io.appium.java_client.AppiumDriver

public class INGUtils {

	public static String getPlatformName() {
		return ((RemoteWebDriver)PerfectoDriverManager.getDriver()).getCapabilities().getCapability("platformName").toString().toLowerCase();
	}
	
	public static TestObject getTestObject(String loc) {
		String finalLoc = "Object Repository"+File.separator+getPlatformName()+File.separator+loc
		return findTestObject(finalLoc);
	}
	
	public static void setupAccountAndroid(String pin) {
		PerfectoKeywords.stepStart("Change Env")
		Mobile.waitForElementPresent(getTestObject("loginpage/login_env_btn"), 10);
		if(!Mobile.getText(getTestObject("loginpage/login_env_btn"),10).equals(GlobalVariable.env)) {
			Mobile.tap(getTestObject("loginpage/login_env_btn"),10);
			Mobile.scrollToText(GlobalVariable.env)
			Mobile.tap(getTestObject("loginpage/login_env_option"),10);
			PerfectoKeywords.reportiumAssert("Verify Env changed", Mobile.getText(getTestObject("loginpage/login_env_btn"),10).equals(GlobalVariable.env))
		}
		PerfectoKeywords.stepStart("Perform Login")
		Mobile.tap(getTestObject("loginpage/login_imacustomer_btn"),20)
		Mobile.tap(getTestObject("loginpage/login_depotnumber_input"),10)
		Mobile.sendKeys(getTestObject("loginpage/login_depotnumber_input"),"5411106180")
		Mobile.sendKeys(getTestObject("loginpage/login_password_input"),"123456")
		Mobile.tap(getTestObject("loginpage/login_login_btn"),10)
		boolean successMsg = Mobile.waitForElementPresent(getTestObject("loginpage/login_loginsuccess_txt"), 40);
		PerfectoKeywords.reportiumAssert("Verify Env changed", successMsg)
		Mobile.tap(getTestObject("loginpage/login_tomobilepin_btn"),10)
		PerfectoKeywords.stepStart("Setup Pin")
		if(Mobile.waitForElementPresent(getTestObject("loginpage/login_swipe_img"),10)) {
			for(int i =0;i<4;i++) {
				INGUtils.swipe("90%,50%","10%,50%");
				Mobile.waitForElementPresent(getTestObject("loginpage/login_swipe_img"),10)
			}
		}
		Mobile.waitForElementPresent(getTestObject("loginpage/login_selectmobilepin_btn"),10)
		Mobile.tap(getTestObject("loginpage/login_selectmobilepin_btn"),10)

		INGUtils.EnterPin("12312")

		Mobile.waitForElementPresent(getTestObject("loginpage/login_confirmpin_txt"),10)

		if(getPlatformName().equalsIgnoreCase("ios")) {
			if(Mobile.waitForElementPresent(getTestObject("loginpage/login_devSDK_txt"),10)) {
				Mobile.tap(getTestObject("loginpage/login_devSDK_OK"),10);
			}
		}

		Mobile.waitForElementPresent(getTestObject("loginpage/login_pin_1"),10)
		INGUtils.EnterPin("12312")
	}
	
	public static void setupAccountiOS(String pin) {
		PerfectoKeywords.stepStart("Change Env")
		Mobile.waitForElementPresent(getTestObject("loginpage/login_menu_btn"), 10);
		Mobile.tap(getTestObject("loginpage/login_menu_btn"),10);
		Mobile.tap(getTestObject("loginpage/login_settings_btn"),10);
		Mobile.scrollToText("Testumgebungen")
		Mobile.tap(getTestObject("loginpage/login_testenv_txt"),10);
		Mobile.scrollToText(GlobalVariable.env)
		
		if(!Mobile.waitForElementPresent(getTestObject("loginpage/login_env32T_option"), 10)) {
			PerfectoDriverManager.getDriver().findElement(By.name(GlobalVariable.env)).click()
			PerfectoKeywords.reportiumAssert("Verify Env changed", Mobile.waitForElementPresent(getTestObject("loginpage/login_env32T_option"), 10))
			
		}
		Mobile.tap(getTestObject("loginpage/login_closeapp_btn"),10);
		((AppiumDriver)PerfectoDriverManager.getDriver()).activateApp(GlobalVariable.appId)
		if (Mobile.waitForElementPresent(getTestObject('loginpage/login_devSDK_txt'), 10)) {
			Mobile.tap(getTestObject('loginpage/login_devSDK_OK'), 10)
		}
		PerfectoKeywords.stepStart("Perform Login")
		Mobile.tap(getTestObject("loginpage/login_imacustomer_btn"),20)
		Mobile.tap(getTestObject("loginpage/login_gotit_btn"),20)
		Mobile.tap(getTestObject("loginpage/login_setupapp_btn"),20)
		Mobile.tap(getTestObject("loginpage/login_setupmobilepin_btn"),20)
		INGUtils.EnterPin("12312")
		INGUtils.EnterPin("12312")
		Mobile.tap(getTestObject("loginpage/login_next_btn"),20)
		Mobile.waitForElementPresent(getTestObject('loginpage/login_next_btn'), 10)
		Mobile.tap(getTestObject("loginpage/login_next_btn"),20)
		Mobile.waitForElementPresent(getTestObject('loginpage/login_next_btn'), 10)
		Mobile.tap(getTestObject("loginpage/login_next_btn"),20)
		
		Mobile.tap(getTestObject("loginpage/login_depotnumber_input"),10)
		Mobile.sendKeys(getTestObject("loginpage/login_depotnumber_input"),"5405350989")
		Mobile.sendKeys(getTestObject("loginpage/login_password_input"),"123456")
		Mobile.tap(getTestObject("loginpage/login_login_btn"),10)
		boolean successMsg = Mobile.waitForElementPresent(getTestObject("loginpage/login_loginsuccess_txt"), 40);
		PerfectoKeywords.reportiumAssert("Verify Login success", successMsg)
		
		if(getPlatformName().equalsIgnoreCase("ios")) {
			if(Mobile.waitForElementPresent(getTestObject("loginpage/login_devSDK_txt"),10)) {
				Mobile.tap(getTestObject("loginpage/login_devSDK_OK"),10);
			}
		}
	}
	
	public static void swipe(String start, String end) {
		Map<String, Object> params = new HashMap<>();
		params.put("start", start);
		params.put("end", end);
		params.put("duration", "2");
		Object res = getAppiumDriver().executeScript("mobile:touch:swipe", params);
	}

	public static void EnterPin(String pin) {
		char[] arr = pin.toCharArray();
		for(int i=0; i<arr.length; i++) {
			Mobile.tap(getTestObject("loginpage/login_pin_"+arr[i]),10)
		}
	}
	
	public static AppiumDriver getAppiumDriver() {
		return ((AppiumDriver)PerfectoDriverManager.getDriver());
	}
}
