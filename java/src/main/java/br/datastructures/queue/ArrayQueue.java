package br.datastructures.queue;

import br.datastructures.exceptions.NoItemException;

public class ArrayQueue<I> extends AbstractQueue<I> {
    private int inicio, ultimo;
    private I items[];
    private int capacity;
    
    public ArrayQueue(int initialSize) {
        inicio = -1;
        ultimo = -1;
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
        
        return items[inicio];
    }
    
    private void resize() {
        capacity *= 2;
        I newItems[] = (I[]) new Object[capacity];
        System.arraycopy(items, inicio, newItems, 0, size());
        
        items = newItems;
    }
    
    @Override
    public void enqueue(I item) {
        if(full()) 
            resize();
        
        if (empty()) 
            inicio = 0;
        
        ultimo++;
        items[ultimo] = item;
        quantity++;
    }
    
    @Override
    public I dequeue() throws NoItemException {
        I item = getFirst();
        inicio++;
        
        if(inicio > ultimo)
            inicio = ultimo = -1;
        
        quantity--;

        return item;
    }
}