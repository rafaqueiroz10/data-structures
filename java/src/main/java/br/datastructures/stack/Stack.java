package br.datastructures.stack;

import br.datastructures.exceptions.NoSuchItemException;

public interface Stack<I> {
    public int size();
    
    public boolean empty();
    
    public void push(I item);
    
    public I pop() throws NoSuchItemException;
    
    public I getTop() throws NoSuchItemException;
}