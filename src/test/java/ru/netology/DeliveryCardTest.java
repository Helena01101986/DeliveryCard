package ru.netology;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
public class DeliveryCardTest {

    @Test
    void shouldTestCardDeliveryOrder() {

        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $x("//input[@placeholder='Город']").setValue("Новосибирск");
        $("[data-test-id=date] input").click();
        //$x("//input[@placeholder='Дата встречи']").clear();
        $("[data-test-id=date] input").setValue(Keys.CONTROL + "a" + Keys.DELETE);
        $("[data-test-id=date] input").setValue("25.03.2023");
        $x("//input[@name='name']").setValue("Иванов Петр");
        $("[data-test-id=phone] input").setValue("+79311234567");
        $("[data-test-id=agreement]").click();
        $x("//span[contains(text(), 'Забронировать')]").click();
        $("[data-test-id='notification']").shouldBe(visible, Duration.ofSeconds(12));
    }

}
