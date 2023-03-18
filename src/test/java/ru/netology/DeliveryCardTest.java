package ru.netology;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class DeliveryCardTest {

    LocalDate today = LocalDate.now();
    public String generateDate(int days) {
        return today.plusDays(days).format(DateTimeFormatter.ofPattern("dd,MM.yyyy"));
    }

    @Test
    void shouldTestCardDeliveryOrder() {

        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $x("//input[@placeholder='Город']").setValue("Новосибирск");
        $("[data-test-id=date] input").click();
        $("[data-test-id=date] input").setValue(Keys.CONTROL + "a" + Keys.DELETE);
        $("[data-test-id=date] input").setValue(generateDate(7));
        $x("//input[@name='name']").setValue("Иванов Петр");
        $("[data-test-id=phone] input").setValue("+79311234567");
        $("[data-test-id=agreement]").click();
        $x("//span[contains(text(), 'Забронировать')]").click();
        $("[data-test-id='notification']").shouldBe(visible, Duration.ofSeconds(15));
    }

    @Test
    void shouldTestCardDeliveryOrderWithGenerateDate() {

        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $x("//input[@placeholder='Город']").setValue("Новосибирск");
        $x("//input[@placeholder='Дата встречи']").click();
        $x("//input[@placeholder='Дата встречи']").setValue(Keys.CONTROL + "a" + Keys.DELETE);
        $x("//input[@placeholder='Дата встречи']").setValue(generateDate(3));
        $x("//input[@name='name']").setValue("Иванов Петр");
        $("[data-test-id=phone] input").setValue("+79311234567");
        $("[data-test-id=agreement]").click();
        $x("//span[contains(text(), 'Забронировать')]").click();
        $("[data-test-id='notification']").shouldBe(visible, Duration.ofSeconds(15));
    }
}


