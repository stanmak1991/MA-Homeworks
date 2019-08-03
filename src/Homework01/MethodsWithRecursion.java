package Homework01;

public class MethodsWithRecursion {
    public static int fibonacci(int number) {
        if (number == 1 || number == 2) {
            return 1;
        } else {
            return fibonacci(number - 1) + fibonacci(number - 2);
        }
    }

    public static int factorial(int number) {
        if (number == 1) {
            return 1;
        } else {
            return number * factorial(number - 1);
        }
    }

    public static double taylor(int number, int counter) {
        if (counter == 0 || counter == 1) {
            return 1;
        }
        return (taylor(number, counter - 1) + Math.pow(number, counter - 1) / factorial(counter - 1));
    }
}