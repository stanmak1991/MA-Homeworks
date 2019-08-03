package Homework01;

public class Car implements Cloneable {
    String brand;
    int year;
    int mileage;

    public Car(String brand, int year, int mileage) {
        this.brand = brand;
        this.year = year;
        this.mileage = mileage;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    public int getMileage() {
        return mileage;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return (Car) super.clone();
    }

    @Override
    public String toString() {
        return "Brand: " + brand + ", Year: " + year + ", Mileage: " + mileage;
    }

    @Override
    public int hashCode() {
        return (int) brand.charAt(0) + year + mileage;
    }
}
