package ru.netology.web.data;

import com.github.javafaker.Faker;
import lombok.Value;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerator {

    @Value
    public static class DataApplication {
        private String changedData = LocalDate.now().plusDays(5).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        Faker faker = new Faker(new Locale("ru"));
        private String city = faker.address().city();
        private String name = faker.name().fullName();
        private String phoneNumber = faker.phoneNumber().phoneNumber();

        private String data = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));





    }

}
