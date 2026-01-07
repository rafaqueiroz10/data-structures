package br.datastructures.queue;

import br.datastructures.exceptions.NoSuchItemException;

public class ArrayCircularQueue<I> extends AbstractQueue<I> {
    private int first, last, capacity;
    private I items[];
    
    public ArrayCircularQueue(int initialSize) {
        first = -1;
        last = -1;
        capacity = initialSize;
        items = (I[]) new Object[capacity];
    }
    
    public ArrayCircularQueue() {
        this(5);
    }
    
    private boolean full() {
        return size() == capacity;
    }
    
    @Override
    public I getFirst() throws NoSuchItemException {
        if(empty()) 
            throw new NoSuchItemException();
        
        return items[first];
    }
    
    @Override
    public void enqueue(I item) {
        if(full()) 
            return;
        
        if(empty()) 
            first = 0;
        
        if(last == capacity-1)
            last = -1;
        
        last++;
        items[last] = item;
        quantity++;
    }
    
    @Override
    public I dequeue() throws NoSuchItemException {
        I item = getFirst();
        first++;
        quantity--;
        
        if(first == capacity-1)
            first = 0;

        return item;
    }
}