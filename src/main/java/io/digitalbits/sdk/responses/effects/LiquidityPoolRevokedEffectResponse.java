package io.digitalbits.sdk.responses.effects;

import io.digitalbits.sdk.Asset;

import com.google.gson.annotations.SerializedName;

/**
 * Represents liquidity_pool_revoked effect response.
 *
 * @see <a href="https://developers.digitalbits.io/api/resources/effects/" target="_blank">Effect documentation</a>
 * @see io.digitalbits.sdk.requests.EffectsRequestBuilder
 * @see io.digitalbits.sdk.Server#effects()
 */
public class LiquidityPoolRevokedEffectResponse extends EffectResponse {
  @SerializedName("liquidity_pool")
  protected final LiquidityPool liquidityPool;
  @SerializedName("reserves_revoked")
  protected final LiquidityPoolClaimableAssetAmount reservesRevoked;
  @SerializedName("shares_revoked")
  protected final String sharesRevoked;

  public LiquidityPoolRevokedEffectResponse(LiquidityPool liquidityPool, LiquidityPoolClaimableAssetAmount reservesRevoked, String sharesRevoked) {
    this.liquidityPool = liquidityPool;
    this.reservesRevoked = reservesRevoked;
    this.sharesRevoked = sharesRevoked;
  }

  public LiquidityPool getLiquidityPool() {
    return liquidityPool;
  }

  public LiquidityPoolClaimableAssetAmount getReservesRevoked() {
    return reservesRevoked;
  }

  public String getSharesRevoked() {
    return sharesRevoked;
  }
}
