package Homework03;

public class ArraysMerge {
    public static void testMerge(int[] firstArray, int[] secondArray) {
        int[] resultArray = mergeArrays(firstArray, secondArray);
        System.out.print("[");
        for (int number : resultArray) {
            System.out.print(number + " ");
        }
        System.out.print("]");
    }

    public static int[] mergeArrays(int[] firstArray, int[] secondArray) {
        int[] resultArray = new int[firstArray.length + secondArray.length];
        int firstArrayCounter = 0;
        int secondArrayCounter = 0;

        for (int i = 0; i < resultArray.length; i++) {
            if (firstArrayCounter >= firstArray.length) {
                resultArray[i] = secondArray[secondArrayCounter];
                secondArrayCounter++;
            } else if (secondArrayCounter >= secondArray.length) {
                resultArray[i] = firstArray[firstArrayCounter];
                firstArrayCounter++;
            } else {
                if (firstArray[firstArrayCounter] < secondArray[secondArrayCounter]) {
                    resultArray[i] = firstArray[firstArrayCounter];
                    firstArrayCounter++;
                } else if (secondArray[secondArrayCounter] < firstArray[firstArrayCounter]) {
                    resultArray[i] = secondArray[secondArrayCounter];
                    secondArrayCounter++;
                } else if (secondArray[secondArrayCounter] == firstArray[firstArrayCounter]) {
                    resultArray[i] = firstArray[firstArrayCounter];
                    firstArrayCounter++;
                }
            }
        }
        return resultArray;
    }
}