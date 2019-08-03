package Homework09;

public class Salary implements Sendable<Integer> {
    private String from;
    private String to;
    private Integer salary;

    public Salary(String company, String name, Integer salary) {
        this.from = company;
        this.to = name;
        this.salary = salary;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public Integer getContent() {
        return salary;
    }
}