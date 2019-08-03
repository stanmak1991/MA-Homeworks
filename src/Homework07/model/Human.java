package Homework07.model;

import java.io.Serializable;

public class Human implements Serializable {

    private String name;
    private String surname;
    private int age;

    public Human(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Human{" + "name=" + name + ", surname=" + surname + ", age=" + age + '}';
    }
}
