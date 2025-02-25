package br.datastructures.stack;

import br.datastructures.exceptions.NoSuchItemException;

public class LinkedStack<I> extends AbstractStack<I> {
    class Node {
        I item;
        Node next;
        
        public Node() {
            this(null, null);
        }
        
        public Node(I item) {
            this(item, null);
        }
        
        public Node(I item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
    
    private Node top;
    
    public LinkedStack() {
        top = null;
    }
    
    @Override
    public void push(I item){
        Node newNode = new Node(item, top);
        top = newNode;
        
        quantity++;
    }
    
    @Override
    public I pop() throws NoSuchItemException {
        I item = getTop();
        top = top.next;
        quantity--;

        return item;
    }
    
    @Override
    public I getTop() throws NoSuchItemException {
        if(empty()) 
            throw new NoSuchItemException();
        
        return top.item;
    }
}