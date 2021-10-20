package io.digitalbits.sdk.responses.effects;

import com.google.gson.annotations.SerializedName;
import io.digitalbits.sdk.Asset;

/**
 * Represents trustline_sponsorship_removed effect response.
 * @see <a href="https://developers.digitalbits.io/frontier/reference/resources/effect.html" target="_blank">Effect documentation</a>
 * @see io.digitalbits.sdk.requests.EffectsRequestBuilder
 * @see io.digitalbits.sdk.Server#effects()
 */
public class TrustlineSponsorshipRemovedEffectResponse extends EffectResponse {
  @SerializedName("asset")
  private final String assetString;
  @SerializedName("former_sponsor")
  protected final String formerSponsor;

  public TrustlineSponsorshipRemovedEffectResponse(String assetString, String formerSponsor) {
    this.assetString = assetString;
    this.formerSponsor = formerSponsor;
  }

  public String getAssetString() {
    return assetString;
  }

  public Asset getAsset() {
    return Asset.create(assetString);
  }

  public String getFormerSponsor() {
    return formerSponsor;
  }
}
