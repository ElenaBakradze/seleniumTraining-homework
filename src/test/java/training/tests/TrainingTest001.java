package training.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Тест открытия страницы в браузере
 *
 */

public class TrainingTest001 {

        public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
        public WebDriver driver;

        @Before
        public void start() {
            driver = new ChromeDriver();
        }

        @Test
        public void openLinkInBrowser() {
            driver.navigate().to("http://en.wikipedia.org/wiki/Main_Page");
        }

        @After
        public void stop() {
            driver.quit();
            driver = null;
        }

}
