package br.datastructures.stack;

import br.datastructures.exceptions.NoItemException;

public class ArrayStack<I> extends AbstractStack<I> {
    private int top, capacity;
    private I items[];
    
    private ArrayStack(int capacity, int top, I items[]) {
        this.capacity = capacity;
        this.top = top;
        this.items = items;
    }
    
    public ArrayStack() {
        this(5, -1, (I[]) new Object[5]);
    }
    
    public ArrayStack(int initialSize) {
        this(initialSize, -1, (I[]) new Object[initialSize]);
    }
    
    private void resize() {
        I[] newItems = (I[]) new Object[capacity * 2];
        System.arraycopy(items, 0, newItems, 0, capacity);
        capacity *= 2;
        items = newItems;
    }
    
    public void push(I item) {
        if(top == capacity-1)
            resize();
        
        top++;
        items[top] = item;
        quantity++;
    }
    
    public I pop() throws NoItemException {
        if(empty())
            throw new NoItemException();
        
        I item = items[top--];
        quantity--;
        
        return item;
    }
    
    public I getTop() throws NoItemException {
        if(empty())
            throw new NoItemException();
        
        return items[top];
    }
}