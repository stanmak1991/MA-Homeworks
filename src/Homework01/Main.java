package Homework01;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println(Totalizator.totalizator(1, 2, 1, 2));
        Rhomb.printRhomb(5);
        System.out.println(MathModified.PowModified(5, 3));
        System.out.println(MethodsWithRecursion.fibonacci(10));
        System.out.println(MethodsWithRecursion.factorial(10));
        Car bmw = new Car("bmv", 2015, 80000);
        System.out.println(bmw);
        Car mersedes = (Car) bmw.clone();
        mersedes.mileage = 10000;
        mersedes.brand = "mersedes";
        System.out.println(bmw);
        System.out.println(mersedes);
        System.out.println(bmw.hashCode());
        System.out.println(mersedes.hashCode());
        Sort.sortingTest(20);
    }
}