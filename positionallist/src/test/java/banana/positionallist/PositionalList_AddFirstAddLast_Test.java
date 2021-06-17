package banana.positionallist;

import org.junit.jupiter.api.*;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the PositionalList interface.
 * Methods to test are:
 * addBefore, addAfter
 * All methods in the interface are:
 * size, isEmpty, first, last, after, addFirst, addLast, addBefore, addAfter, set, remove
 *
 */
@DisplayName("addFirst and addLast tests")
public class PositionalList_AddFirstAddLast_Test {
    PositionalList<Integer> list;

    @BeforeEach
    void setupPositionalList() {
        list = new LinkedPositionalList<>();
    }

    // -- addFirst tests --
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

    // -- end addFirst --

    // -- addLast tests --
    @DisplayName("add last increases size")
    @Test
    void addLastIncreasesSize() {
        list.addLast(2);
        assertEquals(list.size(), 1);
    }

    @DisplayName("add last returned position has correct element")
    @Test
    void addLastPositionHasCorrectElement() {
        int item = 4;
        var p = list.addLast(4);
        assertSame(item, p.getElement());
    }

    @DisplayName("add last puts to last position")
    @Test
    void addLastPutsToLastPosition() {
        list.addLast(1);
        list.addLast(5);
        var last = list.addLast(2);
        assertSame(list.last(), last);
    }

    // -- end addLast --



}