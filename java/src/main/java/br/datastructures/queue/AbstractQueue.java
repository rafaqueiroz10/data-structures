/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.datastructures.queue;

public abstract class AbstractQueue<T> implements Queue<T> {
    protected int quantity;
    
    public AbstractQueue() {
        quantity = 0;
    }
    
    @Override
    public int size() {
        return quantity;
    }
    
    @Override
    public boolean empty() {
        return size() == 0;
    }
}