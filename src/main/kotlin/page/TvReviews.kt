package main.kotlin.page

import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.WebDriverWait
import org.testng.Assert
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test


class TvReviews {

    private lateinit var driver: WebDriver
    private lateinit var homePage: HomePage

    @BeforeTest
    fun setUp() {
        driver = ChromeDriver()
        WebDriverWait(driver, 5).until { webDriver: WebDriver ->
            (webDriver as JavascriptExecutor).executeScript(
                "return document.readyState"
            ) == "complete"
        }
        homePage = HomePage(driver)
        homePage.openTvReviews()
    }

    @AfterTest
    fun tearDown() {
        driver.quit()
    }

    @Test
    fun checkTabLinks() {
        val tvReviewTab: WebElement = driver.findElement(By.ByCssSelector("[data-test-element='tab']"))
        val tabLinks: List<WebElement> = tvReviewTab.findElements(By.tagName("a"))
        Assert.assertEquals(tabLinks.size, 4)
        Assert.assertTrue("https://www.which.co.uk/reviews/televisions" == tabLinks[0].getAttribute("href"))
        Assert.assertTrue(
            "https://www.which.co.uk/reviews/televisions/article/recommendations/which-best-buy-televisions" == tabLinks[1].getAttribute(
                "href"
            )
        )
        Assert.assertTrue(
            "https://www.which.co.uk/reviews/televisions/article/recommendations/which-dont-buy-televisions" == tabLinks[2].getAttribute(
                "href"
            )
        )
        Assert.assertTrue("https://www.which.co.uk/reviews/televisions/article/guides" == tabLinks[3].getAttribute("href"))

    }
}