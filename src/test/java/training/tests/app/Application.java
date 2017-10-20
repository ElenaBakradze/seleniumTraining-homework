package training.tests.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

import training.tests.pages.CartPage;
import training.tests.pages.HomePage;
import training.tests.pages.ProductPage;

public class Application {

    // драйвер
    private WebDriver driver;

    // Главная страница
    private HomePage homePage;
    // Страница товара
    private ProductPage productPage;
    // Страница корзины
    private CartPage cartPage;

    public Application() {
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
    }

    /**
     * Добавление трех товаров в корзину
     *
     */
    public void addThreeProductToCart() {
        for (int i = 1; i <= 3; i++) {
            // Открываем главную страницу в браузере и переходим на страницу первого товара
            homePage.open().openFirstProduct();
            // Выбираем размер товара, если поле присутствует и нажимаем кнопку добавления товара в корзину
            productPage.selectSize("Small").clickButtonAddToCart(i);
        }
    }

    /**
     * Удаление всех товаров из корзины
     *
     */
    public void deleteProductsFromCart() {
        // Открываем корзину
        cartPage.open();
        // Кол-во товаров в корзине, которые будем удалять
        int products = cartPage.products.size();
        // По товарам в корзине
        for (int i = 1; i <= products; i++) {
            // Таблица с товарами
            WebElement table = cartPage.getTable();
            // Если еще есть товары для удаления помимо текущего, то в "ленте" с предпросмотром удаляемых товаров выбираем первый
            if (products - i >= 1)
                cartPage.clickOnFirstProductInCart();
            // Форма товара для удаления
            WebElement product = cartPage.getProduct();
            // Название товара, который будем удалять
            String name = cartPage.getProductName(product);
            // Проверяем, что название есть в таблице
            Assert.assertTrue(cartPage.productNameInTable(name));
            // Нажимаем кнопку Remove у товара
            cartPage.clickOnDeleteButton(product);
            // Если удалили не последний товар, то
            if (products - i > 0) {
                // Ждем, когда обновится таблица(исчезнет старая) и обновится форма с товаром (исчезнет старая)
                cartPage.waitCartRefresh(table, product);
                // Проверяем, что название исчезло из таблицы
                Assert.assertFalse(cartPage.productNameInTable(name));
            } else {
                // Проверяем, что появилось сообщение об отсутствии товаров в корзине если удалили последний
                cartPage.waitDeleteAllProducts();
            }
        }
    }

    public void quit() {
        driver.quit();
    }
}