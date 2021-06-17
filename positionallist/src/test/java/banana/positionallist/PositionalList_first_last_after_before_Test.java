package banana.positionallist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static banana.positionallist.Util.randomString;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

@DisplayName("first, last, after, before tests")
public class PositionalList_first_last_after_before_Test {
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

    // -- first --
    @DisplayName("first() returns first position")
    @Test
    void first_returnsFirstString(){
        assertSame(p1, list.first());
    }

    @DisplayName("first() returns position with correct element")
    @Test
    void first_CorrectElement() {
        assertEquals(el1, list.first().getElement());
    }
    // -- end first --

    // -- last --

    @DisplayName("last() returns last position")
    @Test
    void last_returnsLastString(){
        assertSame(p4, list.last());
    }

    @DisplayName("last() returns position with correct element")
    @Test
    void last_CorrectElement() {
        assertEquals(el4, list.last().getElement());
    }

    // -- end last --

    // -- after --
    @DisplayName("after() returns after position")
    @Test
    void after_returnsAfterString(){
        assertSame(p2, list.after(p1));
        assertSame(p3, list.after(p2));
        assertSame(p4, list.after(p3));
    }

    @DisplayName("after() returns position with correct element")
    @Test
    void after_CorrectElement() {
        assertEquals(el2, list.after(p1).getElement());
        assertEquals(el3, list.after(p2).getElement());
        assertEquals(el4, list.after(p3).getElement());
    }

    // -- end after --

    // -- before --
    @DisplayName("before() returns before position")
    @Test
    void before_returnsBeforeString(){
        assertSame(p1, list.before(p2));
        assertSame(p2, list.before(p3));
        assertSame(p3, list.before(p4));
    }

    @DisplayName("before() returns position with correct element")
    @Test
    void before_CorrectElement() {
        assertEquals(el1, list.before(p2).getElement());
        assertEquals(el2, list.before(p3).getElement());
        assertEquals(el3, list.before(p4).getElement());
    }

    // -- end after --



}
