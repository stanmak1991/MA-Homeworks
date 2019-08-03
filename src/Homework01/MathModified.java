package Homework01;

public class MathModified {
    public static int PowModified(int a, int b) {
        int result = a;
        for (int i = 0; i < b - 1; i++) {
            result *= a;
        }
        return result;
    }
}