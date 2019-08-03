package Homework01;

public class Rhomb {
    public static void printRhomb(int size) {
        if (size < 0) {
            System.out.println("incorrect input");
            return;
        }
        int left = size;
        int right = size;

        for (int i = 0; i < size - 1; i++) {
            for (int y = 1; y < size * 2 - 1; y++) {
                if (y < left || y > right) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            left--;
            right++;
            System.out.println();
        }
        left = 0;
        right = size * 2 - 1;
        for (int i = 0; i < size; i++) {
            for (int y = 0; y < right; y++) {
                if (y >= left && y < right) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            left++;
            right--;
            System.out.println();
        }
    }
}