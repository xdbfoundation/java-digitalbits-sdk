package io.digitalbits.sdk.responses;

public class SubmitTransactionTimeoutResponseException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Timeout. Please resubmit your transaction to receive submission status. More info: https://developers.digitalbits.io/api/errors/http-status-codes/frontier-specific/timeout/";
    }
}
