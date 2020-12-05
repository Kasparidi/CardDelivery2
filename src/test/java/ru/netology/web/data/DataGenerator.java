package ru.netology.web.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class DataGenerator {

    public String getCity() {
        return getCity();
    }

    @Value
    public static class DataApplication {
        Faker faker = new Faker(new Locale("ru"));
        private String city = faker.address().city();
        private String name = faker.name().fullName();
        private String phoneNumber = faker.phoneNumber().phoneNumber();
        private String data = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));




    }

}
