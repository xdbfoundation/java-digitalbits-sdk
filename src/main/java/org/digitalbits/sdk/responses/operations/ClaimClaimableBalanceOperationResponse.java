package io.digitalbits.sdk.responses.operations;

import com.google.common.base.Optional;
import com.google.gson.annotations.SerializedName;
import io.digitalbits.sdk.responses.MuxedAccount;

/**
 * Represents ClaimClaimableBalance operation response.
 * @see io.digitalbits.sdk.requests.OperationsRequestBuilder
 * @see io.digitalbits.sdk.Server#operations()
 */
public class ClaimClaimableBalanceOperationResponse extends OperationResponse {
  @SerializedName("balance_id")
  private String balanceId;
  @SerializedName("claimant")
  private String claimant;
  @SerializedName("claimant_muxed")
  private String claimantMuxed;
  @SerializedName("claimant_muxed_id")
  private Long claimantMuxedId;

  public Optional<MuxedAccount> getClaimantMuxed() {
    if (this.claimantMuxed == null || this.claimantMuxed.isEmpty()) {
      return Optional.absent();
    }
    return Optional.of(new MuxedAccount(this.claimantMuxed, this.claimant, this.claimantMuxedId));
  }

  public String getBalanceId() {
    return balanceId;
  }

  public String getClaimant() {
    return claimant;
  }
}
