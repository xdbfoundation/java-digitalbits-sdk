package io.digitalbits.sdk.responses.effects;

import io.digitalbits.sdk.AssetAmount;
import io.digitalbits.sdk.LiquidityPoolID;

import com.google.gson.annotations.SerializedName;

/**
 * Represents liquidity_pool_removed effect response.
 *
 * @see <a href="https://developers.digitalbits.io/api/resources/effects/" target="_blank">Effect documentation</a>
 * @see io.digitalbits.sdk.requests.EffectsRequestBuilder
 * @see io.digitalbits.sdk.Server#effects()
 */
public class LiquidityPoolRemovedEffectResponse extends EffectResponse {
  @SerializedName("liquidity_pool_id")
  protected final LiquidityPoolID liquidityPoolID;

  public LiquidityPoolRemovedEffectResponse(LiquidityPoolID liquidityPoolID) {
    this.liquidityPoolID = liquidityPoolID;
  }

  public LiquidityPoolID getLiquidityPoolID() {
    return liquidityPoolID;
  }
}
