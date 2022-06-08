package n3exercici3.exceptions;

public class ExceptionInputStringValid extends Exception{
    public ExceptionInputStringValid(String message) {

        super("\u001B[31m" + message.toUpperCase() + "\u001B[0m");
    }
}
