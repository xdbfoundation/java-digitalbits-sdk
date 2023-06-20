package io.digitalbits.sdk.responses.effects;

import com.google.gson.annotations.SerializedName;

/**
 * Represents liquidity_pool_created effect response.
 *
 * @see <a href="https://developers.digitalbits.io/api/resources/effects/" target="_blank">Effect documentation</a>
 * @see io.digitalbits.sdk.requests.EffectsRequestBuilder
 * @see io.digitalbits.sdk.Server#effects()
 */
public class LiquidityPoolCreatedEffectResponse extends EffectResponse {
  @SerializedName("liquidity_pool")
  protected final LiquidityPool liquidityPool;

  public LiquidityPoolCreatedEffectResponse(LiquidityPool liquidityPool) {
    this.liquidityPool = liquidityPool;
  }

  public LiquidityPool getLiquidityPool() {
    return liquidityPool;
  }
}
