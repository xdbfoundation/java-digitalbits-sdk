package io.digitalbits.sdk.responses.effects;

import com.google.gson.annotations.SerializedName;
import io.digitalbits.sdk.Asset;

/**
 * Represents trustline_sponsorship_created effect response.
 * @see <a href="https://developers.digitalbits.io/frontier/reference/resources/effect.html" target="_blank">Effect documentation</a>
 * @see io.digitalbits.sdk.requests.EffectsRequestBuilder
 * @see io.digitalbits.sdk.Server#effects()
 */
public class TrustlineSponsorshipCreatedEffectResponse extends EffectResponse {
  @SerializedName("asset")
  private final String assetString;
  @SerializedName("sponsor")
  protected final String sponsor;

  public TrustlineSponsorshipCreatedEffectResponse(String assetString, String sponsor) {
    this.assetString = assetString;
    this.sponsor = sponsor;
  }

  public String getAssetString() {
    return assetString;
  }

  public Asset getAsset() {
    return Asset.create(assetString);
  }

  public String getSponsor() {
    return sponsor;
  }
}
