package io.digitalbits.sdk.responses.effects;


import com.google.gson.annotations.SerializedName;

/**
 * Represents claimable_balance_sponsorship_removed effect response.
 * @see <a href="https://developers.digitalbits.io/frontier/reference/resources/effect.html" target="_blank">Effect documentation</a>
 * @see io.digitalbits.sdk.requests.EffectsRequestBuilder
 * @see io.digitalbits.sdk.Server#effects()
 */
public class ClaimableBalanceSponsorshipRemovedEffectResponse extends EffectResponse {
  @SerializedName("former_sponsor")
  private final String formerSponsor;

  @SerializedName("balance_id")
  private final String balanceId;

  public ClaimableBalanceSponsorshipRemovedEffectResponse(String balanceId, String formerSponsor) {
    this.balanceId = balanceId;
    this.formerSponsor = formerSponsor;
  }

  public String getFormerSponsor() {
    return formerSponsor;
  }
  public String getBalanceId() {
    return balanceId;
  }
}
