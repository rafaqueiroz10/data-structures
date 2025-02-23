package br.datastructures.queue;

import br.datastructures.exceptions.NoItemException;

public class ArrayQueue<I> extends AbstractQueue<I> {
    private int first, last;
    private I items[];
    private int capacity;
    
    public ArrayQueue(int initialSize) {
        first = -1;
        last = -1;
        capacity = initialSize;
        items = (I[]) new Object[capacity];
    }
    
    private boolean full() {
        return size() == capacity;
    }
    
    @Override
    public I getFirst() throws NoItemException {
        if(empty()) 
            throw new NoItemException();
        
        return items[first];
    }
    
    private I[] resize() {
        capacity *= 2;
        I newItems[] = (I[]) new Object[capacity];
        System.arraycopy(items, first, newItems, 0, size());
        
        return newItems;
    }
    
    @Override
    public void enqueue(I item) {
        if(full()) 
            items = resize();
        
        if (empty()) 
            first = 0;
        
        last++;
        items[last] = item;
        quantity++;
    }
    
    @Override
    public I dequeue() throws NoItemException {
        I item = getFirst();
        first++;
        
        if(first > last)
            first = last = -1;
        
        quantity--;

        return item;
    }
}