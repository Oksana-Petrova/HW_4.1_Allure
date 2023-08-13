package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    private static final Faker faker = new Faker(new Locale("ru"));

    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity() {
        String[] cities = {"Москва", "Санкт-Петербург", "Орёл", "Петропавловск-Камчатский", "Ростов-на-Дону", "Ханты-Мансийск",
                "Горно-Алтайск", "Йошкар-Ола", "Южно-Сахалинск", "Нижний Новгород", "Нарьян-Мар", "Великий Новгород", "Улан-Удэ",
                "Южно-Сахалинск", "Тюмень", "Екатеринбург", "Челябинск", "Пермь", "Омск", "Томск", "Барнаул", "Владивосток",
                "Хабаровск", "Пенза", "Самара", "Брянск", "Тверь", "Иркутск", "Биробиджан", "Астрахань", "Краснодар", "Ставрополь",
                "Мурманск", "Архангельск", "Сыктывкар", "Тула"};
        return (cities[new Random().nextInt(cities.length)]);
    }

    public static String generateName(String locale) {
        String name = faker.name().lastName() + " " + faker.name().firstName();
        return name;
    }

    public static String generatePhone(String locale) {
        String phone = faker.phoneNumber().phoneNumber();
        return phone;
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(), generateName(locale), generatePhone(locale));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}