package io.digitalbits.sdk.responses.effects;

import com.google.gson.annotations.SerializedName;
import io.digitalbits.sdk.Asset;
import io.digitalbits.sdk.AssetTypeNative;

import static io.digitalbits.sdk.Asset.create;

abstract class TrustlineCUDResponse extends EffectResponse {
  @SerializedName("limit")
  private String limit;
  @SerializedName("asset_type")
  private String assetType;
  @SerializedName("asset_code")
  private String assetCode;
  @SerializedName("asset_issuer")
  private String assetIssuer;
  @SerializedName("liquidity_pool_id")
  private String liquidityPoolId;

  public String getLimit() {
    return limit;
  }

  public Asset getAsset() {
    if (assetType.equals("native")) {
      return new AssetTypeNative();
    } else {
      return create(assetType, assetCode, assetIssuer, liquidityPoolId);
    }
  }
}
