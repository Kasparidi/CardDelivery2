package ru.netology.web.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import ru.netology.web.data.DataGenerator;
import ru.netology.web.page.InfoClient;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class CardDeliveryTest {

    @BeforeEach
    void setUp() {
        open("http://localhost:9999");
    }

    @Test
    void happyPath() {
        InfoClient.validValue();
    }

    @Test
    void ifFillOutFormAgainWithChangedDay() {
        DataGenerator.DataApplication data = new DataGenerator.DataApplication();
        InfoClient.validValue();
        $("[data-test-id=date] [value]").sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        $("[data-test-id=date] [value]").setValue(data.getChangedData());
        $("[class='button__text']").click();
        $("[data-test-id='replan-notification'] .notification__title").waitUntil(visible, 4000).shouldHave(exactText("Необходимо подтверждение"));
        $("[data-test-id='replan-notification'] [role=button] .button__text").click();
        $(".notification_visible .notification__content").shouldHave(exactText("Встреча успешно запланирована на " + data.getChangedData()));
    }

    @Test
    void ifFillOutFormAgainWithoutChangeDay() {
        DataGenerator.DataApplication data = new DataGenerator.DataApplication();
        InfoClient.validValue();
        $("[class='button__text']").click();
        $("[data-test-id='replan-notification'] .notification__title").shouldHave(exactText("Встреча успешно запланирована на " + data.getData()));
    }
}