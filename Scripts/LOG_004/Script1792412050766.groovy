import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

TestObject makeObjLOG4(String xpath) {
	TestObject to = new TestObject()
	to.addProperty("xpath", ConditionType.EQUALS, xpath)
	return to
}

WebUI.openBrowser('')
WebUI.navigateToUrl('https://petstore.octoperf.com/actions/Catalog.action')
WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/JPetStore/lnk_SignIn'))
WebUI.delay(2)

WebUI.setText(findTestObject('Object Repository/JPetStore/txt_Username'), 'Tikatikiww')
WebUI.click(findTestObject('Object Repository/JPetStore/btn_Login'))
WebUI.delay(2)

// Menyesuaikan ekspektasi teks error dengan sistem JPetStore
WebUI.verifyElementText(makeObjLOG4("//ul[@class='messages']"), 'Invalid username or password. Signon failed.')
WebUI.closeBrowser()