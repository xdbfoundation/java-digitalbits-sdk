package io.digitalbits.sdk.responses.operations;

import com.google.gson.annotations.SerializedName;

/**
 * Represents BeginSponsoringFutureReserves operation response.
 * @see io.digitalbits.sdk.requests.OperationsRequestBuilder
 * @see io.digitalbits.sdk.Server#operations()
 */
public class BeginSponsoringFutureReservesOperationResponse extends OperationResponse {
  @SerializedName("sponsored_id")
  private final String sponsoredId;

  public BeginSponsoringFutureReservesOperationResponse(String sponsoredId) {
    this.sponsoredId = sponsoredId;
  }

  public String getSponsoredId() {
    return sponsoredId;
  }
}
