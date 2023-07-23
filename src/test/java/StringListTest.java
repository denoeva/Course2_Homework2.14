import org.example.StringListImpl;
import org.example.exceptions.InvalidIndexException;
import org.example.exceptions.StorageIfFullException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringListTest {
    private StringListImpl stringList;

    @Before
    public void setUp() {
        stringList = new StringListImpl();
    }

    @Test
    public void testAdd() {
        stringList.add("item1");
        Assert.assertEquals(1, stringList.size());
        Assert.assertTrue(stringList.contains("item1"));
    }

    @Test
    public void testAddAtIndex() {
        stringList.add("item1");
        stringList.add(1, "item2");
        Assert.assertEquals(2, stringList.size());
        Assert.assertEquals("item1", stringList.get(0));
        Assert.assertEquals("item2", stringList.get(1));
    }

    @Test
    public void testSet() {
        stringList.add("item1");
        stringList.set(0, "updated");
        Assert.assertEquals(1, stringList.size());
        Assert.assertEquals("updated", stringList.get(0));
    }

    @Test
    public void testRemoveByItem() {
        stringList.add("item1");
        stringList.remove("item1");
        Assert.assertEquals(0, stringList.size());
        stringList.get(0); // ожидается исключение ElementNotFoundException
    }

    @Test
    public void testRemoveByIndex() {
        stringList.add("item1");
        stringList.add("item2");
        stringList.add("item3");
        stringList.remove(1);
        Assert.assertEquals(2, stringList.size());
        Assert.assertEquals("item1", stringList.get(0));
        Assert.assertEquals("item3", stringList.get(1));
    }

    @Test
    public void testContains() {
        stringList.add("item1");
        Assert.assertTrue(stringList.contains("item1"));
        Assert.assertFalse(stringList.contains("item2"));
    }

    @Test
    public void testIndexOf() {
        stringList.add("item1");
        stringList.add("item2");
        stringList.add("item3");
        Assert.assertEquals(0, stringList.indexOf("item1"));
        Assert.assertEquals(1, stringList.indexOf("item2"));
        Assert.assertEquals(2, stringList.indexOf("item3"));
        Assert.assertEquals(-1, stringList.indexOf("item4"));
    }

    @Test
    public void testLastIndexOf() {
        stringList.add("item1");
        stringList.add("item2");
        stringList.add("item1");
        Assert.assertEquals(2, stringList.lastIndexOf("item1"));
        Assert.assertEquals(1, stringList.lastIndexOf("item2"));
        Assert.assertEquals(-1, stringList.lastIndexOf("item3"));
    }

    @Test
    public void testGet() {
        stringList.add("item1");
        Assert.assertEquals("item1", stringList.get(0));
    }

    @Test
    public void testEquals() {
        stringList.add("item1");
        stringList.add("item2");
        StringListImpl otherList = new StringListImpl();
        otherList.add("item1");
        otherList.add("item2");
        Assert.assertTrue(stringList.equals(otherList));
    }

    @Test
    public void testSize() {
        stringList.add("item1");
        Assert.assertEquals(1, stringList.size());
    }

    @Test
    public void testIsEmpty() {
        Assert.assertEquals(0, stringList.isEmpty());
        stringList.add("item1");
        Assert.assertEquals(1, stringList.isEmpty());
    }

    @Test
    public void testClear() {
        stringList.add("item1");
        stringList.clear();
        Assert.assertEquals(0, stringList.size());
    }

    @Test
    public void testToArray() {
        stringList.add("item1");
        stringList.add("item2");
        String[] array = stringList.toArray();
        Assert.assertEquals(2, array.length);
        Assert.assertEquals("item1", array[0]);
        Assert.assertEquals("item2", array[1]);
    }

    @Test
    public void testInvalidIndexExceptionTest() {
        assertThrows(InvalidIndexException.class, () ->
                stringList.add(-1, "item"));
    }
}
