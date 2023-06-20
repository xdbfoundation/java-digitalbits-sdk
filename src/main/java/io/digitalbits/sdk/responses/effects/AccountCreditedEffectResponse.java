package io.digitalbits.sdk.responses.effects;

import com.google.gson.annotations.SerializedName;
import io.digitalbits.sdk.Asset;

import static io.digitalbits.sdk.Asset.create;


/**
 * Represents account_credited effect response.
 * @see <a href="https://developers.digitalbits.io/frontier/reference/resources/effect.html" target="_blank">Effect documentation</a>
 * @see io.digitalbits.sdk.requests.EffectsRequestBuilder
 * @see io.digitalbits.sdk.Server#effects()
 */
public class AccountCreditedEffectResponse extends EffectResponse {
  @SerializedName("amount")
  protected final String amount;
  @SerializedName("asset_type")
  protected final String assetType;
  @SerializedName("asset_code")
  protected final String assetCode;
  @SerializedName("asset_issuer")
  protected final String assetIssuer;

  AccountCreditedEffectResponse(String amount, String assetType, String assetCode, String assetIssuer) {
    this.amount = amount;
    this.assetType = assetType;
    this.assetCode = assetCode;
    this.assetIssuer = assetIssuer;
  }

  public String getAmount() {
    return amount;
  }

  public Asset getAsset() {
      return create(assetType, assetCode, assetIssuer);
  }
}
