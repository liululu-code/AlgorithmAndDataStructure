package top.lll.linearList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import top.lll.linearList.impl.MyLinkedListImpl;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListImplTest {

    private MyLinkedListImpl<Integer> list;

    @BeforeEach
    void setUp() {
        list = new MyLinkedListImpl<>();
    }

    @Test
    void testAddAndSize() {
        list.add(1);
        list.add(2);
        list.add(0, 0);
        assertEquals(3, list.size());
        assertEquals(0, list.get(0));
        assertEquals(1, list.get(1));
        assertEquals(2, list.get(2));
    }

    @Test
    void testRemove() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(2, list.remove(1));
        assertEquals(2, list.size());
    }

    @Test
    void testSet() {
        list.add(1);
        list.add(2);
        assertEquals(2, list.set(1, 3));
        assertEquals(3, list.get(1));
    }

    @Test
    void testContains() {
        list.add(1);
        list.add(2);
        assertTrue(list.contains(1));
        assertFalse(list.contains(3));
    }

    @Test
    void testIndexOf() {
        list.add(1);
        list.add(2);
        assertEquals(0, list.indexOf(1));
        assertEquals(-1, list.indexOf(3));
    }

    @Test
    void testGet() {
        list.add(1);
        assertEquals(1, list.get(0));
    }

    @Test
    void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add(1);
        assertFalse(list.isEmpty());
    }

    @Test
    void testClean() {
        list.add(1);
        list.add(2);
        list.clean();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }
}
