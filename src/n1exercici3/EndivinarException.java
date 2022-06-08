package n1exercici3;

public class EndivinarException extends Exception{
    public EndivinarException() {
    }

    public EndivinarException(String message) {
        super(message);
    }

    public EndivinarException(String message, Throwable cause) {
        super(message, cause);
    }

    public EndivinarException(Throwable cause) {
        super(cause);
    }

    public EndivinarException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
