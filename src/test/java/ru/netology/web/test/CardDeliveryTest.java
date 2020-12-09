package ru.netology.web.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import ru.netology.web.data.DataGenerator;
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
        $("[data-test-id=city] input").setValue(String.valueOf(DataGenerator.generateCity()));
        $("[data-test-id=date] [value]").sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        $("[data-test-id=date] [value]").setValue(DataGenerator.generateData());
        $("[name='name']").setValue(DataGenerator.DataApplication.generateClient("ru").getName());
        $("[name='phone']").setValue(DataGenerator.DataApplication.generateClient("ru").getPhoneNumber());
        $("[data-test-id=agreement]").click();
        $("[class='button__text']").click();
        $("[data-test-id=success-notification] .notification__content").waitUntil(visible,4000).shouldHave(exactText("Встреча успешно запланирована на " + DataGenerator.generateData()));
    }

    @Test
    void ifFillOutFormAgainWithChangedDay() {
        $("[data-test-id=city] input").setValue(String.valueOf(DataGenerator.generateCity()));
        $("[data-test-id=date] [value]").sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        $("[data-test-id=date] [value]").setValue(DataGenerator.generateData());
        $("[name='name']").setValue(DataGenerator.DataApplication.generateClient("ru").getName());
        $("[name='phone']").setValue(DataGenerator.DataApplication.generateClient("ru").getPhoneNumber());
        $("[data-test-id=agreement]").click();
        $("[class='button__text']").click();
        $("[data-test-id=success-notification] .notification__content").waitUntil(visible,4000).shouldHave(exactText("Встреча успешно запланирована на " + DataGenerator.generateData()));
        $("[data-test-id=date] [value]").sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        $("[data-test-id=date] [value]").setValue(DataGenerator.anotherData());
        $("[class='button__text']").click();
        $("[data-test-id='replan-notification'] .notification__title").waitUntil(visible, 4000).shouldHave(exactText("Необходимо подтверждение"));
        $("[data-test-id='replan-notification'] [role=button] .button__text").click();
        $(".notification_visible .notification__content").waitUntil(visible, 4000).shouldHave(exactText("Встреча успешно запланирована на " + DataGenerator.anotherData()));
    }

    @Test
    void ifFillOutFormAgainWithoutChangeDay() {
        $("[data-test-id=city] input").setValue(String.valueOf(DataGenerator.generateCity()));
        $("[data-test-id=date] [value]").sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        $("[data-test-id=date] [value]").setValue(DataGenerator.generateData());
        $("[name='name']").setValue(DataGenerator.DataApplication.generateClient("ru").getName());
        $("[name='phone']").setValue(DataGenerator.DataApplication.generateClient("ru").getPhoneNumber());
        $("[data-test-id=agreement]").click();
        $("[class='button__text']").click();
        $("[data-test-id=success-notification] .notification__content").waitUntil(visible,4000).shouldHave(exactText("Встреча успешно запланирована на " + DataGenerator.generateData()));
        $("[class='button__text']").click();
        $("[data-test-id='replan-notification'] .notification__title").waitUntil(visible, 4000).shouldHave(exactText("Встреча успешно запланирована на " + DataGenerator.generateData()));

    }
}