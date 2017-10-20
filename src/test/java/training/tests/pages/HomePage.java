package training.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Главная страница
public class HomePage extends Page {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Открытие главной страницы
     *
     */
    public HomePage open() {
        driver.get("http://localhost/litecart/");
        return this;
    }

    /**
     * Открытие страницы первого товара
     *
     */
    public void openFirstProduct() {
        clickOnElement(By.xpath("//*[@id='box-most-popular']//li[1]"));
        waitDisplayedElement(By.cssSelector("#box-product h1"));
    }

}
