package ru.netology.web.test;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import ru.netology.web.data.DataGenerator;
import ru.netology.web.page.InfoClient;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class CardDeliveryTest {

    @Test
    void ifFillOutFormAgain () {
//        open("http://localhost:9999");
//        String str = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
//        $("[data-test-id=city] input").setValue("Владивосток");
//        $("[data-test-id=date] [value]").sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
//        $("[data-test-id=date] [value]").setValue(str);
//        $("[name='name']").setValue("Светлана Белая");
//        $("[name='phone']").setValue("+79111111111");
//        $("[data-test-id=agreement]").click();
//        $("[class='button__text']").click();
//        $("[data-test-id=success-notification] .notification__content").shouldHave(exactText("Встреча успешно запланирована на " + str));

        open("http://localhost:9999");
        val infoClient = new InfoClient();
        val validValue = InfoClient.validValue();

    }

}