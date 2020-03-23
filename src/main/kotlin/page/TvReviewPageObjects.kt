package main.kotlin.page

import org.openqa.selenium.WebDriver

class TvReviewPageObjects(private val driver: WebDriver) {

    fun openTvReviews() {
        driver.get("https://www.which.co.uk/reviews/televisions")
    }

    val allTvUrl = "https://www.which.co.uk/reviews/televisions"
    val bestBuyTvUrl = "https://www.which.co.uk/reviews/televisions/article/recommendations/which-best-buy-televisions"
    val dontBuyTvUrl = "https://www.which.co.uk/reviews/televisions/article/recommendations/which-dont-buy-televisions"
    val tvGuidesUrl = "https://www.which.co.uk/reviews/televisions/article/guides"
}