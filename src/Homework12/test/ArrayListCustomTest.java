package Homework12.test;

import Homework12.collections.ArrayListCustom;
import Homework12.interfaces.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayListCustomTest {
    private List<Integer> tested = new ArrayListCustom<>();

    @Before
    public void initializeTest() {
        for (int counter = 0; counter < 5; counter++) {
            tested.add(counter);
        }
    }

    @Test
    public void addTest() {
        tested.add(8);
        Assert.assertEquals((Integer) 3, tested.get(3));
    }

    @Test
    public void addWithIndexTest() {
        tested.add(5);
        Assert.assertEquals((Integer) 5, tested.get(5));
    }

    @Test
    public void addAllTest() {
        List<Integer> temp = new ArrayListCustom<>();
        temp.add(10);
        temp.add(11);
        temp.add(12);
        temp.add(13);
        tested.addAll(temp);
        Assert.assertEquals((Integer) 13, tested.get(8));
    }

    @Test
    public void getTestException() throws ArrayIndexOutOfBoundsException {
        tested.get(tested.size() + 1);
    }

    @Test
    public void getTest() {
        Assert.assertEquals((Integer) 3, tested.get(3));
    }

    @Test
    public void setTest() {
        tested.set(1, 1);
        Assert.assertEquals((Integer) 1, tested.get(1));
    }

    @Test
    public void sizeTest() {
        Assert.assertEquals(5, tested.size());
    }

    @Test(expected = NullPointerException.class)
    public void sizeTestException() throws NullPointerException {
        tested = null;
        tested.size();
    }

    @Test
    public void removeTest() {
        Assert.assertEquals((Integer) 2, tested.remove(2));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void removeTestException() throws ArrayIndexOutOfBoundsException {
        Assert.assertEquals((Integer) 2, tested.remove(-1));
    }

    @Test
    public void isEmptyTest() {
        Assert.assertEquals(false, tested.isEmpty());
    }

    @Test(expected = NullPointerException.class)
    public void isEmptyTestException() throws NullPointerException {
        tested = null;
        tested.isEmpty();
    }
}