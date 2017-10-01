package training.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

// Проверка открытия правильной страницы товара
public class TrainingTest006 extends TestBase{

    @Test(description = "Проверка открытия правильной страницы товара")
    public void checkOpenRightProductPage() {
        // Открываем главную страницу в браузере
        getDriver().navigate().to("http://localhost/litecart/");
        // Ждем, когда появится лого на странице
        waitDisplayedElement(By.id("logotype-wrapper"));

        // Будем работать с первым товаром в блоке Campaigns на главной странице
        WebElement product = getDriver().findElement(By.xpath("//*[@id='box-campaigns']//li[1]"));

        // Считываем название товара на главной странице
        String nameHome = product.findElement(By.cssSelector("div.name")).getText();

        // Считываем обычную цену товара на главной странице
        WebElement rPriceHome = product.findElement(By.cssSelector(".regular-price"));
        String regularPriceHome = rPriceHome.getText();

        // Считываем акционную цену товара на главной странице
        WebElement cPriceHome = product.findElement(By.cssSelector(".campaign-price"));
        String campaignPriceHome = cPriceHome.getText();

        // Проверяем стили цен на главной странице
        checkPriceStyle(rPriceHome, cPriceHome);

        // Переходим на страницу товара
        clickOnElement(By.xpath("//*[@id='box-campaigns']//li[1]"));
        waitDisplayedElement(By.cssSelector("#box-product h1"));

        // Считываем название товара на странице товара
        String name = getDriver().findElement(By.cssSelector("#box-product h1")).getText();

        // а) Проверяем, что на главной странице и на странице товара совпадает текст названия товара
        Assert.assertTrue(nameHome.equals(name));

        // Считываем обычную цену товара на странице товара
        WebElement rPrice = getDriver().findElement(By.cssSelector(".regular-price"));
        String regularPrice = rPrice.getText();

        // Считываем акционную цену товара на странице товара
        WebElement cPrice = getDriver().findElement(By.cssSelector(".campaign-price"));
        String campaignPrice = cPrice.getText();

        // б) Проверяем, что на главной странице и на странице товара совпадают цены (обычная и акционная)
        Assert.assertTrue(regularPriceHome.equals(regularPrice));
        Assert.assertTrue(campaignPriceHome.equals(campaignPrice));

        // Проверяем стили цен на странице товара
        checkPriceStyle(rPrice, cPrice);

    }

    /**
     * Проверки стилей цен
     *
     * @param rPrice
     *         обычная цена
     * @param cPrice
     *         акционная цена
     */
    private void checkPriceStyle(WebElement rPrice, WebElement cPrice) {
        // в) Проверяем, что обычная цена зачёркнутая и серая
        // Проверяем, что обычная цена зачёркнутая
        Assert.assertEquals(rPrice.getTagName(), "s");
        // Проверяем, что обычная цена серая
        ArrayList<String> rP = priceColorToList(rPrice);
        // "серый" цвет это такой, у которого в RGBa представлении одинаковые значения для каналов R, G и B
        Assert.assertTrue(rP.get(0).equals(rP.get(1)) && rP.get(1).equals(rP.get(2)));

        // г) Проверяем, что акционная цена жирная и красная
        // Проверяем, что акционная цена жирная
        Assert.assertEquals(cPrice.getTagName(), "strong");
        // Проверяем, что акционная цена красная
        ArrayList<String> cP = priceColorToList(cPrice);
        // "красный" цвет это такой, у которого в RGBa представлении каналы G и B имеют нулевые значения
        Assert.assertTrue(!(cP.get(0).equals("0")) && cP.get(1).equals("0") && cP.get(2).equals("0"));

        // г) Проверяем, что акционная цена крупнее, чем обычная
        float rPS = Float.parseFloat(rPrice.getCssValue("font-size").replace("px", ""));
        float cPS = Float.parseFloat(cPrice.getCssValue("font-size").replace("px", ""));
        Assert.assertTrue(rPS < cPS);
    }


    /**
     * Сформировать из цвета список со значениями
     *
     * @param price
     *         обычная цена
     *
     * @return {@link ArrayList} of {@link String}
     */
    private ArrayList<String> priceColorToList(WebElement price) {
        String pColor = price.getCssValue("color");
        ArrayList<String> p = new ArrayList<>();
        p.addAll(Arrays.asList(price.getCssValue("color").substring(pColor.indexOf("(") + 1, pColor.indexOf(")")).replace(" ", "").split(",")));

        return p;
    }


}
