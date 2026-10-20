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

TestObject makeObj(String xpath) {
	TestObject to = new TestObject()
	to.addProperty("xpath", ConditionType.EQUALS, xpath)
	return to
}

WebUI.openBrowser('')
WebUI.navigateToUrl('https://petstore.octoperf.com/actions/Catalog.action')
WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/JPetStore/lnk_SignIn'))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/JPetStore/txt_Username'), 'Tikatikiww')
WebUI.setText(findTestObject('Object Repository/JPetStore/txt_Password'), 'Tikatikiww2910')
WebUI.click(findTestObject('Object Repository/JPetStore/btn_Login'))
WebUI.delay(2)

// Klik kategori Cats menggunakan alternatif XPath gambar / sidebar kucing
WebUI.click(makeObj("//img[@src='../images/cats_icon.gif'] | //div[@id='QuickLinks']//a[contains(@href, 'CATS')]"))
WebUI.delay(1)

// Pilih produk kucing pertama
WebUI.click(makeObj("(//a[contains(@href, 'viewProduct')])[1]"))
WebUI.delay(1)

// Add to cart item kucing
WebUI.click(makeObj("(//a[contains(@href, 'addItemToCart')])[1]"))
WebUI.delay(1)

// Ubah Quantity jadi 2
WebUI.clearText(makeObj("//input[@name]"))
WebUI.setText(makeObj("//input[@name]"), '2')
WebUI.delay(1)

// Proses Checkout
WebUI.click(makeObj("//a[contains(text(),'Proceed to Checkout')]"))
WebUI.delay(1)
WebUI.click(makeObj("//input[@name='newOrder']"))
WebUI.delay(1)
WebUI.click(makeObj("//a[contains(text(),'Confirm')]"))
WebUI.delay(2)

WebUI.verifyElementPresent(makeObj("//li[contains(text(),'Thank you') or contains(text(),'Order')]"), 5)
WebUI.closeBrowser()