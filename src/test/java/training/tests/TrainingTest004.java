package training.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

// Проверка наличия стикеров у товаров
public class TrainingTest004 extends TestBase{

    @Test(description = "Проверка наличия стикеров у товаров")
    public void checkStickers() {
        // Открываем главную страницу в браузере
        getDriver().navigate().to("http://localhost/litecart/");
        // Ждем, когда появится лого на странице
        waitDisplayedElement(By.id("logotype-wrapper"));
        // В цикле по всем товарам
        for (WebElement product : getDriver().findElements(By.cssSelector(".product"))) {
            // Проверяем наличие только одного стикера у товара
            Assert.assertTrue(product.findElements(By.cssSelector(".sticker")).size() == 1);

        }
    }


}
