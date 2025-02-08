package br.datastructures.list;

public abstract class AbstractList<I> implements List<I> {
    protected int quantity;

    public AbstractList() {
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