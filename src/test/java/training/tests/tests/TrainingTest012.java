package training.tests.tests;

import org.testng.annotations.Test;

// Задание 19. Реализовать многослойную архитектуру в Задании 13
public class TrainingTest012 extends TestBaseNew {

    @Test(description = "Задание 19. Реализовать многослойную архитектуру в Задании 13")
    public void workingWithCartPageObject() {
        // Добавим три товара в корзину
        app.addThreeProductToCart();

        // Удаляем товары из корзины
        app.deleteProductsFromCart();
    }

}
