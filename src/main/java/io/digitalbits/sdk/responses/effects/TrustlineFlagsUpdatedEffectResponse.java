package io.digitalbits.sdk.responses.effects;

import com.google.gson.annotations.SerializedName;
import io.digitalbits.sdk.Asset;

import static io.digitalbits.sdk.Asset.create;

/**
 * Represents trustline_flags_updated effect response.
 *
 * @see <a href="https://developers.digitalbits.io/frontier/reference/resources/effect.html" target="_blank">Effect documentation</a>
 * @see io.digitalbits.sdk.requests.EffectsRequestBuilder
 * @see io.digitalbits.sdk.Server#effects()
 */
public class TrustlineFlagsUpdatedEffectResponse extends EffectResponse {
  @SerializedName("trustor")
  protected final String trustor;

  @SerializedName("asset_type")
  protected final String assetType;
  @SerializedName("asset_code")
  protected final String assetCode;
  @SerializedName("asset_issuer")
  protected final String assetIssuer;

  @SerializedName("authorized_flag")
  protected final boolean authorized;
  @SerializedName("authorized_to_maintain_liabilites_flag")
  protected final boolean authorizedToMaintainLiabilities;
  @SerializedName("clawback_enabled_flag")
  protected final boolean clawbackEnabled;

  public TrustlineFlagsUpdatedEffectResponse(String trustor, String assetType, String assetCode, String assetIssuer, boolean authorized, boolean authorizedToMaintainLiabilities, boolean clawbackEnabled) {
    this.assetCode = assetCode;
    this.assetIssuer = assetIssuer;
    this.assetType = assetType;
    this.trustor = trustor;
    this.authorized = authorized;
    this.authorizedToMaintainLiabilities = authorizedToMaintainLiabilities;
    this.clawbackEnabled = clawbackEnabled;
  }

  public String getTrustor() {
    return trustor;
  }

  public String getAssetType() {
    return assetType;
  }
  public String getAssetIssuer() {
    return assetIssuer;
  }


  public String getAssetCode() {
    return assetCode;
  }

  public Asset getAsset() {
    return create(assetType, assetCode, assetIssuer);
  }

  public boolean getAuthorized() {
    return authorized;
  }

  public boolean getAuthorizedToMaintainLiabilities() {
    return authorizedToMaintainLiabilities;
  }

  public boolean getClawbackEnabled() {
    return clawbackEnabled;
  }
}
