package br.datastructures.list;

public class MainList {
    public static void testList(List list) {
        try {
            list.insert(10, 0);
            System.out.println(list.get(0));
            ViewList.view(list);
            
            System.out.println("Insert top: quantos = " + list.size());
            System.out.println("Top: " + list.getFirst() + ", End: " + list.getLast());
            
            System.out.println(list.getFirst());
            
            list.insert(20, 1);
            
            System.out.println("Insert top: quantos = " + list.size());
            System.out.println("Top: " + list.getFirst() + ", End: " + list.getLast());
            
            System.out.println(list.get(1));
            System.out.println(list.getFirst());
            
            
            list.insert(30, 2);
            
            System.out.println("Insert top: quantos = " + list.size());
            System.out.println("Top: " + list.getFirst() + ", End: " + list.getLast());
            
            System.out.println(list.get(2));
            System.out.println(list.getFirst());
            System.out.println(list.getLast());
           
            ViewList.view(list);
            
            System.out.println(list.empty());
            System.out.println(list.size());
            
            System.out.println(list.getFirst());
            System.out.println(list.getLast());
            
            System.out.println(list.remove(1));
            
            System.out.println(list.search(20));
            System.out.println(list.search(10));
            
            System.out.println(list.empty());
            
            System.out.println(list.removeFirst());
            
            System.out.println(list.removeLast());
            
            System.out.println(list.empty());
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        List<Integer> linkedList = new LinkedList<>(); 
        testList(linkedList);
        
        System.out.println();
        
        List<Integer> arrayList = new ArrayList<>(); 
        testList(arrayList);
        
        System.out.println();
        
        List<Integer> doubleLinkedList = new DoublyLinkedList<>(); 
        testList(doubleLinkedList);
    }
}