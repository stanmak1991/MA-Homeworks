package Homework02;

public class Person {
    private int id;
    private String name;
    private String surname;
    private int age;

    private Person() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public static Builder createBuilder() {
        return new Person().new Builder();
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", surname=" + surname + ", age=" + age + "]";
    }

    public class Builder {
        private Builder() {

        }

        public Builder setId(int id) {
            Person.this.id = id;
            return this;
        }

        public Builder setName(String name) {
            Person.this.name = name;
            return this;
        }

        public Builder setSurname(String surname) {
            Person.this.surname = surname;
            return this;
        }

        public Builder setAge(int age) {
            Person.this.age = age;
            return this;
        }

        public Person build() {
            return Person.this;
        }
    }
}