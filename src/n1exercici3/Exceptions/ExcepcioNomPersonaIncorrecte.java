package n1exercici3.Exceptions;

public class ExcepcioNomPersonaIncorrecte extends Exception{
    public ExcepcioNomPersonaIncorrecte(String message) {
        super("\u001B[31m" + message.toUpperCase() + "\u001B[0m");
    }
}
