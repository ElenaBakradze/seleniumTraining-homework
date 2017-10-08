package training.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

// Задание 13. Сценарий работы с корзиной
public class TrainingTest009 extends TestBase{

    @Test(description = "Задание 13. Сценарий работы с корзиной")
    public void workingWithCart() {
        // Добавим три товара в корзину
        for (int i = 1; i <= 3; i++) {
            // Открываем главную страницу в браузере
            getDriver().navigate().to("http://localhost/litecart/");
            // Переходим на страницу первого товара
            clickOnElement(By.xpath("//*[@id='box-most-popular']//li[1]"));
            waitDisplayedElement(By.cssSelector("#box-product h1"));
            // Если есть поле Size - выбираем в нем значение
            if(isElementPresent(By.name("options[Size]")))
                selectElement(By.name("options[Size]"),  "Small");
            // Нажимаем на кнопку Add To Cart
            clickOnElement(By.name("add_cart_product"));
            // Ждем пока счётчик товаров в корзине обновится
            waitTextInElement(By.cssSelector("#cart span.quantity"), String.valueOf(i));
        }

        // Открываем корзину - Нажимаем на ссылку Checkout »
        clickOnElement(By.xpath("//*[@id='cart']//a[.='Checkout »']"));
        // Товары в корзине, которые будем удалять
        List<WebElement> products = getDriver().findElements(By.cssSelector("li.item"));
        // По товарам в корзине
        for (int i = 1; i <= products.size(); i++){
            // Таблица с товарами
            WebElement table = getDriver().findElement(By.id("order_confirmation-wrapper"));
            // Если еще есть товары для удаления помимо текущего, то в "ленте" с предпросмотром удаляемых товаров выбираем первый
            if(products.size() - i >= 1)
                clickOnElement(By.xpath("//li[@class='shortcut'][1]//img"));
            // Форма товара для удаления
            WebElement product = getDriver().findElement(By.xpath("//li[@class='item'][1]"));
            // Название товара, который будем удалять
            String name = product.findElement(By.tagName("strong")).getText();
            // Проверяем, что название есть в таблице
            Assert.assertTrue(isElementPresent(By.xpath("//*[@id='order_confirmation-wrapper']//td[.='" + name + "']")));
            // Нажимаем кнопку Remove у товара
            product.findElement(By.name("remove_cart_item")).click();
            // Если удалили не последний товар, то
            if(products.size() - i > 0) {
                // Ждем, когда обновится таблица(исчезнет старая)
                waitElementIsDisappear(table);
                // Проверяем, что название исчезло из таблицы
                Assert.assertFalse(isElementPresent(By.xpath("//*[@id='order_confirmation-wrapper']//td[.='" + name + "']")));
                // Ждем, когда обновится форма с товаром(исчезнет старая)
                waitElementIsDisappear(product);
            } else {
                // Проверяем, что появилось сообщение об отсутствии товаров в корзине если удалили последний
                waitDisplayedElement(By.xpath("//em[.='There are no items in your cart.']"));
            }
        }
    }

}
