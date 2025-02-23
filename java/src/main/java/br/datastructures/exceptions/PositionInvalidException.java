package br.datastructures.exceptions;

public class PositionInvalidException extends Exception {
    public PositionInvalidException() {
        super("Error: Position is invalid");
    }
    public PositionInvalidException(String message) {
        super(message);
    }
}