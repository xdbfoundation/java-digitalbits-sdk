package io.digitalbits.sdk.responses.effects;

import com.google.gson.annotations.SerializedName;
import io.digitalbits.sdk.Asset;

/**
 * Represents claimable_balance_claimed effect response.
 * @see <a href="https://developers.digitalbits.io/frontier/reference/resources/effect.html" target="_blank">Effect documentation</a>
 * @see io.digitalbits.sdk.requests.EffectsRequestBuilder
 * @see io.digitalbits.sdk.Server#effects()
 */
public class ClaimableBalanceClaimedEffectResponse extends EffectResponse {
  @SerializedName("asset")
  private final String assetString;
  @SerializedName("amount")
  protected final String amount;
  @SerializedName("balance_id")
  protected final String balanceId;

  public ClaimableBalanceClaimedEffectResponse(String assetString, String amount, String balanceId) {
    this.assetString = assetString;
    this.amount = amount;
    this.balanceId = balanceId;
  }

  public String getAssetString() {
    return assetString;
  }

  public Asset getAsset() {
    return Asset.create(assetString);
  }

  public String getAmount() {
    return amount;
  }

  public String getBalanceId() {
    return balanceId;
  }
}
