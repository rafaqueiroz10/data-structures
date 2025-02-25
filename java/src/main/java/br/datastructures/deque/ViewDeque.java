package br.datastructures.deque;

public class ViewDeque {
    public static void view(Deque deque) {
        try {
            while(true) {
                System.out.println(deque.removeFirst());
            }
        }
        catch(Exception e) {}
    }
}
