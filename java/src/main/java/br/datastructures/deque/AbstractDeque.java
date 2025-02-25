package br.datastructures.deque;

public abstract class AbstractDeque<I> implements Deque<I> {
    protected int quantity;
    
    public AbstractDeque() {
        quantity = 0;
    }
    
    @Override
    public boolean empty() {
        return quantity == 0;
    }
    
    @Override
    public int size() {
        return quantity;
    }
}
