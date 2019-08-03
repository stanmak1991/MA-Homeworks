package Homework04;

public class ArrayListCustom<T> implements List<T> {
    private T[] arrayList;
    private int notNullposition = 0;
    private final int CAPACITY = 10;

    public ArrayListCustom() {
        arrayList = (T[]) new Object[CAPACITY];
    }

    @Override
    public void add(T value) {
        if (arrayList.length == notNullposition - 1) {
            T[] tempArray = (T[]) new Object[arrayList.length];
            System.arraycopy(arrayList, 0, tempArray, 0, arrayList.length);
            arrayList = (T[]) new Object[arrayList.length * 2];
            System.arraycopy(tempArray, 0, arrayList, 0, tempArray.length);
        }
        arrayList[notNullposition++] = value;
    }

    @Override
    public void add(T value, int index) {
        T[] tempArray = (T[]) new Object[arrayList.length];
        System.arraycopy(arrayList, 0, tempArray, 0, arrayList.length);
        if (arrayList.length == notNullposition) {
            arrayList = (T[]) new Object[arrayList.length * 2];
        }
        System.arraycopy(tempArray, 0, arrayList, 0, index);
        arrayList[index] = value;
        System.arraycopy(tempArray, index, arrayList, index + 1, tempArray.length - index);
        notNullposition++;
    }

    @Override
    public void addAll(List<T> list) {
        T[] tempArray = (T[]) new Object[arrayList.length + list.size()];
        System.arraycopy(arrayList, 0, tempArray, 0, arrayList.length);
        for (int counter = 0; counter < list.size(); counter++) {
            tempArray[notNullposition++] = list.get(counter);
        }
        arrayList = (T[]) new Object[notNullposition];
        System.arraycopy(tempArray, 0, arrayList, 0, arrayList.length);
    }

    @Override
    public T get(int index) {
        return arrayList[index];
    }

    @Override
    public void set(T value, int index) {
        arrayList[index] = value;
    }

    @Override
    public T remove(int index) {
        T deleted = arrayList[index];
        T[] tempArray = (T[]) new Object[arrayList.length];
        System.arraycopy(arrayList, 0, tempArray, 0, arrayList.length);
        arrayList = (T[]) new Object[--notNullposition];
        System.arraycopy(tempArray, 0, arrayList, 0, index);
        System.arraycopy(tempArray, index + 1, arrayList, index, notNullposition-index);
        return deleted;
    }

    @Override
    public T remove(T t) {
        for (int index = 0; index < arrayList.length; index++) {
            if (t.equals(arrayList[index])) {
                return remove(index);
            }
        }
        return null;
    }

    @Override
    public int size() {
        if (notNullposition == 0) {
            return 0;
        }
        return notNullposition;
    }

    @Override
    public boolean isEmpty() {
        if (notNullposition == 0) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int counter = 0; counter < notNullposition; counter++) {
            if (arrayList[counter] == null) {
                break;
            } else if (counter > 0) {
                result.append(", ");

            }
            result.append(arrayList[counter]);
        }
        result.append("]");
        return result.toString();
    }
}