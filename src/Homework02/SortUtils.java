package Homework02;

public class SortUtils {
    private static int[] swap(int[] arrayForSwap) {
        int temp = arrayForSwap[0];
        arrayForSwap[0] = arrayForSwap[1];
        arrayForSwap[1] = temp;
        return arrayForSwap;
    }

    private static void merge(int[] sourceArray, int[] leftSide, int[] rightSide) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < sourceArray.length; i++) {
            if (x >= leftSide.length) {
                sourceArray[i] = rightSide[y];
                y++;
            } else if (y >= rightSide.length) {
                sourceArray[i] = leftSide[x];
                x++;
            } else {
                if (leftSide[x] < rightSide[y]) {
                    sourceArray[i] = leftSide[x];
                    x++;
                } else if (rightSide[y] < leftSide[x]) {
                    sourceArray[i] = rightSide[y];
                    y++;
                } else if (rightSide[y] == leftSide[x]) {
                    sourceArray[i] = leftSide[x];
                    i++;
                    sourceArray[i] = rightSide[y];
                    x++;
                    y++;
                }
            }
        }
    }

    public static int quickSort(int[] arr, int startIndex, int lastIndex) {
        if (arr.length <= 0) return 1;
        int pointer = arr[lastIndex];
        int i = startIndex, y = lastIndex;
        while (i <= y) {
            while (arr[i] < pointer && i <= lastIndex) ++i;
            while (arr[y] > pointer && y >= startIndex) --y;
            if (i <= y) {
                int[] arrForSwap = new int[]{arr[i], arr[y]};
                arrForSwap = swap(arrForSwap);
                arr[i] = arrForSwap[0];
                arr[y] = arrForSwap[1];
                ++i;
                --y;
            }
        }
        if (y > startIndex) quickSort(arr, startIndex, y);
        if (i < lastIndex) quickSort(arr, i, lastIndex);
        return 0;
    }

    public static int mergeSort(int[] sourceArray) {
        if (sourceArray.length <= 0) return 1;
        int[] leftSide;
        int[] rightSide;

        if (sourceArray.length == 1) return 0;
        else if (sourceArray.length == 2) {
            leftSide = new int[sourceArray.length / 2];
            rightSide = new int[sourceArray.length / 2];
            leftSide[0] = sourceArray[0];
            rightSide[0] = sourceArray[1];
            int tmp = leftSide[0];
            int tmp1 = rightSide[0];

            if (tmp > tmp1) {
                sourceArray[0] = tmp1;
                sourceArray[1] = tmp;
            } else {
                sourceArray[1] = tmp1;
                sourceArray[0] = tmp;
            }

            return 0;
        } else if (sourceArray.length > 2) {
            if ((sourceArray.length % 2) == 1) leftSide = new int[(sourceArray.length / 2) + 1];
            else if (sourceArray.length % 2 == 0) leftSide = new int[sourceArray.length / 2];
            else leftSide = new int[sourceArray.length];

            for (int i = 0; i < leftSide.length; i++) leftSide[i] = sourceArray[i];

            rightSide = new int[sourceArray.length - leftSide.length];
            int counter;

            if (sourceArray.length % 2 == 0) counter = rightSide.length;
            else counter = rightSide.length + 1;

            for (int i = 0; i < sourceArray.length / 2; i++) {
                rightSide[i] = sourceArray[counter];
                counter++;
            }

            mergeSort(leftSide);
            mergeSort(rightSide);
            merge(sourceArray, leftSide, rightSide);
        }
        return 0;
    }

    public static int bubbleSort(int[] arr) {
        if (arr.length <= 0) return 1;
        for (int i = 0; i < arr.length; i++) {
            for (int y = 0; y < arr.length; y++) {
                if (arr[i] < arr[y]) {
                    int[] arrForSwap = new int[]{arr[i], arr[y]};
                    arrForSwap = swap(arrForSwap);
                    arr[i] = arrForSwap[0];
                    arr[y] = arrForSwap[1];
                }
            }
        }
        return 0;
    }

    public static int insertionSort(int[] arr) {
        if (arr.length <= 0) return 1;
        for (int i = 0; i < arr.length; i++) {
            int sortItem = arr[i];
            int y = i;
            while (y > 0 && arr[y - 1] > sortItem) {
                arr[y] = arr[y - 1];
                y--;
            }
            arr[y] = sortItem;
        }
        return 0;
    }

    public static int selectionSort(int[] arr) {
        if (arr.length <= 0) return 1;
        for (int i = 0; i < arr.length; i++) {
            int MinValue = arr[i];
            int index = i;
            for (int y = i + 1; y < arr.length; y++) {
                if (MinValue > arr[y]) {
                    MinValue = arr[y];
                    index = y;
                }
            }
            int temp = arr[i];
            arr[i] = MinValue;
            arr[index] = temp;
        }
        return 0;
    }
}
