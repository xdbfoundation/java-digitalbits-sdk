package io.digitalbits.sdk.responses.effects;

import com.google.gson.annotations.SerializedName;

/**
 * Represents claimable_balance_clawed_back effect response.
 *
 * @see <a href="https://developers.digitalbits.io/frontier/reference/resources/effect.html" target="_blank">Effect documentation</a>
 * @see io.digitalbits.sdk.requests.EffectsRequestBuilder
 * @see io.digitalbits.sdk.Server#effects()
 */
public class ClaimableBalanceClawedBackEffectResponse extends EffectResponse {
  @SerializedName("balance_id")
  protected final String balanceId;

  public ClaimableBalanceClawedBackEffectResponse(String balanceId) {
    this.balanceId = balanceId;
  }

  public String getBalanceId() {
    return balanceId;
  }

}
