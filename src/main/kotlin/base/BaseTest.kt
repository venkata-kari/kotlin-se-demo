package main.kotlin.base

import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.WebDriverWait
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest

open class BaseTest {
    lateinit var driver: WebDriver

    @BeforeTest
    open fun setUp() {
        driver = ChromeDriver()
        WebDriverWait(driver, 5).until { webDriver: WebDriver ->
            (webDriver as JavascriptExecutor).executeScript(
                "return document.readyState"
            ) == "complete"
        }
    }

    @AfterTest
    open fun tearDown() {
        driver.quit()
    }
}