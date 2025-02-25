package br.datastructures.exceptions;

public class NoSuchItemException extends Exception {
    public NoSuchItemException() {
        super("Error: empty list!!");
    }
    public NoSuchItemException(String message) {
        super(message);
    }
}