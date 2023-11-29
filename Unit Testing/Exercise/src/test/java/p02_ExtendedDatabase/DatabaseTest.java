package p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {

    public static final Person PERSON1 = Mockito.mock(Person.class);
    public static final Person PERSON2 = Mockito.mock(Person.class);
    public static final Person PERSON3 = Mockito.mock(Person.class);
    public static final Person[] EXPECTED_PEOPLE = {PERSON1, PERSON2, PERSON3};
    public static final Integer EXPECTED_SIZE = EXPECTED_PEOPLE.length;
    public static final Person EXPECTED_LAST_ELEMENT = EXPECTED_PEOPLE[EXPECTED_SIZE - 2];
    private Database database;

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(EXPECTED_PEOPLE);
    }

    @Test
    public void test_Constructor_ShouldCreate_CorrectObject() {
        Person[] actualPeople = database.getElements();
        Integer actualSize = actualPeople.length;
        assertArrayEquals("Arrays are not the same!", EXPECTED_PEOPLE, actualPeople);
        assertEquals("Elements count is incorrect", EXPECTED_SIZE, actualSize);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void test_ShouldThrowException_WhenElementsCount_IsGreaterThan16() throws OperationNotSupportedException {
        Person[] elements = new Person[17];
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
        Person person = Mockito.mock(Person.class);
        database.add(person);
        Person[] people = database.getElements();
        int actualSize = people.length;

        assertEquals(person, people[actualSize - 1]);
        assertEquals("Invalid size!", EXPECTED_SIZE + 1, actualSize);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void test_Remove_ShouldThrowExc_WhenDatabase_IsEmpty() throws OperationNotSupportedException {
        Database database = new Database();
        database.remove();
    }

    @Test
    public void test_Remove_ShouldRemove_Successfully() throws OperationNotSupportedException {
        database.remove();
        Person[] people = database.getElements();
        Person actualLastPerson = people[people.length - 1];

        assertEquals(EXPECTED_LAST_ELEMENT, actualLastPerson);
        assertEquals("Invalid size", EXPECTED_SIZE - 1, people.length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_FindByUsername_ShouldThrow_When_UserNotPresent() throws OperationNotSupportedException {
        database.findByUsername("Kaloyan");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_FindByUsername_ShouldThrow_When_UsernameParameterIsNull() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test
    public void test_FindByUsername_ShouldReturn_CorrectPerson() throws OperationNotSupportedException {
        Mockito.when(PERSON1.getUsername()).thenReturn("Kaloyan");
        Person actualPerson = database.findByUsername("Kaloyan");
        assertEquals("Invalid username", PERSON1.getUsername(), actualPerson.getUsername());
        assertEquals(PERSON1.getId(), actualPerson.getId());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_FindById_ShouldThrow_When_UserIdNotPResent() throws OperationNotSupportedException {
        database.findById(1);
    }

    @Test
    public void test_FindById_ShouldReturn_CorrectPerson() throws OperationNotSupportedException {
        Mockito.when(PERSON1.getId()).thenReturn(1);
        Person actualPerson = database.findById(1);
        assertEquals("Invalid ID", PERSON1.getId(), actualPerson.getId());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_FindById_ShouldThrow_WhenIdDuplicated() throws OperationNotSupportedException {
        Person actualPerson = database.findById(0);
    }

}
