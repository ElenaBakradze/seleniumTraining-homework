package training.tests;

import org.testng.annotations.Test;

import org.openqa.selenium.By;

// Логин в панель администрирования учебного приложения
public class TrainingTest002 extends TestBase{

    // линк страницы
    private final String link = "http://localhost/litecart/admin/";
    // имя кнопки Login
    private final String btnLoginName = "login";
    // имя поля для ввода логина
    private final String fieldLogin = "username";
    // имя поля для ввода пароля
    private final String fieldPass = "password";
    // логин и пароль
    private final String loginPass = "admin";

    @Test(description = "Логин в панель администрирования учебного приложения")
    public void loginInStoreAdmin() {
        // открываем страницу в браузере
        getDriver().navigate().to(link);
        // Ждем, пока отобразится поле ввода логина и вводим логин
        enterText(By.name(fieldLogin), loginPass);
        // Ждем, пока отобразится поле ввода пароля и вводим пароль
        enterText(By.name(fieldPass), loginPass);
        // Ждем, пока отобразится кнопка Login и нажимаем кнопку
        clickOnElement(By.name(btnLoginName));
        // Ждем, пока отобразится кнопка выхода (Logout)
        waitDisplayedElement(By.xpath("//a[@title='Logout']"));
    }

}
