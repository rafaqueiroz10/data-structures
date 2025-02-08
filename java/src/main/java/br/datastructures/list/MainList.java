package br.datastructures.list;

public class MainList {
    public static void main(String[] args) {
        List<Integer> linkedlist = new LinkedList<>();

        try {
            linkedlist.insert(10, 0);
            System.out.println(linkedlist.get(0));
            
            linkedlist.insert(20, 1);
            System.out.println(linkedlist.get(1));
            
            linkedlist.insert(30, 2);
            System.out.println(linkedlist.get(2));

            ViewList.view(linkedlist);
            
            System.out.println(linkedlist.empty());
            System.out.println(linkedlist.size());
            
            System.out.println(linkedlist.getEnd());
            System.out.println(linkedlist.getTop());
            
            System.out.println(linkedlist.remove(1));
            
            System.out.println(linkedlist.search(20));
            System.out.println(linkedlist.search(10));
            
            System.out.println(linkedlist.empty());
            
            System.out.println(linkedlist.removeTop());
            
            System.out.println(linkedlist.removeEnd());
            
            System.out.println(linkedlist.empty());
            
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}