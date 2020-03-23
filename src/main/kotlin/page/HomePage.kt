package main.kotlin.page

import org.openqa.selenium.WebDriver

class HomePage(private val driver: WebDriver) {

    fun openTvReviews() {
        driver.get("https://www.which.co.uk/reviews/televisions")
    }
}