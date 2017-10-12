package training.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

// Проверка открытия ссылки в новом окне
public class TrainingTest010 extends TestBase{

    @Test(description = "Проверка открытия ссылки в новом окне")
    public void clickOnMenu() {
        // Логин в панель администрирования учебного приложения
        loginInStore(loginPass, loginPass);
        // Перейдем на сраницу стран
        getDriver().navigate().to("http://localhost/litecart/admin/?app=countries&doc=countries");
        // Нажимаем на кнопку Add New Country
        clickOnElement(By.xpath("//a[contains(text(),'Add New Country')]"));
        // Исходное окно с добавлением страны
        String startWindow = getDriver().getWindowHandle();
        // Открываем каждую ссылку на внешнюю страницу
        for (WebElement link : getDriver().findElements(By.xpath("//form//a[@target='_blank']"))) {
            // Уже открытые окна
            Set<String> openWindows = getDriver().getWindowHandles();
            // Кликаем на ссылку
            link.click();
            // Ждем появление нового окна и запоминаем его идентификатор
            String newWindow = waitAnyWindowOtherThan(openWindows);
            // Переключаемся в открытое окно
            getDriver().switchTo().window(newWindow);
            // Закрываем окно
            getDriver().close();
            // Переключаемся в исходное окно
            getDriver().switchTo().window(startWindow);
        }
    }

}
