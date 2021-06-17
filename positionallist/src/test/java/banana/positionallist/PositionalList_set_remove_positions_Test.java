package banana.positionallist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
import static banana.positionallist.Util.randomString;
import static org.assertj.core.api.Assertions.*;


@DisplayName("set, remove, positions tests")
public class PositionalList_set_remove_positions_Test {

    PositionalList<String> list;
    String el1;
    String el2;
    String el3;
    String el4;
    Position<String> p1;
    Position<String> p2;
    Position<String> p3;
    Position<String> p4;

    @BeforeEach
    void setup() {
        list = new LinkedPositionalList<>();
        el1 = randomString();
        el2 = randomString();
        el3 = randomString();
        el4 = randomString();
        p1 = list.addLast(el1);
        p2 = list.addLast(el2);
        p3 = list.addLast(el3);
        p4 = list.addLast(el4);
        System.out.println(el1);
    }

    // -- set --
    @DisplayName("set() replaces element with new element")
    @Test
    void set_replacesElementWithNewElement() {
        var newEl = randomString();
        var oldEl = p1.getElement();
        list.set(p1, newEl);
        assertNotEquals(p1.getElement(), oldEl);
        assertEquals(p1.getElement(), newEl);
    }

    @DisplayName("set returns old element")
    @Test
    void set_returnsOldElement(){
        var oldEl = p1.getElement();
        var returnedEl = list.set(p1, el2);
        assertEquals(oldEl, returnedEl);
    }

    // -- set end --

    // -- remove --
    @DisplayName("remove() reduces size by one")
    @Test
    void remove_reducesSizeByOne() {
        var size = list.size();
        list.remove(p1);
        assertEquals(list.size(), size - 1);
        size = list.size();
        list.remove(p2);
        assertEquals(list.size(), size - 1);
    }

    @DisplayName("remove() removes position from list")
    @Test
    void remove_removePositionFromList() {
        var f = list.first();
        list.remove(f);
        assertNotSame(f, list.first());
        var l = list.last();
        list.remove(l);
        assertNotSame(l, list.last());
    }

    @DisplayName("remove() invalidates position")
    @Test
    void remove_invalidatesPosition() {
        list.remove(p1);
        assertThrows(IllegalArgumentException.class, () -> list.after(p1));
        assertThrows(IllegalArgumentException.class, () -> list.before(p1));
        assertThrows(IllegalArgumentException.class, () -> list.addAfter(p1, el1));
        assertThrows(IllegalArgumentException.class, () -> list.addBefore(p1, el2));
        assertThrows(IllegalArgumentException.class, () -> list.remove(p1));
    }

    @DisplayName("remove() returns removed position")
    @Test
    void remove_returnsRemovedPosition() {
        var p1Element = p1.getElement();
        var removed = list.remove(p1);
        assertEquals(p1Element, removed);
    }

    @DisplayName("remove() removes position")
    @Test
    void remove_removesPosition() {
        list.remove(p1);
        assertThat(list.positions()).doesNotContain(p1);
    }


    // -- end remove --

    // -- positions --
    @DisplayName("positions() has correct number of elements")
    @Test
    void positions_hasCorrectSize() {
        assertThat(list.positions()).hasSize(list.size());
    }

    @DisplayName("positions() has all positions")
    @Test
    public void positions_hasAllPositions() {
        assertThat(list.positions()).containsOnly(p1, p2, p3, p4);
    }

    // -- end positions --


}
