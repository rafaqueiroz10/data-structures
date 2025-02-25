package br.datastructures.deque;

public class MainDeque {
    public static void test(Deque deque) {
        try {
            System.out.println("Insert top: quantos = " + deque.size());
            deque.addFirst(20);
            deque.addLast(30);
            
            System.out.println("Insert top: quantos = " + deque.size());
            System.out.println("Top: " + deque.getFirst() + ", End: " + deque.getLast());
            
            System.out.println(deque.getFirst());
            
            System.out.println("Insert top: quantos = " + deque.size());
            System.out.println("Top: " + deque.getFirst() + ", End: " + deque.getLast());
            
            System.out.println(deque.getFirst());
            System.out.println(deque.getLast());
           
            //ViewDeque.view(deque);
            
            System.out.println(deque.empty());
            System.out.println(deque.size());
            
            System.out.println(deque.getFirst());
            System.out.println(deque.getLast());
            
            System.out.println(deque.empty());
            
            System.out.println(deque.removeFirst());
            System.out.println(deque.removeLast());
            
            System.out.println(deque.empty());
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Deque<Integer> linkedDeque = new LinkedDeque<>();
        test(linkedDeque);
    }
}
