package ru.netology.web.data;

import com.github.javafaker.Faker;
import lombok.Data;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;

@Data
public class DataGenerator {
    private DataGenerator() {}

    public static class DataApplication {
        private DataApplication() {}

        public static InfoClient generateClient(String locale) {
            Faker faker = new Faker(new Locale("ru"));
            return new InfoClient(
                    generateCity(),
                    faker.name().lastName() + " " + faker.name().firstName(),
                    faker.phoneNumber().phoneNumber()
            );
        }
    }
    public static String generateData(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity() {
        List<String> cities = Arrays.asList("Сыктывкар", "Владикавказ", "Саранск", "Казань", "Ижевск", "Краснодар", "Хабаровск", "Астрахань", "Брянск", "Волгоград");
        Random random = new Random();
        return cities.get(random.nextInt(cities.size()));
    }
}
