package br.datastructures.list;

import br.datastructures.exceptions.PositionInvalidException;
import br.datastructures.exceptions.NoItemException;

public class DoubleLinkedList<I> extends AbstractList<I> {
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
    
    private Node top, end;
    
    public DoubleLinkedList() {
        this(null, null);
    }
    
    private DoubleLinkedList(Node top, Node end) {
        this.top = top;
        this.end = end;
    }
    
    // insere item no início da lista
    public void insertTop(I item) { 
        Node newNode = new Node(item);
        if(empty()) {
            top = newNode;
            end = newNode;
            newNode.back = null;
            newNode.next = null;
        }
        else {
            newNode.next = top;
            top.back = newNode;
            newNode.back = null;
            top = newNode;
        }
        quantity++;
    }
    
    // insere item no final da lista
    public void insertEnd(I item) { 
        Node newNode = new Node(item);
        if(empty()) {
            top = newNode;
            end = newNode;
            newNode.back = null;
            newNode.next = null;
        }
        else {
            end.next = newNode;
            newNode.back = end;
            end = newNode;
            end.next = null;
        }
        
        quantity++;
    }
    
    // insere item na 'posisao' da lista
    // 'posicao' análoga ao índice dos arrays
    // posição válida: posicao >= 0 && <= tamanho
    public void insert(I item, int position) throws PositionInvalidException { 
        if(position == 0) {
            insertTop(item);
            return;
        }
        
        if(position == size()) {
            insertEnd(item);
            return;
        }
        
        if (!isValid(position))
            throw new PositionInvalidException();
        
        int p = 1;
        Node newNode = new Node(item);
        Node aux = top;
        
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
    public I removeTop() throws NoItemException {
        I item = getTop();
        top = top.next;
        quantity--;

        return item;   
    }
    
    // remove item no final da lista
    // retorna null se lista vazia
    public I removeEnd() throws NoItemException {
        I item = getEnd();
        end = end.back;
        quantity--;
        
        if(empty())
            top = null;
        else 
            end.next = null;

        return item;
    }
    
    // remove item na 'posicao' da lista
    // retorna null se posicao inválida
    public I remove(int position) throws NoItemException, PositionInvalidException {
        if(!isValid(position))
            throw new PositionInvalidException();
        
        if(position == 0)
            return removeTop();
        
        if(position == size()-1)
            return removeEnd();

        Node aux = top.next;
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
    public I getEnd() throws NoItemException {
        if(empty())
            throw new NoItemException();
        
        return end.item;
    }
    
    // retorna, sem remover, o item no fim da lista
    // null se lista vazia
    public I getTop() throws NoItemException { 
        if(empty())
            throw new NoItemException();
        
        return top.item;
    }
    
    // retorna, sem remover, o item na posição indicada 
    // null se for posição inválida
    public I get(int position) throws NoItemException, PositionInvalidException { 
        if(position < 0 || position > size())
            throw new PositionInvalidException();
        
        int i = 0;
        for(Node aux = top; aux != null; aux = aux.next, i++)
            if(i == position)
                return aux.item;
        
        throw new NoItemException();
    }
    
    // retorna posição do item; 
    // -1 em caso contrário
    public int search(I item) throws NoItemException {
        if(empty())
            throw new NoItemException();
        
        int i = 0;
        for(Node aux = top; aux != null; aux = aux.next, i++) 
            if(aux.item == item)
                return i;
            
        return -1;
    }
}