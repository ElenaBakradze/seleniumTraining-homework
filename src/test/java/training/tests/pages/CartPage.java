package training.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

// Страница корзины
public class CartPage extends Page {

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Открытие страницы корзины - Нажимаем на ссылку Checkout »
     *
     */
    public void open() {
        clickOnElement(By.xpath("//*[@id='cart']//a[.='Checkout »']"));
    }

    // Список товаров в корзине
    @FindBy(css = "li.item")
    public List<WebElement> products;

    /**
     * Название товара в корзине
     *
     * @param product
     *          товар
     *
     */
    public String getProductName(WebElement product) {
        return product.findElement(By.tagName("strong")).getText();
    }

    /**
     * Выбор первого элемента в "ленте" с предпросмотром удаляемых товаров
     *
     */
    public void clickOnFirstProductInCart() {
        clickOnElement(By.xpath("//li[@class='shortcut'][1]//img"));
    }

    /**
     * Признак присутствия название товара в таблице
     *
     * @param name
     *          название товара
     *
     */
    public boolean productNameInTable(String name) {
        return isElementPresent(By.xpath("//*[@id='order_confirmation-wrapper']//td[.='" + name + "']"));
    }

    /**
     * Нажатие кнопки удаления товара из корзины
     *
     * @param product
     *          товар
     *
     */
    public void clickOnDeleteButton(WebElement product) {
        product.findElement(By.name("remove_cart_item")).click();
    }

    /**
     * Ждем, когда обновится корзина:
     * Ждем, когда обновится таблица(исчезнет старая)
     * и обновится форма с товаром (исчезнет старая)
     *
     * @param table
     *          таблица
     * @param product
     *          товар
     *
     */
    public void waitCartRefresh(WebElement table, WebElement product) {
        // Ждем, когда обновится таблица(исчезнет старая)
        waitElementIsDisappear(table);
        // Ждем, когда обновится форма с товаром (исчезнет старая)
        waitElementIsDisappear(product);
    }

    /**
     * Ждем, когда появится сообщение об удалении всех товаров
     *
     */
    public void waitDeleteAllProducts() {
        waitDisplayedElement(By.xpath("//em[.='There are no items in your cart.']"));
    }

    /**
     * Таблица
     *
     */
    public WebElement getTable() {
        waitDisplayedElement(By.id("order_confirmation-wrapper"));
        return driver.findElement(By.id("order_confirmation-wrapper"));
    }

    /**
     * Товар
     *
     */
    public WebElement getProduct() {
        waitDisplayedElement(By.xpath("//li[@class='item'][1]"));
        return driver.findElement(By.xpath("//li[@class='item'][1]"));
    }

}
