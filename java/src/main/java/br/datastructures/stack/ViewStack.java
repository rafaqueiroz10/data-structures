package br.datastructures.stack;

import br.datastructures.exceptions.NoItemException;

public class ViewStack {
    public static void view(Stack stack) {
        try {
            while(true) {
                System.out.println(stack.pop());
            }
        }
        catch(Exception e) {}
    }
}
