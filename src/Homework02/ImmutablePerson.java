package Homework02;

public final class ImmutablePerson {
    private String name;
    private int age;
    private boolean sex;

    public ImmutablePerson(String name, int age, boolean sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean getSex() {
        return sex;
    }

    public ImmutablePerson changeName(String name) {
        return new ImmutablePerson(name, this.age, this.sex);
    }

    public String toString() {
        return name + " " + age + " " + sex;
    }
}