package io.digitalbits.sdk.responses.effects;


import com.google.gson.annotations.SerializedName;

/**
 * Represents signer_sponsorship_removed effect response.
 * @see <a href="https://developers.digitalbits.io/frontier/reference/resources/effect.html" target="_blank">Effect documentation</a>
 * @see io.digitalbits.sdk.requests.EffectsRequestBuilder
 * @see io.digitalbits.sdk.Server#effects()
 */
public class SignerSponsorshipRemovedEffectResponse extends EffectResponse {
  @SerializedName("former_sponsor")
  private final String formerSponsor;
  @SerializedName("signer")
  private final String signer;

  public SignerSponsorshipRemovedEffectResponse(String signer, String formerSponsor) {
    this.signer = signer;
    this.formerSponsor = formerSponsor;
  }

  public String getSigner() {
    return signer;
  }
  public String getFormerSponsor() {
    return formerSponsor;
  }

}
