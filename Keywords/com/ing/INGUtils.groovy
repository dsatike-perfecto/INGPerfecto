package com.ing

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.remote.RemoteWebDriver

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
import com.kms.katalon.keyword.perfecto.PerfectoDriverManager
import com.kms.katalon.keyword.perfecto.PerfectoKeywords

import internal.GlobalVariable

public class INGUtils {
	
	public static String getPlatformName() {
		return ((RemoteWebDriver)PerfectoDriverManager.getDriver()).getCapabilities().getCapability("platformName").toString().toLowerCase();
	}
	public static TestObject getTestObject(String loc)
	{
		String finalLoc = "Object Repository"+File.separator+getPlatformName()+File.separator+loc
		return findTestObject(finalLoc);
	}	
	public static void setupAccount(String pin) {
		PerfectoKeywords.stepStart("Change Env")
		Mobile.waitForElementPresent(getTestObject("loginpage/login_env_btn"), 10);
		if(!Mobile.getText(getTestObject("loginpage/login_env_btn"),10).equals("32T")) {
			Mobile.tap(getTestObject("loginpage/login_env_btn"),10);
			Mobile.scrollToText("32T")
			Mobile.tap(getTestObject("loginpage/login_env_option"),10);
			PerfectoKeywords.reportiumAssert("Verify Env changed", Mobile.getText(getTestObject("loginpage/login_env_btn"),10).equals("32T"))
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
	
	public static void EnterPin(String pin)
	{
		char[] arr = pin.toCharArray();
		for(int i=0; i<arr.length; i++)
		{
			Mobile.tap(getTestObject("loginpage/login_pin_"+arr[i]),10)
		}
	}
}
