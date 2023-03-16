package ru.netology;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class DeliveryCardTest {

    @Test
    void shouldTestCardDeliveryOrder() {

        open("http://localhost:9999/");
    }

}
