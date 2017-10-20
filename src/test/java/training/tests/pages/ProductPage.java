package training.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

// Страница товара
public class ProductPage extends Page {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Выбор размера товара, если поле присутствует
     *
     * @param size
     *          размер товара
     */
    public ProductPage selectSize(String size) {
        if(isElementPresent(By.name("options[Size]")))
        new Select(driver.findElement(By.name("options[Size]"))).selectByValue(size);
        return this;
    }

    /**
     * Нажатие кнопки добавления в корзину и проверка счетчика корзины
     *
     * @param i
     *          количество добавленных товаров
     */
    public void clickButtonAddToCart(int i) {
            // Нажимаем на кнопку Add To Cart
            clickOnElement(By.name("add_cart_product"));
            // Ждем пока счётчик товаров в корзине обновится
            waitTextInElement(By.cssSelector("#cart span.quantity"), String.valueOf(i));
    }

}
