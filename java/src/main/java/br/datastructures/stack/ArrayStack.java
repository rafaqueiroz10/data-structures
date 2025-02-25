package br.datastructures.stack;

import br.datastructures.exceptions.NoSuchItemException;

public class ArrayStack<I> extends AbstractStack<I> {
    private int top, capacity;
    private I items[];
    
    private ArrayStack(int capacity, int top) {
        this.capacity = capacity;
        this.top = top;
        items = (I[]) new Object[capacity];
    }
    
    public ArrayStack() {
        this(5, -1);
    }
    
    public ArrayStack(int initialSize) {
        this(initialSize, -1);
    }
    
    private I[] resize() {
        I[] newItems = (I[]) new Object[capacity * 2];
        System.arraycopy(items, 0, newItems, 0, capacity);
        capacity *= 2;
        return newItems;
    }
    
    @Override
    public void push(I item) {
        if(top == capacity-1)
            items = resize();
        
        top++;
        items[top] = item;
        quantity++;
    }
    
    @Override
    public I pop() throws NoSuchItemException {
        if(empty())
            throw new NoSuchItemException();
        
        I item = items[top--];
        quantity--;
        
        return item;
    }
    
    
    @Override
    public I getTop() throws NoSuchItemException {
        if(empty())
            throw new NoSuchItemException();
        
        return items[top];
    }
}