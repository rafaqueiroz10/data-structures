package br.datastructures.list;

import br.datastructures.exceptions.NoItemException;
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

    private Node top, end;

    public LinkedList() {
        top = null;
        end = null;
    }

    @Override
    public void insertTop(I item) {
        Node newNode = new Node(item);

        if (empty()) {
            end = newNode;
            top = newNode;
            newNode.next = null;
        }
        else {
            newNode.next = top;
            top = newNode;
        }

        quantity++;
    }

    @Override
    public void insertEnd(I item) {
        Node newNode = new Node(item);

        if (empty()) {
            end = newNode;
            top = newNode;
            newNode.next = null;
        }
        else {
            end.next = newNode;
            end = newNode;
            end.next = null;
        }

        quantity++;
    }
    
    private boolean isValid(int position) {
        return position > -1 && position < size()+1;
    }

    @Override
    public void insert(I item, int position) throws PositionInvalidException {
        if (!isValid(position))
            throw new PositionInvalidException();

        if(position == 0)
            insertTop(item);
        else {
            Node newNode = new Node(item);
            Node aux = top;

            for (int i = 0; i < position - 1; i++)
                aux = aux.next;

            newNode.next = aux.next;
            aux.next = newNode;
            quantity++;
        }
    }

    @Override
    public I removeTop() throws NoItemException {
        I item = getTop();
        top = top.next;
        quantity--;

        return item;
    }

    @Override
    public I removeEnd() throws NoItemException {
        I item = getEnd();

        if(top.equals(end)) {
            top = null;
            end = null;
        }
        else {
            Node aux = top;
            while(!aux.next.equals(end)) 
                aux = aux.next;
         
            aux.next = null;
            end = aux;
        }

        quantity--;

        return item;
    }

    @Override
    public I remove(int position) throws PositionInvalidException, NoItemException {
        if(position == 0)
            return removeTop();
        if(position == size()-1)
            return removeEnd();

        I item = get(position);
        Node aux = top;
        for (int i = 0; i < position - 1; i++) 
            aux = aux.next;
        
        Node next = aux.next;
        aux.next = next.next;
        quantity--;

        return item;
    }

    @Override
    public I getTop() throws NoItemException {
        if(empty())
            throw new NoItemException();

        return top.item;
    }


    public I getEnd() throws NoItemException {
        if (empty())
            throw new NoItemException();

        return end.item;
    }

    @Override
    public I get(int position) throws NoItemException, PositionInvalidException {
        if(!isValid(position))
            throw new PositionInvalidException();

        int p = 0;
        for(Node aux = top; aux != null; aux = aux.next) {
            if(p == position)
                return aux.item;

            p++;
        }

        throw new NoItemException();
    }

    @Override
    public int search(I item) throws NoItemException  {
        int position = 0;
        for(Node aux = top; aux != null; aux = aux.next) {
            if(aux.item.equals(item))
                return position;

            position++;
        }

        return -1;
    }
}
