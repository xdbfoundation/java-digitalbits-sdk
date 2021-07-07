package io.digitalbits.sdk.responses.operations;

import com.google.gson.annotations.SerializedName;

/**
 * Represents a Clawback Claimable Balance operation response.
 *
 * @see io.digitalbits.sdk.requests.OperationsRequestBuilder
 * @see io.digitalbits.sdk.Server#operations()
 */
public class ClawbackClaimableBalanceOperationResponse extends OperationResponse {
  @SerializedName("balance_id")
  private final String balanceId;

  public ClawbackClaimableBalanceOperationResponse(String balanceId) {
    this.balanceId = balanceId;
  }

  public String getBalanceId() {
    return balanceId;
  }
}
