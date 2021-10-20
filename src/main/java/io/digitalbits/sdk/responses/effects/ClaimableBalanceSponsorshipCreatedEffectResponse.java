package io.digitalbits.sdk.responses.effects;


import com.google.gson.annotations.SerializedName;

/**
 * Represents claimable_balance_sponsorship_created effect response.
 * @see <a href="https://developers.digitalbits.io/frontier/reference/resources/effect.html" target="_blank">Effect documentation</a>
 * @see io.digitalbits.sdk.requests.EffectsRequestBuilder
 * @see io.digitalbits.sdk.Server#effects()
 */
public class ClaimableBalanceSponsorshipCreatedEffectResponse extends EffectResponse {
  @SerializedName("sponsor")
  private final String sponsor;

  @SerializedName("balance_id")
  private final String balanceId;

  public ClaimableBalanceSponsorshipCreatedEffectResponse(String balanceId, String sponsor) {
    this.balanceId = balanceId;
    this.sponsor = sponsor;
  }

  public String getSponsor() {
    return sponsor;
  }

  public String getBalanceId() {
    return balanceId;
  }
}
