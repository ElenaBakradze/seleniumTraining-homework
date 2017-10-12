package training.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.Math.abs;

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
     * Ожидание когда текст элемента примет нужное значение
     *
     * @param locator
     *          адрес элемента
     *
     * @param locator
     *          текст элемента
     */
    public void waitTextInElement(By locator, String text) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until((ExpectedConditions.textToBePresentInElementLocated(locator, text)));
    }

    /**
     * Ожидание когда элемент исчезнет
     *
     * @param element
     *          элемент
     */
    public void waitElementIsDisappear(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.stalenessOf(element));
    }


    /**
     * Ожидание открытия нового окна
     *
     * @param openWindows
     *          уже открытые окна
     *
     * @return {@link String}
     */
    public String waitAnyWindowOtherThan(Set<String> openWindows) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        return wait.until(anyWindowOtherThan(openWindows));
    }

    /**
     * Новое окно
     *
     * @param openWindows
     *          уже открытые окна
     *
     * @return {@link String}
     */
     public ExpectedCondition<String> anyWindowOtherThan(Set<String> openWindows) {
         return new ExpectedCondition<String>(){
             public String apply(WebDriver driver) {
                 Set<String> handles = driver.getWindowHandles();
                 handles.removeAll(openWindows);
                 return handles.size() > 0 ? handles.iterator().next() : null;
             }
         };
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

    /**
     * Проверка присутствия элемента на странице
     *
     * @param locator
     *          адрес элемента
     */
    boolean isElementPresent(By locator) {
        try {
            getDriver().findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    /**
     * Выбор элемента в выпадающем списке
     *
     * @param locator
     *          адрес элемента
     *
     * @param element
     *          название элемента, который надо выбрать
     *
     * @return {@link String} название выбранного элемент
     */
    public String selectElement(By locator, String element) {
        waitDisplayedElement(locator);
        // Поле с выпадающим списком
        Select select = new Select(getDriver().findElement(locator));
        // Если элемент не задан - выбираем случайный элемент из списка
        if (element == null) {
            // Cписок названий элементов в списке
            List<String> elements = new ArrayList<String>();
            // Определяем список названий элементов
            for (WebElement elem : select.getOptions()) {
                // Добавляем название элемента в список
                elements.add(elem.getText());
            }
            // Выбираем случайный элемент
            element = getRandomItem(elements);
        }
        // Выбираем элемент списке
        select.selectByVisibleText(element);

        return element;
    }

    /**
     * Выделяем элементы чекбоксы, если они не выделены
     *
     * @param locator
     *          адрес элемента
     */
    public void checkElementsCheckbox(By locator) {
        // получаем список элементов
        for (WebElement element : getDriver().findElements(locator)) {
            checkElementCheckbox(element);
        }
    }

    /**
     * Выделяем элемент чекбокс, если он не выделен
     *
     * @param element
     *          элемент
     */
    public void checkElementCheckbox(WebElement element) {
        // если элемент не выделен, то выделяем
        if (element.getAttribute("checked") == null)
            element.click();
        }

    /**
     * Снимаем выделение с элемента чекбокс, если он выделен
     *
     * @param element
     *          элемент
     */
    public void uncheckElementCheckbox(WebElement element) {
        // если элемент выделен, то снимаем выделение
        if (element.getAttribute("checked") != null)
            element.click();
    }


    // линк страницы панели администрирования учебного приложения
    private final String link = "http://localhost/litecart/admin/";
    // имя кнопки Login
    private final String btnLoginName = "login";
    // имя поля для ввода логина
    private final String fieldLogin = "username";
    // имя поля для ввода пароля
    private final String fieldPass = "password";
    // имя поля для ввода пароля
    private final String btnLogout = "//a[@title='Logout']";
    // логин и пароль администратора
    protected final String loginPass = "admin";


    /**
     * Логин в панель администрирования учебного приложения
     *
     * @param user
     *          пользователь
     * @param pass
     *          пароль
     */
    public void loginInStore(String user, String pass) {
        // открываем страницу в браузере
        getDriver().navigate().to(link);
        // Ждем, пока отобразится поле ввода логина и вводим логин
        enterText(By.name(fieldLogin), user);
        // Ждем, пока отобразится поле ввода пароля и вводим пароль
        enterText(By.name(fieldPass), pass);
        // Ждем, пока отобразится кнопка Login и нажимаем кнопку
        clickOnElement(By.name(btnLoginName));
        // Ждем, пока отобразится кнопка выхода (Logout)
        waitDisplayedElement(By.xpath(btnLogout));
    }

    /**
     * Генератор случайных чисел
     */
    public static final Random rnd = new Random(System.currentTimeMillis());

    /**
     * Получение произвольного номера в виде строки
     *
     * @return {@link String}
     */
    public static final String getRandomNumber() {
        return String.valueOf(abs(rnd.nextInt(200000)));
    }


    /**
     * Получение произвольного большого (десятизначного) номера в виде строки
     *
     * @return {@link String}
     */
    public static final String getRandomBigNumber() {
        int min = 1000000000;
        int max = 2000000000;
        int result = abs(rnd.nextInt(max - min) + min);
        return String.valueOf(result);
    }

    /**
     * Получить случайный элемент списка
     *
     * @param list
     *          список
     *
     * @return случайный элемент или null, если пустой список
     */
    public static <T> T getRandomItem(List<T> list) {
        if (list== null || list.isEmpty())
            return null;
        return list.get((int) (Math.random() * list.size()));
    }


    /**
     * Получить случайное значение true илии false
     *
     *
     * @return {@link boolean}
     */
    public boolean falseOrTrue() {
        return (Math.floor(Math.random() * 2) == 0);
    }

    /**
     * формат даты dd.mm.yyyy
     */
    public static final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    /**
     * Получить строку с текущей датой в формате dd.mm.yyyy
     *
     * @return {@link String}
     */
    public static String getCurrentDate() {
        return getCurrentDate(sdf);
    }

    /**
     * Получить строку с текущей датой
     *
     * @param sdf
     *          формат представления даты
     *
     * @return {@link String}
     */
    public static String getCurrentDate(SimpleDateFormat sdf) {
        if (sdf == null)
            throw new IllegalArgumentException("getCurrentDate: illegal date format (NULL)");
        return sdf.format(GregorianCalendar.getInstance().getTime());
    }

    /**
     * Получить случайную дату в будущем
     *
     * @return {@link String}
     */
    public static String getRandomDateInFuture() {
        int day = 5 + (30 > 0 ? rnd.nextInt(30) : 0);
        Calendar cal = GregorianCalendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, day);
        return sdf.format(cal.getTime());
    }

    /**
     * Прикрепление файла
     *
     * @return {@link String}
     */
    public void attachFile(By locator, String file) {
        WebElement input = getDriver().findElement(locator);
        input.sendKeys(file);
    }
}
