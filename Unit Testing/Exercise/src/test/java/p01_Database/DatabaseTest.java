package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Array;

import static org.junit.Assert.*;

public class DatabaseTest {
    private static final Integer[] EXPECTED_ELEMENTS = {1, 2, 3, 4, 5};
    private static final int EXPECTED_SIZE = EXPECTED_ELEMENTS.length;
    private static final int EXPECTED_INDEX = EXPECTED_ELEMENTS.length - 1;
    public static final Integer EXPECTED_LAST_ELEMENT = EXPECTED_ELEMENTS[3];

    private Database database;
    @Before
    public void SetUp() throws OperationNotSupportedException {
        database = new Database(EXPECTED_ELEMENTS);
    }

    @Test
    public void test_Constructor_ShouldCreate_CorrectObject() throws OperationNotSupportedException {

        Integer[] actualElements = database.getElements();
        int actualElementsSize = actualElements.length;
        int actualIndex = actualElementsSize - 1;

        assertArrayEquals(EXPECTED_ELEMENTS, actualElements);
        assertEquals(EXPECTED_SIZE, actualElementsSize);
        assertEquals(EXPECTED_INDEX, actualIndex);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Constructor_ShouldThrowException_WhenElementsAreGreater_Than15() throws OperationNotSupportedException {
        Integer[] elements = new Integer[17];
        database = new Database(elements);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Constructor_ShouldThrowException_WhenElementsAre_Zero() throws OperationNotSupportedException {
        Database database = new Database(); //create database with Array with zero elements
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_addNull_ShouldThrow() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void test_ShouldAdd_Element_AtTheEnd() throws OperationNotSupportedException {
        database.add(25);
        Integer[] elements = database.getElements();
        int actualSize = elements.length;

        assertEquals(Integer.valueOf(25), elements[actualSize - 1]);
    }

    @Test
    public void test_Add_ShouldIncreaseSize_WhenAddElement() throws OperationNotSupportedException {
        database.add(25);
        Integer[] elements = database.getElements();
        int actualSize = elements.length;

        assertEquals(EXPECTED_SIZE + 1, actualSize);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void test_Remove_ShouldThrowExc_WhenDatabase_IsEmpty() throws OperationNotSupportedException {
        Database database = new Database();
        database.remove();
    }

    @Test
    public void test_Remove_ShouldRemove_Successfully() throws OperationNotSupportedException {
        database.remove();
        Integer[] elements = database.getElements();
        Integer actualLastElement = elements[elements.length - 1];
        assertEquals(EXPECTED_LAST_ELEMENT, actualLastElement);
    }

    @Test
    public void test_ShouldDecreaseSize_WhenRemove_Element() throws OperationNotSupportedException {
        database.remove();
        int actualSize = database.getElements().length;

        assertEquals(EXPECTED_SIZE - 1, actualSize);
    }

}
