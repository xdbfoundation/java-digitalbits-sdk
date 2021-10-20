package io.digitalbits.sdk.responses.effects;


import com.google.gson.annotations.SerializedName;

/**
 * Represents account_sponsorship_updated effect response.
 * @see <a href="https://developers.digitalbits.io/frontier/reference/resources/effect.html" target="_blank">Effect documentation</a>
 * @see io.digitalbits.sdk.requests.EffectsRequestBuilder
 * @see io.digitalbits.sdk.Server#effects()
 */
public class AccountSponsorshipUpdatedEffectResponse extends EffectResponse {
  @SerializedName("former_sponsor")
  private final String formerSponsor;
  @SerializedName("new_sponsor")
  private final String newSponsor;

  public AccountSponsorshipUpdatedEffectResponse(String formerSponsor, String newSponsor) {
    this.formerSponsor = formerSponsor;
    this.newSponsor = newSponsor;
  }

  public String getFormerSponsor() {
    return formerSponsor;
  }
  public String getNewSponsor() {
    return newSponsor;
  }
}
