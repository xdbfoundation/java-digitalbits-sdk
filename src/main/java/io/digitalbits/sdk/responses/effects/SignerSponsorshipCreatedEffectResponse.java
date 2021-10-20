package io.digitalbits.sdk.responses.effects;


import com.google.gson.annotations.SerializedName;

/**
 * Represents signer_sponsorship_created effect response.
 * @see <a href="https://developers.digitalbits.io/frontier/reference/resources/effect.html" target="_blank">Effect documentation</a>
 * @see io.digitalbits.sdk.requests.EffectsRequestBuilder
 * @see io.digitalbits.sdk.Server#effects()
 */
public class SignerSponsorshipCreatedEffectResponse extends EffectResponse {
  @SerializedName("sponsor")
  private final String sponsor;
  @SerializedName("signer")
  private final String signer;

  public SignerSponsorshipCreatedEffectResponse(String signer, String sponsor) {
    this.signer = signer;
    this.sponsor = sponsor;
  }

  public String getSponsor() {
    return sponsor;
  }
  public String getSigner() {
    return signer;
  }
}
