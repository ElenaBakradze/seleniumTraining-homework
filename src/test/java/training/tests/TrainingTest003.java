package training.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

import java.util.List;

// Прохождение по всем разделам админки
public class TrainingTest003 extends TestBase{

    @Test(description = "Прохождение по всем разделам админки")
    public void clickOnMenu() {
        // Логин в панель администрирования учебного приложения
        loginInStore(loginPass, loginPass);
        // Cписок пунктов в меню
        List<WebElement> menu = getDriver().findElements(By.id("app-"));
        // Кликаем на пункты меню
        for (int i = 1; i <= menu.size(); i++) {
            // кликаем на пункт меню
            clickOnElement(By.xpath("//li[@id='app-'][" + i + "]"));
            // Проверяем наличие заголовка(то есть элемента с тегом h1)
            isElementPresent(By.cssSelector("td#content h1"));
            // Если есть подменю, то кликаем и по его пунктам
            if (isElementPresent(By.className("docs"))) {
                // Cписок пунктов в подменю
                List<WebElement> subMenu = getDriver().findElements(By.cssSelector("ul.docs li"));
                // Кликаем на пункты подменю
                for (int j = 1; j <= subMenu.size(); j++) {
                    // кликаем на пункт подменю
                    clickOnElement(By.xpath("//ul[@class='docs']/li[" + j + "]"));
                    // Проверяем наличие заголовка
                    isElementPresent(By.cssSelector("td#content h1"));
                }
            }
        }
    }

}
