package main.kotlin.test

import main.kotlin.base.BaseTest
import main.kotlin.page.TvReviewPageObjects
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.testng.Assert.assertEquals
import org.testng.Assert.assertTrue
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test

class TvReviews : BaseTest() {

    private lateinit var tvReviewPageObjects: TvReviewPageObjects

    @BeforeTest
    override fun setUp() {
        super.setUp()
        tvReviewPageObjects = TvReviewPageObjects(driver)
        tvReviewPageObjects.openTvReviews()
    }

    @Test
    fun checkTabLinks() {
        val tvReviewTab: WebElement = driver.findElement(By.ByCssSelector("[data-test-element='tab']"))
        val tvTabLinks: List<WebElement> = tvReviewTab.findElements(By.tagName("a"))

        assertEquals(tvTabLinks.size, 4)
        assertTrue(tvReviewPageObjects.allTvUrl == tvTabLinks[0].getAttribute("href"))
        assertTrue(tvReviewPageObjects.bestBuyTvUrl == tvTabLinks[1].getAttribute("href"))
        assertTrue(tvReviewPageObjects.dontBuyTvUrl == tvTabLinks[2].getAttribute("href"))
        assertTrue(tvReviewPageObjects.tvGuidesUrl == tvTabLinks[3].getAttribute("href"))
    }
}