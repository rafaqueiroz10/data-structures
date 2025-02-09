package br.datastructures.stack;

public abstract class AbstractStack<I> implements Stack<I> {
    protected int quantity;

    public AbstractStack() {
        quantity = 0;
    }

    @Override
    public boolean empty() {
        return size() == 0;
    }
    
    @Override
    public int size() {
        return quantity;
    }
}