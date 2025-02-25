package br.datastructures.deque;

import br.datastructures.exceptions.NoSuchItemException;

public class LinkedDeque<I> extends AbstractDeque<I> {
    private static class Node<I> {
        I item;
        Node<I> next, back;
        
        Node(I item, Node next, Node back) {
            this.item = item;
            this.next = next;
            this.back = back;
        }
        
        Node(I item) {
            this(item, null, null);
        }
        
        Node() {
            this(null, null, null);
        }
    }
    
    private Node<I> first, last;
    
    LinkedDeque(Node first, Node last) {
        this.first = first;
        this.last = last;
    }
    
    public LinkedDeque() {
        this(null, null);
    }
    
    @Override
    public void addFirst(I item) {
        Node<I> newNode = new Node<>(item);
        
        if(empty()) {
            first = newNode;
            last = newNode;
            newNode.back = null;
            newNode.next = null;
        }
        else {
            newNode.next = first;
            first.back = newNode;
            newNode.back = null;
            first = newNode;
        }
        
        quantity++;
    }
    
    @Override
    public void addLast(I item) {
        Node<I> newNode = new Node<>(item);
        
        if(empty()) {
            first = newNode;
            last = newNode;
            newNode.back = null;
            newNode.next = null;
        }
        else {
            last.next = newNode;
            newNode.back = last;
            last = newNode;
            last.next = null;
        }
        
        quantity++;
    }
    
    @Override
    public I getLast() throws NoSuchItemException {
        if(empty())
            throw new NoSuchItemException();
        
        return last.item;
    }
    
    @Override
    public I getFirst() throws NoSuchItemException {
        if(empty())
            throw new NoSuchItemException();
        
        return first.item;
    }
    
    @Override
    public I removeFirst() throws NoSuchItemException {
        I item = getFirst();
        first = first.next;
        quantity--;

        return item;
    }
    
    @Override
    public I removeLast() throws NoSuchItemException {
        I item = getLast();
        last = last.back;
        quantity--;
        
        if(empty())
            first = null;
        else 
            last.next = null;

        return item;
    }
}