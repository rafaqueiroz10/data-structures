package br.datastructures.stack;

import br.datastructures.exceptions.NoItemException;

public interface Stack<I> {
    public int size();
    
    public boolean empty();
    
    public void push(I item);
    
    public I pop() throws NoItemException;
    
    public I getTop() throws NoItemException;
}