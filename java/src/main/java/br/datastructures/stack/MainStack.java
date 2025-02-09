package br.datastructures.stack;

public class MainStack {
    public static void test(Stack stack) {
        try {
            stack.push(10);
            stack.push(15);
            
            System.out.println(stack.getTop());
            System.out.println(stack.size());
            System.out.println(stack.empty());
            
            ViewStack.view(stack);
            
            System.out.println(stack.empty());
            System.out.println(stack.size());
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Stack<Integer> arrayStack = new ArrayStack<>();
        test(arrayStack);
    }
}
