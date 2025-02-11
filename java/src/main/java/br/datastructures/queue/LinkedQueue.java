/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.datastructures.queue;

import br.datastructures.exceptions.NoItemException;

public class LinkedQueue<I> extends AbstractQueue<I> {
    class Node {
        I item;
        Node next;
        
        Node(I item, Node next) {
            this.item = item;
            this.next = next;
        }
        
        Node(I item) {
            this(item, null);
        }
    }
    
    private Node first, last;

    public LinkedQueue() {
        first = null;
        last = null;
    }
    
    @Override
    public void enqueue(I item) {
        Node newNode = new Node(item);
        
        if (empty()) {
            first = newNode;
            last = newNode;
        }
        else {
            last.next = newNode;
            last = newNode;
        } 
        
        quantity++;
    }
    
    @Override
    public I getFirst() throws NoItemException {
        if(empty())
            throw new NoItemException();
        
        return first.item;
    }
    
    @Override
    public I dequeue() throws NoItemException {
        I item = getFirst();
        first = first.next;
        
        if(first == null) 
            last = null;
        
        quantity--;

        return item;
    }
}