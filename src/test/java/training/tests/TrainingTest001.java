package training.tests;

import org.testng.annotations.Test;

// Тест открытия страницы в браузере
public class TrainingTest001 extends TestBase{

        @Test(description = "Тест открытия страницы в браузере")
        public void openLinkInBrowser() {
            getDriver().navigate().to("http://en.wikipedia.org/wiki/Main_Page");
        }


}
