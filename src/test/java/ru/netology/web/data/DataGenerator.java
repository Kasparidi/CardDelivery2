package ru.netology.web.data;

import com.github.javafaker.Faker;
import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Data
public class DataGenerator {
    private DataGenerator() {}



    public static class DataApplication {
        private DataApplication() {}

        public static InfoClient generateClient(String locale) {
            Faker faker = new Faker(new Locale("ru"));
            return new InfoClient(
                    faker.address().city(),
                    faker.name().lastName() + " " + faker.name().firstName(),
                    faker.phoneNumber().phoneNumber()
                    );
        }
    }
    public static String generateData() {
        return LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String anotherData() {
        return LocalDate.now().plusDays(5).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
}
