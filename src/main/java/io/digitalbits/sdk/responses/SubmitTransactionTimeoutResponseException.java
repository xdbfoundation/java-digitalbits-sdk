package io.digitalbits.sdk.responses;

public class SubmitTransactionTimeoutResponseException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Timeout. Please resubmit your transaction to receive submission status. More info: https://developers.digitalbits.io/frontier/reference/errors/timeout.html";
    }
}
