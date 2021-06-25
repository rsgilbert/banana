package banana.positionallist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.SplittableRandom;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the PositionalList interface.
 * Methods to test are:
 * addBefore, addAfter
 * All methods in the interface are:
 * size, isEmpty, first, last, after, before, addFirst, addLast, addBefore, addAfter, set, remove
 *
 */
@DisplayName("addBefore and addAfter tests")
public class PositionalList_addBefore_addAfter_Test {
    PositionalList<Integer> list;
    Position<Integer> first;
    SplittableRandom splittableRandom = new SplittableRandom();
    int el;

    @BeforeEach
    void setup() {
        list = new LinkedPositionalList<>();
        first = list.addFirst(splittableRandom.nextInt());
        el = splittableRandom.nextInt();
        System.out.println("Element is " + el);
    }

    @DisplayName("Greg test")
    @Test
    void gregTest() {
        var pl0 = new LinkedPositionalList<Integer>();
        pl0.addFirst(101);
        var p0 = pl0.first();
        var pl1 = new LinkedPositionalList<Integer>();
        pl0.addAfter(p0, 102);
        pl1.addAfter(p0, 201);
        System.out.println("PL 0: " + pl0.positions());
        System.out.println("PL0 size: " + pl0.size());
        System.out.println("PL 1: " + pl1.positions());
        System.out.println("PL1 size: " + pl1.size());
    }

    // -- addBefore --
    @DisplayName("addBefore with null position throws error")
    @Test
    void addBeforeEmptyList_addsFirstPosition() {
        assertThrows(IllegalArgumentException.class, () -> list.addBefore(null, el));
    }

    @DisplayName("addBefore puts to before position")
    @Test
    void addBefore_PutsToBeforePosition() {
        var p = list.addBefore(first, el);
        assertSame(list.before(first), p);
        assertSame(list.first(), p);
    }

    @DisplayName("addBefore returns correct position")
    @Test
    void addBefore_ReturnsCorrectPosition()  {
        var p = list.addBefore(first, el);
        assertEquals(el, p.getElement());
    }

    // -- end addBefore --

    // -- addAfter --
    @DisplayName("addAfter with null position throws error")
    @Test
    void addAfter_withNullPos_throwsError() {
        assertThrows(IllegalArgumentException.class, () -> list.addAfter(null, el));
    }

    @DisplayName("addAfter puts to after position")
    @Test
    void addAfter_putsToLastPos() {
        var p = list.addAfter(first, el);
        assertSame(list.last(), p);
        assertSame(list.after(first), p);

    }

    @DisplayName("addAfter returned position has correct element")
    @Test
    void addAfter_returnedPos_hasCorrectElement() {
        var p = list.addAfter(first, el);
        assertEquals(el, p.getElement());
    }

}
