package ru.netology.web.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import ru.netology.web.data.DataGenerator;
import ru.netology.web.data.InfoClient;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class CardDeliveryTest {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    InfoClient client = DataGenerator.DataApplication.generateClient("ru");

    @BeforeEach
    void setUp() {
        open("http://localhost:9999");
    }

    @Test
    void happyPath() {
        $("[data-test-id=city] input").setValue(String.valueOf(DataGenerator.generateCity()));
        $("[data-test-id=date] [value]").sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        $("[data-test-id=date] [value]").setValue(DataGenerator.generateData(3));
        $("[name='name']").setValue(client.getName());
        $("[name='phone']").setValue(client.getPhoneNumber());
        $("[data-test-id=agreement]").click();
        $("[class='button__text']").click();
        $("[data-test-id=success-notification] .notification__content").waitUntil(visible, 4000).
                shouldHave(exactText("Встреча успешно запланирована на " + DataGenerator.generateData(3)));
    }

    @Test
    void ifFillOutFormAgainWithChangedDay() {
        $("[data-test-id=city] input").setValue(String.valueOf(DataGenerator.generateCity()));
        $("[data-test-id=date] [value]").sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        $("[data-test-id=date] [value]").setValue(DataGenerator.generateData(3));
        $("[name='name']").setValue(client.getName());
        $("[name='phone']").setValue(client.getPhoneNumber());
        $("[data-test-id=agreement]").click();
        $("[class='button__text']").click();
        $("[data-test-id=success-notification] .notification__content").waitUntil(visible, 4000).
                shouldHave(exactText("Встреча успешно запланирована на " + DataGenerator.generateData(3)));
        $("[data-test-id=date] [value]").sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        $("[data-test-id=date] [value]").setValue(DataGenerator.generateData(5));
        $("[class='button__text']").click();
        $("[data-test-id='replan-notification'] .notification__title").waitUntil(visible, 4000).
                shouldHave(exactText("Необходимо подтверждение"));
        $("[data-test-id='replan-notification'] [role=button] .button__text").click();
        $(".notification_visible .notification__content").waitUntil(visible, 4000).
                shouldHave(exactText("Встреча успешно запланирована на " + DataGenerator.generateData(5)));
    }

    @Test
    void ifFillOutFormAgainWithoutChangeDay() {
        $("[data-test-id=city] input").setValue(String.valueOf(DataGenerator.generateCity()));
        $("[data-test-id=date] [value]").sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        $("[data-test-id=date] [value]").setValue(DataGenerator.generateData(3));
        $("[name='name']").setValue(client.getName());
        $("[name='phone']").setValue(client.getPhoneNumber());
        $("[data-test-id=agreement]").click();
        $("[class='button__text']").click();
        $("[data-test-id=success-notification] .notification__content").waitUntil(visible, 4000).
                shouldHave(exactText("Встреча успешно запланирована на " + DataGenerator.generateData(3)));
        $("[class='button__text']").click();
        $("[data-test-id='replan-notification'] .notification__title").waitUntil(visible, 4000).
                shouldHave(exactText("Ошибка! У вас уже запланирована на " + DataGenerator.generateData(3)));

    }
}