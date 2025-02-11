package br.datastructures.queue;

public class MainQueue {
    public static void test(Queue queue) {
        try {
            queue.enqueue(10);
            queue.enqueue(15);
            queue.enqueue(20);
            queue.enqueue(5);
            
            System.out.println(queue.getFirst());
            System.out.println(queue.size());
            System.out.println(queue.empty());
            
            ViewQueue.view(queue);
            
            System.out.println(queue.size());
            System.out.println(queue.empty());
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        Queue<Integer> linkedQueue = new LinkedQueue<>();
        test(linkedQueue);
        
        Queue<Integer> arrayQueue = new ArrayQueue<>(1);
        test(arrayQueue);
    }
}
