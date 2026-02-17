package br.datastructures.queue;

import static org.junit.jupiter.api.Assertions.*;

import br.datastructures.exceptions.NoSuchItemException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class LinkedQueueTest {

    private Queue<Integer> queue;
    
    @BeforeEach
    void newQueue() {
        queue = new LinkedQueue<>();
    }
    
    @Test
    void testEnqueueUmItem() throws NoSuchItemException {
        assertTrue(queue.empty());

        queue.enqueue(10);

        assertEquals(10, queue.getFirst());
        assertEquals(1, queue.size());
        assertFalse(queue.empty());
    }

    @Test
    void testEnqueueDoisItens() throws NoSuchItemException {
        assertTrue(queue.empty());

        queue.enqueue(10);
        queue.enqueue(20);

        assertEquals(10, queue.getFirst());
    }

    @Test
    void testEnqueueVariosItens() throws NoSuchItemException {
        assertTrue(queue.empty());

        for(int i = 0; i < 20; i++)
            queue.enqueue(i);

        assertEquals(0, queue.getFirst());
        assertEquals(20, queue.size());
    }

    @RepeatedTest(5)
    void testGetFirstQueueEmpty() throws NoSuchItemException {
        assertThrows(NoSuchItemException.class, queue::getFirst);
    }

    @RepeatedTest(5)
    void testDequeueQueueEmpty() throws NoSuchItemException {
        assertThrows(NoSuchItemException.class, queue::dequeue);
    }

    @RepeatedTest(2)
    void testEnqueueDequeue10Vezes() throws NoSuchItemException {
        assertTrue(queue.empty());

        for(int i = 0; i < 10; i++)
            queue.enqueue(i);

        assertEquals(0, queue.getFirst());
        assertEquals(10, queue.size());

        for(int i = 9; i > -1; i--) {
            assertEquals(9-i, queue.getFirst());
            assertEquals(9-i, queue.dequeue());
            assertEquals(i, queue.size());
        }

        assertTrue(queue.empty());
    }

    @Test
    void testQueueAposEsvaziar() throws NoSuchItemException {
        queue.enqueue(1);
        queue.dequeue();

        assertTrue(queue.empty());

        queue.enqueue(2);
        assertEquals(2, queue.getFirst());
    }

    @Test
    void testGetFirstNotRemove() throws NoSuchItemException {
        queue.enqueue(1);

        queue.enqueue(2);

        assertEquals(1, queue.getFirst());
        assertEquals(1, queue.getFirst());

        assertEquals(2, queue.size());
    }

    @Test
    void testQueueWithString() throws NoSuchItemException {
        Queue<String> queue1 = new LinkedQueue<>();
        
        assertTrue(queue1.empty());

        queue1.enqueue("A");
        assertTrue(queue1.size() == 1);
        assertEquals("A", queue1.getFirst());

        queue1.enqueue("B");
        assertTrue(queue1.size() == 2);
        assertEquals("A", queue1.getFirst());

        assertEquals("A", queue1.dequeue());
        assertTrue(queue1.size() == 1);
        assertEquals("B", queue1.getFirst());

        assertEquals("B", queue1.dequeue());
        assertTrue(queue1.empty());

        assertThrows(NoSuchItemException.class, queue1::getFirst);
        assertThrows(NoSuchItemException.class, queue1::dequeue);
    }

    @Test
    void testOperations() throws NoSuchItemException {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.dequeue();
        queue.enqueue(3);

        assertEquals(2, queue.size());
    }
}