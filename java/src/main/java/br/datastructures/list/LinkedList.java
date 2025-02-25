package br.datastructures.list;

import br.datastructures.exceptions.NoSuchItemException;
import br.datastructures.exceptions.PositionInvalidException;

public class LinkedList<I> extends AbstractList<I> {
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

    private Node first, last;

    public LinkedList() {
        first = null;
        last = null;
    }

    @Override
    public void insertFirst(I item) {
        Node newNode = new Node(item);
        
        if (empty()) 
            last = newNode;
        
        newNode.next = first;
        first = newNode;
        
        quantity++;
    }

    @Override
    public void insertLast(I item) {
        Node newNode = new Node(item);
        
        if (empty()) {
            first = newNode;
            last = newNode;
            newNode.next = null;
        }
        else {
            last.next = newNode;
            newNode.next = null;
            last = newNode;
        }
        
        quantity++;
    }

    @Override
    public void insert(I item, int position) throws PositionInvalidException {
        if (position == 0) {
            insertFirst(item);
            return;
        }
        
        if (position == size()) {
            insertLast(item);
            return;
        }
        
        if (!isValid(position))
            throw new PositionInvalidException();
        
        Node newNode = new Node(item);
        Node aux = first;

        for(int i = 0; i < position - 1; i++)
            aux = aux.next;

        newNode.next = aux.next;
        aux.next = newNode;
        quantity++;
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

        if(first.equals(last)) {
            first = null;
            last = null;
        }
        else {
            Node aux = first;
            while(!aux.next.equals(last)) 
                aux = aux.next;
         
            aux.next = null;
            last = aux;
        }

        quantity--;

        return item;
    }

    @Override
    public I remove(int position) throws PositionInvalidException, NoSuchItemException {
        if(position == 0)
            return removeFirst();
        
        if(position == size()-1)
            return removeLast();

        I item = get(position);
        Node aux = first;
        for (int i = 0; i < position - 1; i++) 
            aux = aux.next;
        
        Node next = aux.next;
        aux.next = next.next;
        quantity--;

        return item;
    }

    @Override
    public I getFirst() throws NoSuchItemException {
        if(empty())
            throw new NoSuchItemException();

        return first.item;
    }


    public I getLast() throws NoSuchItemException {
        if (empty())
            throw new NoSuchItemException();

        return last.item;
    }

    @Override
    public I get(int position) throws NoSuchItemException, PositionInvalidException {
        if(!isValid(position))
            throw new PositionInvalidException();

        int p = 0;
        for(Node aux = first; aux != null; aux = aux.next) {
            if(p == position)
                return aux.item;

            p++;
        }

        throw new NoSuchItemException();
    }

    @Override
    public int search(I item) throws NoSuchItemException  {
        if(empty())
            throw new NoSuchItemException();
        
        int position = 0;
        for(Node aux = first; aux != null; aux = aux.next) {
            if(aux.item.equals(item))
                return position;

            position++;
        }

        return -1;
    }
}