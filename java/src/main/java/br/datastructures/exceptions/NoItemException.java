package br.datastructures.exceptions;

public class NoItemException extends Exception {
    public NoItemException() {
        super("Error: empty list!!");
    }
}