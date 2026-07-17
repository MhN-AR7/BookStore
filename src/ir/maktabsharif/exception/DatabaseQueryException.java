package ir.maktabsharif.exception;

public class DatabaseQueryException extends RuntimeException {
    public DatabaseQueryException(String message) {
        super(message);
    }
}
