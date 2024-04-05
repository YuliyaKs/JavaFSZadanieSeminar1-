/*
Домашнее задание
Условие:
Создать проект с использованием Maven или Gradle, добавить в него несколько зависимостей и написать код,
использующий эти зависимости.
Пример решения:
1. Создайте новый Maven или Gradle проект, следуя инструкциям из блока 1 или блока 2.
2. Добавьте зависимости org.apache.commons:commons-lang3:3.14.0 и com.google.code.gson:gson:2.10.1.
3. Создайте класс Person с полями firstName, lastName и age.
4. Используйте библиотеку commons-lang3 для генерации методов toString, equals и hashCode.
5. Используйте библиотеку gson для сериализации и десериализации объектов класса Person в формат JSON.
 */

package com.github.yuliyaks;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Создание списка из объектов класса Person
        Person person1 = new Person("Иван", "Иванов", 25);
        Person person2 = new Person("Петр", "Петров", 30);
        Person person3 = new Person("Сидор", "Сидоров", 35);
        Person person4 = new Person("Иван", "Иванов", 25);
        List<Person> persons = new ArrayList<>(Arrays.asList(person1, person2, person3, person4));

        // Вывод на экран объектов списка с помощью метода toString, использующего библиотеку Commons Lang 3
        persons.forEach(System.out::println);

        // Сравнение объектов с помощью метода equals, использующего библиотеку Commons Lang 3
        System.out.println(person1.equals(person4));
        System.out.println(person2.equals(person3));

        // Вычисление хеш-кода объекта с помощью метода hashCode, использующего библиотеку Commons Lang 3
        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());

        // Сериализация списка объектов в формат json с помощью библиотеки Gson
        String json = makeSerialization(persons);
        System.out.println(json);

        // Десериализация списка объектов из формата json с помощью библиотеки Gson
        List<Person> jsonRead = makeDeserialization(json);
        jsonRead.forEach(System.out::println);
    }

    // Метод для сериализации списка объектов с помощью библиотеки Gson
    public static String  makeSerialization (List<Person> persons) {
        Gson gson = new Gson();
        String json = gson.toJson(persons);
        System.out.println("Serialization of the collection was successful");
        return json;
    }

    // Метод для десериализации списка объектов с помощью библиотеки Gson
    public static List<Person>  makeDeserialization (String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Person>>(){}.getType();
        List<Person> jsonRead = gson.fromJson(json, type);
        System.out.println("Deserialization of the collection was successful");
        return jsonRead;
    }
}