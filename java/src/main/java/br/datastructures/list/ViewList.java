package br.datastructures.list;

import br.datastructures.exceptions.*;

public class ViewList {
    public static <I> void view(List<I> list)
            throws NoSuchItemException {

        int position = 0;
        
        try {
            while(true) {
                System.out.println(list.get(position));
                position++;
            }
        }
        catch(Exception e) {}
    }
}