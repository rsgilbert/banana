package banana.positionallist;

import org.junit.jupiter.api.*;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the PositionalList interface.
 * Methods to test are:
 * addFirst, addLast, addBefore, addAfter
 * All methods in the interface are:
 * size, isEmpty, first, last, after, addFirst, addLast, addBefore, addAfter, set, remove
 *
 */
@Tag("add")
public class PositionalListAddTest {
    PositionalList<Integer> list;

    @BeforeEach
    void setupPositionalList() {
        list = new LinkedPositionalList<>();
    }

    @DisplayName("addFirst increases size of empty list from zero to one")
    @Test
    void addFirstIncreasesSizeTest() {
        list.addFirst(10);
        assertEquals(1, list.size());
    }

    @DisplayName("addFirst puts element to the first position")
    @Test
    void addFirstPutsToFirstPositionTest() {
        Position<Integer> p = list.addFirst(10);
        assertEquals(list.first(), p);
    }

    @DisplayName("position returned by addFirst has correct item")
    @Test
    void addFirstReturnedPositionHasCorrectItemTest() {
        int item = 13;
        Position<Integer> p = list.addFirst(item);
        assertSame(p.getElement(), item);
    }
}
