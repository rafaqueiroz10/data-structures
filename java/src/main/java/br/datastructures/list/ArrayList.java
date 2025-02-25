package br.datastructures.list;

import br.datastructures.exceptions.NoSuchItemException;
import br.datastructures.exceptions.PositionInvalidException;

public class ArrayList<I> extends AbstractList<I> {
    private I items[];
    private int capacity;
    
    public ArrayList(int capacity) {
        this.items = (I[]) new Object[capacity];
        this.capacity = capacity;
    }
    
    public ArrayList() {
        this(5);
    }
    
    private boolean full() {
        return quantity == capacity;
    }
    
    private I[] resize() {
        capacity *= 2;
        I aux[] = (I[]) new Object[capacity];
        
        System.arraycopy(items, 0, aux, 0, quantity);
        
        return aux;
    }
    
    @Override
    public void insertFirst(I item) { 
        quantity++;
        
        if(full())
            items = resize();
        
        System.arraycopy(items, 0, items, 1, size()-1);
        items[0] = item;
    }
    
    @Override
    public void insertLast(I item) { 
        if(full())
            items = resize();

        items[size()] = item;
        quantity++;
    }
    
    @Override
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
          
        if(full())
            items = resize();

        System.arraycopy(items, position, items, position+1, size() - position);
        items[position] = item;
        
        quantity++;
    }
    
    @Override
    public I removeFirst() throws NoSuchItemException {
        I item = getFirst();
        System.arraycopy(items, 1, items, 0, quantity-1);
        
        quantity--; 
        
        return item;
    }
    
    @Override
    public I removeLast() throws NoSuchItemException {
        I item = getLast();
        quantity--;
        
        return item; 
    }
    
    @Override
    public I remove(int position) throws PositionInvalidException, NoSuchItemException {
        if(!isValid(position))
            throw new PositionInvalidException();
        
        if(empty())
            throw new NoSuchItemException();
        
        if(position == 0) 
            return removeFirst();
       
        if(position == size()-1)
            return removeLast();
        
        I item = get(position);
        System.arraycopy(items, position + 1, items, position, quantity - position - 1);
        
        quantity--;
        
        return item;
    }
    
    @Override
    public I getFirst() throws NoSuchItemException {
        if(empty())
            throw new NoSuchItemException();
        
        return items[0]; 
    }
    
    @Override
    public I getLast() throws NoSuchItemException {
        if(empty())
            throw new NoSuchItemException();
        
        return items[size()-1]; 
    }
    
    @Override
    public I get(int position) throws NoSuchItemException, PositionInvalidException {
        if(!isValid(position))
            throw new PositionInvalidException();
        
        if(empty())
            throw new NoSuchItemException();
        
        return items[position];
    }
    
    @Override
    public int search(I item) throws NoSuchItemException {
        if(empty())
            throw new NoSuchItemException();
        
        for(int i = 0; i < size(); i++)
            if(items[i].equals(item))
                return i;
        
        return -1;
    }
}