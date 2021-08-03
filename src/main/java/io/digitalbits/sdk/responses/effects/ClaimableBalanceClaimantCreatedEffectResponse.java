package io.digitalbits.sdk.responses.effects;

import com.google.gson.annotations.SerializedName;
import io.digitalbits.sdk.Asset;
import io.digitalbits.sdk.Predicate;

/**
 * Represents claimable_balance_claimant_created effect response.
 * @see <a href="https://developers.digitalbits.io/frontier/reference/resources/effect.html" target="_blank">Effect documentation</a>
 * @see io.digitalbits.sdk.requests.EffectsRequestBuilder
 * @see io.digitalbits.sdk.Server#effects()
 */
public class ClaimableBalanceClaimantCreatedEffectResponse extends EffectResponse {
  @SerializedName("asset")
  private final String assetString;
  @SerializedName("amount")
  protected final String amount;
  @SerializedName("balance_id")
  protected final String balanceId;
  @SerializedName("predicate")
  protected final Predicate predicate;

  public ClaimableBalanceClaimantCreatedEffectResponse(String assetString, String amount, String balanceId, Predicate predicate) {
    this.assetString = assetString;
    this.amount = amount;
    this.balanceId = balanceId;
    this.predicate = predicate;
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

  public Predicate getPredicate() {
    return predicate;
  }
}
