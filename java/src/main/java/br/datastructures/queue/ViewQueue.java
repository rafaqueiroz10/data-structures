package br.datastructures.queue;

import br.datastructures.exceptions.NoSuchItemException;

public class ViewQueue {
    public static void view(Queue queue) {
        try {
            while(true) {
                System.out.println(queue.dequeue());
            }
        }
        catch(Exception e) {}
    }
}