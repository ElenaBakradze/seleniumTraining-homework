package training.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

// Проверить сортировку стран и геозон в админке
public class TrainingTest005 extends TestBase{

    @Test(description = "Проверить сортировку стран и геозон в админке 1)")
    public void checkSortCountriesAndGeoZones001() {
        // Логин в панель администрирования учебного приложения
        loginInStore(loginPass, loginPass);
        // Перейдем на сраницу стран
        getDriver().navigate().to("http://localhost/litecart/admin/?app=countries&doc=countries");
        // Cписок названий стран
        List<String> countriesNames = new ArrayList<String>();
        // Cписок названий стран, у которых количество зон отлично от нуля
        List<String> countriesWhithZones = new ArrayList<String>();
        // Определяем названия стран
        for (WebElement countrie : getDriver().findElements(By.cssSelector(".row"))) {
            // Название страны
            String name = countrie.findElement(By.xpath("./td[5]/a")).getText();
            // Добавляем название страны в список
            countriesNames.add(name);
            // Проверяем наличие в стране зон отличное от нуля
            if (!countrie.findElement(By.xpath("./td[6]")).getText().equals("0")) {
                // Добавляем в список название страны с количеством зон отличных от нуля
                countriesWhithZones.add(name);
            }
        }
        System.out.println("Список стран: " + countriesNames);
        // Проверяем сортировку
        checkSort(countriesNames);

        // Открываем страницу стран, у которых количество зон отлично от нуля
        for (String name : countriesWhithZones) {
            // Открываем страну
            System.out.println("Открываем страну: " + name);
            clickOnElement(By.xpath("//a[.='" + name + "']"));
            // Проверяем, что открылась нужная страна
            Assert.assertEquals(getDriver().findElement(By.name("name")).getAttribute("value"), name);
            // Cписок названий зон
            List<String> zonesNames = new ArrayList<String>();
            // Определяем названия зон
            for (WebElement zone : getDriver().findElements(By.xpath("//*[@id='table-zones']//td[3]"))) {
                // Название зоны
                String zoneName = zone.findElement(By.cssSelector("input")).getAttribute("value");
                // Если название не пустое
                if (!zoneName.equals("")) {
                    // Добавляем название зоны в список
                    zonesNames.add(zoneName);
                }
            }
            System.out.println("Список геозон: " + zonesNames);
            // Проверяем сортировку
            checkSort(zonesNames);
            // Возвращаемся на страницу Стран
            getDriver().navigate().to("http://localhost/litecart/admin/?app=countries&doc=countries");
        }
    }

    @Test(description = "Проверить сортировку стран и геозон в админке 2)")
    public void checkSortCountriesAndGeoZones002() {
        // Находимся под Логином администратора учебного приложения
        // Перейдем на сраницу Геозон
        getDriver().navigate().to("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        // Cписок названий стран
        List<String> countriesNames = new ArrayList<String>();
        // Определяем названия стран
        for (WebElement countrie : getDriver().findElements(By.cssSelector(".row"))) {
            // Добавляем название страны в список
            countriesNames.add(countrie.findElement(By.xpath("./td[3]/a")).getText());
        }

        // Открываем страницу редактирования геозон страны
        System.out.println("Список стран: " + countriesNames);
        for (String name : countriesNames) {
            // Открываем страну
            System.out.println("Открываем страну: " + name);
            clickOnElement(By.xpath("//a[.='" + name + "']"));
            // Проверяем, что открылась нужная страна
            Assert.assertEquals(getDriver().findElement(By.name("name")).getAttribute("value"), name);
            // Cписок названий зон
            List<String> zonesNames = new ArrayList<String>();
            // Определяем названия зон
            for (WebElement zone : getDriver().findElements(By.xpath("//*[@id = 'table-zones']//td[3]//option"))) {
                // Если значение выбрано
                if (zone.getAttribute("selected") != null)
                    // Добавляем в список его название
                    zonesNames.add(zone.getText());
            }
            System.out.println("Список геозон: " + zonesNames);
            // Проверяем сортировку
            checkSort(zonesNames);
            // Возвращаемся на страницу Геозон
            getDriver().navigate().to("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        }
    }

    /**
     * Проверка сортировки списка по алфавиту
     *
     * @param list
     *          список, который нужно проверить
     */
    private void checkSort(List<String> list) {
        // Проверяем, что спиок не пуст
        Assert.assertTrue(list.size() > 0);
        // Отсортированный список
        SortedSet<String> sortedList = new TreeSet<String>();
        sortedList.addAll(list);
        // Сравниваем отсортированный список с тем, что на странице
        Assert.assertEquals(sortedList, list);
    }

}
