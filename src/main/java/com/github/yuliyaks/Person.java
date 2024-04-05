package com.github.yuliyaks;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    // Метод для получения текстового описания объекта с помощью библиотеки Commons Lang 3
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.NO_CLASS_NAME_STYLE);
    }

    // Метод для сравнения объектов с помощью библиотеки Commons Lang 3
    @Override
    public boolean equals (Object obj) { // Два объекта равны тогда и только тогда, когда каждое значение свойства равно
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    // Метод для вычисления хеш-кода объекта с помощью библиотеки Commons Lang 3
    @Override
    public int hashCode () { // Хеш-код генерируется на основе значения атрибута
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
