package training.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

// Задание 17. Проверка отсутствия сообщений в логе браузера
public class TrainingTest011 extends TestBase{

    @Test(description = "Задание 17. Проверка отсутствия сообщений в логе браузера")
    public void checkLog() {
        // 1) Логин в панель администрирования учебного приложения
        loginInStore(loginPass, loginPass);
        // 2) Перейдем на сраницу, которая содержит товары
        getDriver().navigate().to("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
        // Ждем, когда появится таблица с товарами
        waitDisplayedElement(By.cssSelector(".dataTable"));
        // Список товаров
        List<WebElement> menu = getDriver().findElements(By.xpath("//tr[@class='row']//img/following-sibling::a"));
        // 3) Открываем страницы товаров и проверяем логи браузера
        for (int i = 1; i <= menu.size(); i++) {
            // кликаем на товар - открываем страницу этого товара
            clickOnElement(By.xpath("(//tr[@class='row']//img/following-sibling::a)[" + i + "]"));
            /*
             * Проверяем отсутствие сообщений в логе браузера при открытии страницы товара
             * Внимание! Включены все уровни логгирования в консоли браузера (см. start() в TestBase)
             */
            Assert.assertTrue(getDriver().manage().logs().get("browser").getAll().isEmpty());
            // Перейдем обратно на сраницу, которая содержит товары
            getDriver().navigate().to("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
            // Ждем, когда появится таблица с товарами
            waitDisplayedElement(By.cssSelector(".dataTable"));
        }
    }

}
