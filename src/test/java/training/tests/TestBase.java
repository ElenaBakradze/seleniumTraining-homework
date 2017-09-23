package training.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

    // драйвер
    private WebDriver driver;

    /**
     * Получить драйвер
     *
     * @return {@link WebDriver}
     */
    protected WebDriver getDriver() {
        return driver;
    }

    /**
     * Установить драйвер
     *
     * @param driver
     *          драйвер
     *
     * @return {@link TestBase} this
     */
    TestBase setDriver(WebDriver driver) {
        this.driver = driver;
        return this;
    }

    @BeforeClass
    public void start() {
        setDriver(new ChromeDriver());
    }

    @AfterClass
    public void stop() {
        getDriver().quit();
    }

    /**
     * Ожидание отображения элемента
     *
     * @param locator
     *          адрес элемента
     */
    public void waitDisplayedElement(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Ввод текста в поле
     *
     * @param locator
     *          адрес элемента
     * @param text
     *          вводимый текст
     */
    public void enterText(By locator, String text) {
        // ждем пока элемент отобразится
        waitDisplayedElement(locator);
        // получаем элемент
        WebElement element = getDriver().findElement(locator);
        // очищаем поле, если оно заполнено
        if (!element.getAttribute("value").equals(""))
            element.clear();
        // вводим текст
        element.sendKeys(text);
    }

    /**
     * Клик по элементу
     *
     * @param locator
     *          адрес элемента
     */
    public void clickOnElement(By locator) {
        // ждем пока элемент отобразится
        waitDisplayedElement(locator);
        // получаем элемент
        WebElement element = getDriver().findElement(locator);
        // кликаем по элементу
        element.click();
    }
}
