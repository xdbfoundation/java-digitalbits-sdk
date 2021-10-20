package io.digitalbits.sdk.responses.operations;

import com.google.common.base.Optional;
import com.google.gson.annotations.SerializedName;

import io.digitalbits.sdk.Asset;
import io.digitalbits.sdk.AssetTypeNative;
import io.digitalbits.sdk.responses.MuxedAccount;

/**
 * Represents ChangeTrust operation response.
 * @see <a href="https://developers.digitalbits.io/frontier/reference/resources/operation.html" target="_blank">Operation documentation</a>
 * @see io.digitalbits.sdk.requests.OperationsRequestBuilder
 * @see io.digitalbits.sdk.Server#operations()
 */
public class ChangeTrustOperationResponse extends OperationResponse {
  @SerializedName("trustor")
  private String trustor;
  @SerializedName("trustor_muxed")
  private String trustorMuxed;
  @SerializedName("trustor_muxed_id")
  private Long trustorMuxedId;
  @SerializedName("trustee")
  private String trustee;
  @SerializedName("asset_type")
  private String assetType;
  @SerializedName("asset_code")
  private String assetCode;
  @SerializedName("asset_issuer")
  private String assetIssuer;
  @SerializedName("limit")
  private String limit;

  public Optional<MuxedAccount> getTrustorMuxed() {
    if (this.trustorMuxed == null || this.trustorMuxed.isEmpty()) {
      return Optional.absent();
    }
    return Optional.of(new MuxedAccount(this.trustorMuxed, this.trustor, this.trustorMuxedId));
  }

  public String getTrustor() {
    return trustor;
  }

  public String getTrustee() {
    return trustee;
  }

  public String getLimit() {
    return limit;
  }

  public Asset getAsset() {
    if (assetType.equals("native")) {
      return new AssetTypeNative();
    } else {
      return Asset.createNonNativeAsset(assetCode, assetIssuer);
    }
  }
}
