package io.digitalbits.sdk;

/**
 * Indicates that the object that has to be signed has not enough signatures.
 */
public class NotEnoughSignaturesException extends RuntimeException {
    public NotEnoughSignaturesException() {
        super();
    }

    public NotEnoughSignaturesException(String message) {
        super(message);
    }
}
