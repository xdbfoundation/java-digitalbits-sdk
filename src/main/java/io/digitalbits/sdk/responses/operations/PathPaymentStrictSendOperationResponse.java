package io.digitalbits.sdk.responses.operations;

import com.google.gson.annotations.SerializedName;
import io.digitalbits.sdk.Asset;

import java.util.List;

/**
 * Represents PATH_PAYMENT_STRICT_SEND operation response.
 *
 * @see <a href="https://developers.digitalbits.io/frontier/reference/resources/operation.html" target="_blank">Operation documentation</a>
 * @see io.digitalbits.sdk.requests.OperationsRequestBuilder
 * @see io.digitalbits.sdk.Server#operations()
 */
public class PathPaymentStrictSendOperationResponse extends PathPaymentBaseOperationResponse {
  @SerializedName("destination_min")
  private String destinationMin;

  public String getDestinationMin() {
    return destinationMin;
  }
}
