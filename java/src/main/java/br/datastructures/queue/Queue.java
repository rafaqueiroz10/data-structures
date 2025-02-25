package br.datastructures.queue;

import br.datastructures.exceptions.NoSuchItemException;

public interface Queue<I> {
    public int size();
    
    public boolean empty();
    
    public void enqueue(I item);
    
    public I getFirst() throws NoSuchItemException;
    
    public I dequeue() throws NoSuchItemException;
}
