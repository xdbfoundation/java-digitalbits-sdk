package io.digitalbits.sdk.responses.operations;

import com.google.gson.annotations.SerializedName;

/**
 * Represents BumpSequence operation response.
 * @see <a href="https://developers.digitalbits.io/frontier/reference/resources/operation.html" target="_blank">Operation documentation</a>
 * @see io.digitalbits.sdk.requests.OperationsRequestBuilder
 * @see io.digitalbits.sdk.Server#operations()
 */
public class BumpSequenceOperationResponse extends OperationResponse {
    @SerializedName("bump_to")
    protected final Long bumpTo;

    public BumpSequenceOperationResponse(Long bumpTo) {
        this.bumpTo = bumpTo;
    }

    public Long getBumpTo() {
        return bumpTo;
    }
}
