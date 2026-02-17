package br.datastructures.stack;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {

    private Stack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new ArrayStack<>(2);
    }

    @AfterEach
    void tearDown() {

    }
}