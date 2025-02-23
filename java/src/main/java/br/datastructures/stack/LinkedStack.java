package br.datastructures.stack;

import br.datastructures.exceptions.NoItemException;

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
    public I pop() throws NoItemException {
        I item = getTop();
        top = top.next;
        quantity--;

        return item;
    }
    
    @Override
    public I getTop() throws NoItemException {
        if(empty()) 
            throw new NoItemException();
        
        return top.item;
    }
}