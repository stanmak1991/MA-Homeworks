package Homework12.test;

import Homework12.collections.LinkedListCustom;
import Homework12.interfaces.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedListCustomTest {
    private List<String> tested = new LinkedListCustom<>();

    @Before
    public void initializeTest() {
        tested.add("Barcelona");
        tested.add("Real");
        tested.add("Mancester United");
        tested.add("Bayern");
        tested.add("Milan");
    }

    @Test
    public void addTest() {
        tested.add("Roma");
        Assert.assertEquals("Roma", tested.get(tested.size() - 1));
    }

    @Test
    public void addAllTest() {
        List<String> temp = new LinkedListCustom<>();
        temp.add("Liverpool");
        temp.add("Zenit");
        temp.add("Manchester City");
        tested.addAll(temp);
        Assert.assertEquals("Liverpool", tested.get(5));
        Assert.assertEquals("Zenit", tested.get(6));
        Assert.assertEquals("Manchester City", tested.get(7));
    }

    @Test
    public void getTest() {
        Assert.assertEquals("Barcelona", tested.get(0));
        Assert.assertEquals("Milan", tested.get(tested.size() - 1));
    }

    @Test(expected = NullPointerException.class)
    public void getTestException() throws NullPointerException {
        tested.get(tested.size() + 1);
    }

    @Test
    public void setTest() {
        tested.set("Juventus", 1);
        Assert.assertEquals("Juventus", tested.get(1));
    }

    @Test
    public void sizeTest() {
        Assert.assertEquals(5, tested.size());
    }

    @Test(expected = NullPointerException.class)
    public void sizeTestException() {
        tested = null;
        tested.size();
    }

    @Test
    public void removeTest() {
        Assert.assertEquals("Real", tested.remove(1));
        Assert.assertEquals("Barcelona", tested.remove("Barcelona"));
    }

    @Test(expected = AssertionError.class)
    public void removeByIndexTestException() throws AssertionError {
        Assert.assertEquals((Integer) 2, tested.remove(-1));
    }

    @Test
    public void removeByValueTestException() {
        Assert.assertEquals(null, tested.remove("QWERTY"));
    }

    @Test
    public void isEmptyTest() {
        Assert.assertEquals(false, tested.isEmpty());
        tested = new LinkedListCustom<>();
        Assert.assertEquals(true, tested.isEmpty());
    }

    @Test(expected = NullPointerException.class)
    public void isEmptyTestException() {
        tested = null;
        tested.isEmpty();
    }
}