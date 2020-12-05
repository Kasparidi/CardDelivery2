package ru.netology.web.page;

import org.openqa.selenium.Keys;
import ru.netology.web.data.DataGenerator;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class InfoClient {
    public static InfoClient validValue(){
        DataGenerator.DataApplication data = new DataGenerator.DataApplication();
        $("[data-test-id=city] input").setValue(data.getCity());
        $("[data-test-id=date] [value]").sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        $("[data-test-id=date] [value]").setValue(data.getData());
        $("[name='name']").setValue(data.getName());
        $("[name='phone']").setValue(data.getPhoneNumber());
        $("[data-test-id=agreement]").click();
        $("[class='button__text']").click();
        $("[data-test-id=success-notification] .notification__content").waitUntil(visible,4000).shouldHave(exactText("Встреча успешно запланирована на " + data.getData()));
        return new InfoClient();

    }
}
