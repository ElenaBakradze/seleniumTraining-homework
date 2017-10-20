package training.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public Page(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    /**
     * Ожидание отображения элемента
     *
     * @param locator
     *          адрес элемента
     */
    public void waitDisplayedElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
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
        WebElement element = driver.findElement(locator);
        // кликаем по элементу
        element.click();
    }

    /**
     * Проверка присутствия элемента на странице
     *
     * @param locator
     *          адрес элемента
     */
    boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    /**
     * Ожидание когда текст элемента примет нужное значение
     *
     * @param locator
     *          адрес элемента
     *
     * @param locator
     *          текст элемента
     */
    public void waitTextInElement(By locator, String text) {
        wait.until((ExpectedConditions.textToBePresentInElementLocated(locator, text)));
    }

    /**
     * Ожидание когда элемент исчезнет
     *
     * @param element
     *          элемент
     */
    public void waitElementIsDisappear(WebElement element) {
        wait.until(ExpectedConditions.stalenessOf(element));
    }

}
