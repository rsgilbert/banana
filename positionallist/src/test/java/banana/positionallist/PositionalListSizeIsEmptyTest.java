package banana.positionallist;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the PositionalList interface.
 * Methods to test are:
 * size, isEmpty
 * All methods in the interface are:
 * size, isEmpty, first, last, after, addFirst, addLast, addBefore, addAfter, set, remove
 *
 */
@Tag("size-isEmpty")
public class PositionalListSizeIsEmptyTest {
    PositionalList<Integer> list;

    @BeforeEach
    void setupPositionalList() {
        list = new LinkedPositionalList<>();
    }


    @Test
    @DisplayName("isEmpty is true before we add any element")
    void isEmptyTestNoElement() {
        assertTrue(list.isEmpty());
    }

    @DisplayName("isEmpty is false once we add an element")
    @Test
    void isEmptyTestElementsExist() {
        list.addFirst(10);
        assertFalse(list.isEmpty());
    }

    // Notes. Two other methods used: addFirst and remove
    @DisplayName("isEmpty is true once we add then remove and an element")
    @Test
    void isEmptyTestElementRemoved() {
        Position<Integer> p = list.addFirst(5);
        list.remove(p);
        assertTrue(list.isEmpty());
    }


    @DisplayName("Gives correct size")
    @Test
    void sizeTest() {
        list.addFirst(2);
        list.addFirst(10);
        assertEquals(list.size(), 2);
    }
}
