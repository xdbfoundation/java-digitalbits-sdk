package io.digitalbits.sdk.responses.operations;

import com.google.common.base.Optional;
import com.google.gson.annotations.SerializedName;

import io.digitalbits.sdk.Asset;
import io.digitalbits.sdk.AssetTypeNative;
import io.digitalbits.sdk.responses.MuxedAccount;

/**
 * @deprecated As of release 0.24.0, replaced by {@link SetTrustLineFlagsOperationResponse}
 *
 * Represents AllowTrust operation response.
 * @see <a href="https://developers.digitalbits.io/frontier/reference/resources/operation.html" target="_blank">Operation documentation</a>
 * @see io.digitalbits.sdk.requests.OperationsRequestBuilder
 * @see io.digitalbits.sdk.Server#operations()
 */
public class AllowTrustOperationResponse extends OperationResponse {
  @SerializedName("trustor")
  private String trustor;
  @SerializedName("trustee")
  private String trustee;
  @SerializedName("trustee_muxed")
  private String trusteeMuxed;
  @SerializedName("trustee_muxed_id")
  private Long trusteeMuxedId;
  @SerializedName("asset_type")
  private String assetType;
  @SerializedName("asset_code")
  private String assetCode;
  @SerializedName("asset_issuer")
  private String assetIssuer;
  @SerializedName("authorize")
  private boolean authorize;
  @SerializedName("authorize_to_maintain_liabilities")
  private boolean authorizeToMaintainLiabilities;
  
  public String getTrustor() {
    return trustor;
  }

  public Optional<MuxedAccount> getTrusteeMuxed() {
    if (this.trusteeMuxed == null || this.trusteeMuxed.isEmpty()) {
      return Optional.absent();
    }
    return Optional.of(new MuxedAccount(this.trusteeMuxed, this.trustee, this.trusteeMuxedId));
  }

  public String getTrustee() {
    return trustee;
  }

  public boolean isAuthorize() {
    return authorize;
  }

  public boolean isAuthorizedToMaintainLiabilities() {
    return authorizeToMaintainLiabilities;
  }


  public Asset getAsset() {
    if (assetType.equals("native")) {
      return new AssetTypeNative();
    } else {
      return Asset.createNonNativeAsset(assetCode, assetIssuer);
    }
  }
}
