package io.digitalbits.sdk.responses.effects;

import com.google.gson.annotations.SerializedName;
import io.digitalbits.sdk.Asset;

/**
 * Represents trustline_sponsorship_updated effect response.
 * @see <a href="https://developers.digitalbits.io/frontier/reference/resources/effect.html" target="_blank">Effect documentation</a>
 * @see io.digitalbits.sdk.requests.EffectsRequestBuilder
 * @see io.digitalbits.sdk.Server#effects()
 */
public class TrustlineSponsorshipUpdatedEffectResponse extends EffectResponse {
  @SerializedName("asset")
  private final String assetString;
  @SerializedName("former_sponsor")
  protected final String formerSponsor;
  @SerializedName("new_sponsor")
  protected final String newSponsor;

  public TrustlineSponsorshipUpdatedEffectResponse(String assetString, String formerSponsor, String newSponsor) {
    this.assetString = assetString;
    this.formerSponsor = formerSponsor;
    this.newSponsor = newSponsor;
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
  public String getNewSponsor() {
    return newSponsor;
  }
}
