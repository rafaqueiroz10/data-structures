package br.datastructures.list;

import br.datastructures.exceptions.PositionInvalidException;
import br.datastructures.exceptions.NoSuchItemException;

public class DoublyLinkedList<I> extends AbstractList<I> {
    class Node {
        I item;
        Node next, back;
        
        public Node() {
            this(null, null, null);
        }
        
        public Node(I item) {
            this(item, null, null);
        }
        
        public Node(I item, Node next, Node back) {
            this.item = item;
            this.next = next;
            this.back = back;
        }
    }
    
    private Node first, last;
    
    public DoublyLinkedList() {
        this(null, null);
    }
    
    private DoublyLinkedList(Node first, Node last) {
        this.first = first;
        this.last = last;
    }
    
    // insere item no início da lista
    public void insertFirst(I item) { 
        Node newNode = new Node(item);
        
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
    
    // insere item no final da lista
    public void insertLast(I item) { 
        Node newNode = new Node(item);
        
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
    
    // insere item na 'posisao' da lista
    // 'posicao' análoga ao índice dos arrays
    // posição válida: posicao >= 0 && <= tamanho
    public void insert(I item, int position) throws PositionInvalidException { 
        if(position == 0) {
            insertFirst(item);
            return;
        }
        
        if(position == size()) {
            insertLast(item);
            return;
        }
        
        if (!isValid(position))
            throw new PositionInvalidException();
        
        int p = 1;
        Node newNode = new Node(item);
        Node aux = first;
        
        while(p < position) {
            aux = aux.next;
            p++;
        }

        newNode.next = aux.next;
        newNode.back = aux;
        aux.next.back = newNode;
        aux.next = newNode;
        
        quantity++;
    }
    
    // remove item no início da lista
    // retorna null se lista vazia
    public I removeFirst() throws NoSuchItemException {
        I item = getFirst();
        first = first.next;
        quantity--;

        return item;   
    }
    
    // remove item no final da lista
    // retorna null se lista vazia
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
    
    // remove item na 'posicao' da lista
    // retorna null se posicao inválida
    public I remove(int position) throws NoSuchItemException, PositionInvalidException {
        if(!isValid(position))
            throw new PositionInvalidException();
        
        if(position == 0)
            return removeFirst();
        
        if(position == size()-1)
            return removeLast();

        Node aux = first.next;
        int p = 1;
        
        while(aux != null && p != position) {
            aux = aux.next;
            p++;
        }
        
        I item = get(p);
        aux.back.next = aux.next;
        aux.next.back = aux.back;
        quantity--;
        
        return item;
    }
    
    // retorna, sem remover, o item no início da lista
    // null se lista vazia
    public I getLast() throws NoSuchItemException {
        if(empty())
            throw new NoSuchItemException();
        
        return last.item;
    }
    
    // retorna, sem remover, o item no fim da lista
    // null se lista vazia
    public I getFirst() throws NoSuchItemException { 
        if(empty())
            throw new NoSuchItemException();
        
        return first.item;
    }
    
    // retorna, sem remover, o item na posição indicada 
    // null se for posição inválida
    public I get(int position) throws NoSuchItemException, PositionInvalidException { 
        if(position < 0 || position > size())
            throw new PositionInvalidException();
        
        int i = 0;
        for(Node aux = first; aux != null; aux = aux.next, i++)
            if(i == position)
                return aux.item;
        
        throw new NoSuchItemException();
    }
    
    // retorna posição do item; 
    // -1 em caso contrário
    public int search(I item) throws NoSuchItemException {
        if(empty())
            throw new NoSuchItemException();
        
        int i = 0;
        for(Node aux = first; aux != null; aux = aux.next, i++) 
            if(aux.item == item)
                return i;
            
        return -1;
    }
}