package br.datastructures.deque;

import br.datastructures.exceptions.NoSuchItemException;

public interface Deque<I> {
    public void addFirst(I item);
    
    public void addLast(I item);
    
    public I removeFirst() throws NoSuchItemException;
    
    public I removeLast() throws NoSuchItemException;
    
    public I getFirst() throws NoSuchItemException;
    
    public I getLast() throws NoSuchItemException;
    
    public boolean empty();
    
    public int size();
}
