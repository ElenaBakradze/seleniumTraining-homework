package training.tests;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

// Задание 12. Сценарий добавления товара
public class TrainingTest008 extends TestBase{

    @Test(description = "Задание 12. Сценарий добавления товара")
    public void addNewProduct() {
        // Логин в панель администрирования учебного приложения
        loginInStore(loginPass, loginPass);
        // Открываем меню Catalog - Кликаем на пункт меню
        clickOnElement(By.xpath("//span[.='Catalog']"));
        // Кликаем на пункт подменю
        clickOnElement(By.xpath("//ul[@class='docs']//span[.='Catalog']"));

        // Нажимаем на кнопку Add New Product
        clickOnElement(By.xpath("//a[contains(text(),'Add New Product')]"));
        // Данные нового товара
        NewProduct product = new NewProduct();
        // Переходим на закладку General
        clickOnElement(By.xpath("//div[@class='tabs']//a[.='General']"));
        // Заполняем Status - Enabled
        clickOnElement(By.xpath("//label[contains(text(),'Enabled')]/input"));
        // Заполняем поле Name
        enterText(By.cssSelector("[name^=name]"), product.getName());
        // Заполняем поле Code
        enterText(By.name("code"), product.getCode());
        // Заполняем Categories - выставляем все галочки
        checkElementsCheckbox(By.name("categories[]"));
        // Заполняем поле Default Category - выбираем случайный
        selectElement(By.cssSelector("select[name=default_category_id]"), null);
        // Заполняем Gender - выставляем все галочки
        checkElementsCheckbox(By.name("product_groups[]"));
        // Заполняем поле Quantity
        enterText(By.name("quantity"), product.getQuantity());
        // Заполняем поле Quantity Unit - выбираем случайный
        selectElement(By.cssSelector("select[name=quantity_unit_id]"), null);
        // Заполняем поле Delivery Status - выбираем случайный
        selectElement(By.cssSelector("select[name=delivery_status_id]"), null);
        // Заполняем поле Sold Out Status - выбираем случайный
        selectElement(By.cssSelector("select[name=sold_out_status_id]"), null);
        // Заполняем поле Upload Images путем к файлу с картинкой
        Path filePath = Paths.get("new_duck_1.png");
        attachFile(By.name("new_images[]"), filePath.toAbsolutePath().toString());
        // Заполняем поле Date Valid From
        enterText(By.name("date_valid_from"), product.getDateValidFrom());
        // Заполняем поле Date Valid To
        enterText(By.name("date_valid_to"), product.getDateValidTo());

        // Переходим на закладку Information
        clickOnElement(By.xpath("//div[@class='tabs']//a[.='Information']"));
        // Заполняем поле Manufacturer - выбираем случайный
        selectElement(By.cssSelector("select[name=manufacturer_id]"), null);
        // Заполняем поле Supplier - выбираем случайный
        selectElement(By.cssSelector("select[name=supplier_id]"), null);
        // Заполняем поле Keywords
        enterText(By.name("keywords"), product.getKeywords());
        // Заполняем поле Short Description
        enterText(By.cssSelector("[name^=short_description"), product.getShortDescription());
        // Заполняем поле Description
        getDriver().findElement(By.cssSelector("div.trumbowyg-editor")).sendKeys(product.getDescription());
        // Заполняем поле Head Title
        enterText(By.cssSelector("[name^=head_title"), product.getHeadTitle());
        // Заполняем поле Meta Description
        enterText(By.cssSelector("[name^=meta_description"), product.getMetaDescription());

        // Переходим на закладку Prices
        clickOnElement(By.xpath("//div[@class='tabs']//a[.='Prices']"));
        // Заполняем поле Purchase Price
        enterText(By.name("purchase_price"), product.getPurchasePrice());
        selectElement(By.cssSelector("select[name=purchase_price_currency_code"), null);
        // Заполняем поле Tax Class
        selectElement(By.cssSelector("select[name=tax_class_id"), null);
        // Заполняем поле Price
        enterText(By.name("prices[USD]"), product.getPricesUsd());
        // Price Incl. Tax (?) - автоматически заполняется
        // Заполняем поле Price
        enterText(By.name("prices[EUR]"), product.getPricesEur());
        // Price Incl. Tax (?) - автоматически заполняется
        // Нажимаем на кнопку Save
        clickOnElement(By.name("save"));

        // кликаем на пункт меню Catalog
        clickOnElement(By.xpath("//span[.='Catalog']"));
        // Кликаем на пункт подменю
        clickOnElement(By.xpath("//ul[@class='docs']//span[.='Catalog']"));
        // Проверяем, что продукт появился в каталоге
        Assert.assertTrue(isElementPresent(By.xpath("//tr[@class='row']//a[.='" + product.getName() + "']")));

    }

}
