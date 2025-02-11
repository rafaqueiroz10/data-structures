package br.datastructures.queue;

import br.datastructures.exceptions.NoItemException;

public interface Queue<I> {
    public int size();
    
    public boolean empty();
    
    public void enqueue(I item);
    
    public I getFirst() throws NoItemException;
    
    public I dequeue() throws NoItemException;
}
