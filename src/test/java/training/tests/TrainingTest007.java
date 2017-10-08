package training.tests;

import org.openqa.selenium.By;

import org.testng.annotations.Test;

// Задание 11. Сценарий регистрации пользователя
public class TrainingTest007 extends TestBase{

    // адрес кнопки-ссылки Logout
    private final String btnLogout = "//*[@id='box-account']//a[.='Logout']";

    @Test(description = "Задание 11. Сценарий регистрации пользователя")
    public void createAccount() {
        // 1) регистрация новой учётной записи
        // Открываем главную страницу в браузере
        getDriver().navigate().to("http://localhost/litecart/");
        // Ждем, когда появится лого на странице
        waitDisplayedElement(By.id("logotype-wrapper"));
        // Открываем страницу регистрации пользователя
        clickOnElement(By.xpath("//*[@name='login_form']//a"));
        // Ждем пока появится страница регистрации
        waitDisplayedElement(By.id("create-account"));
        // Данные аккаунта пользователя
        UserAccount account = new UserAccount();
        // Заполняем поле Tax ID
        enterText(By.name("tax_id"), account.getTaxId());
        // Заполняем поле Company
        enterText(By.name("company"),  account.getCompany());
        // Заполняем поле First Name
        enterText(By.name("firstname"), account.getFirstname());
        // Заполняем поле Last Name
        enterText(By.name("lastname"), account.getLastname());
        // Заполняем поле Address 1
        enterText(By.name("address1"), account.getAddress1());
        // Заполняем поле Address 2
        enterText(By.name("address2"), account.getAddress2());
        // Заполняем поле Postcode
        enterText(By.name("postcode"), account.getPostcode());
        // Заполняем поле City
        enterText(By.name("city"), account.getCity());
        // Заполняем поле Country - United States
        selectElement(By.cssSelector("select[name=country_code]"),  account.getCountry());
        // Заполняем поле Zone/State/Province - выбираем случайный
        selectElement(By.cssSelector("select[name=zone_code]"), null);
        // Заполняем поле Email
        enterText(By.name("email"), account.getEmail());
        // Заполняем поле Phone
        enterText(By.name("phone"), account.getPhone());
        // Устанавливаем или не устанавливаем Subscribe случайным образом
        if(falseOrTrue()) {
            // выделяем
            checkElementCheckbox(getDriver().findElement(By.name("newsletter")));
        } else {
            // или снимаем выделение
            uncheckElementCheckbox(getDriver().findElement(By.name("newsletter")));
        }
        // Заполняем поле Desired Password
        enterText(By.name("password"), account.getPassword());
        // Заполняем поле Confirm Password
        enterText(By.name("confirmed_password"), account.getPassword());
        // Нажимаем кнопку Create Account
        clickOnElement(By.name("create_account"));
        // Ждем появления кнопки-ссылки Logout
        waitDisplayedElement(By.xpath(btnLogout));

        // 2) выход (logout)
        logout();

        // 3) повторный вход в только что созданную учётную запись
        // Заполняем поле Email Address
        enterText(By.name("email"), account.getEmail());
        // Заполняем поле Password
        enterText(By.name("password"), account.getPassword());
        // Нажимаем кнопку Login
        clickOnElement(By.name("login"));
        // Ждем появления кнопки-ссылки Logout
        waitDisplayedElement(By.xpath(btnLogout));

        // 4) и ещё раз выход
        logout();
    }

    /**
     * Выход
     *
     */
    private void logout() {
        // Нажимаем на кнопку-ссылку Logout
        clickOnElement(By.xpath(btnLogout));
        // Ждем появления кнопки Login
        waitDisplayedElement(By.name("login"));
    }

}
