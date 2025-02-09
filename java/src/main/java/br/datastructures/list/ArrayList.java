package br.datastructures.list;

import br.datastructures.exceptions.NoItemException;
import br.datastructures.exceptions.PositionInvalidException;

public class ArrayList<I> extends AbstractList<I> {
    private I items[];
    private int capacity;
    
    private ArrayList(I[] items, int capacity) {
        this.items = items;
        this.capacity = capacity;
    }
    
    public ArrayList() {
        this((I[]) new Object[1], 1);
    }

    public ArrayList(int initialSize) {
        this((I[]) new Object[initialSize], initialSize);
    }
    
    public boolean full() {
        return quantity == capacity;
    }
    
    private void resize() {
        capacity *= 2;
        
        I aux[] = (I[]) new Object[capacity];
        
        System.arraycopy(items, 0, aux, 0, quantity);
        
        items = aux;
    }
    
    @Override
    public void insertTop(I item) { 
        quantity++;
        
        if(full())
            resize();
        
        System.arraycopy(items, 0, items, 1, size()-1);
        
        items[0] = item;
    }
    
    @Override
    public void insertEnd(I item) { 
        if(full())
            resize();

        items[size()] = item;
        quantity++;
    }
    
    @Override
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
          
        if(full())
            resize();

        System.arraycopy(items, position, items, position+1, size() - position);
        
        items[position] = item;
        
        quantity++;
    }
    
    @Override
    public I removeTop() throws NoItemException {
        I item = getTop();
        System.arraycopy(items, 1, items, 0, quantity-1);
        
        quantity--; 
        
        return item;
    }
    
    @Override
    public I removeEnd() throws NoItemException {
        I item = getEnd();
        quantity--;
        
        return item; 
    }
    
    @Override
    public I remove(int position) throws PositionInvalidException, NoItemException {
        if(!isValid(position))
            throw new PositionInvalidException();
        
        if(empty())
            throw new NoItemException();
        
        if(position == 0) 
            return removeTop();
       
        if(position == size()-1)
            return removeEnd();
        
        I item = get(position);
        
        System.arraycopy(items, position + 1, items, position, quantity - position - 1);
        
        quantity--;
        
        return item;
    }
    
    @Override
    public I getTop() throws NoItemException {
        if(empty())
            throw new NoItemException();
        
        return items[0]; 
    }
    
    @Override
    public I getEnd() throws NoItemException {
        if(empty())
            throw new NoItemException();
        
        return items[size()-1]; 
    }
    
    @Override
    public I get(int position) throws NoItemException, PositionInvalidException {
        if(!isValid(position))
            throw new PositionInvalidException();
        
        if(empty())
            throw new NoItemException();
        
        return items[position];
    }
    
    @Override
    public int search(I item) {
        for(int i = 0; i < size(); i++)
            if(items[i].equals(item))
                return i;
        
        return -1;
    }
}