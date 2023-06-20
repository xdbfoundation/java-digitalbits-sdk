package io.digitalbits.sdk.responses.effects;

import io.digitalbits.sdk.AssetAmount;

import com.google.gson.annotations.SerializedName;

/**
 * Represents liquidity_pool_trade effect response.
 *
 * @see <a href="https://developers.digitalbits.io/api/resources/effects/" target="_blank">Effect documentation</a>
 * @see io.digitalbits.sdk.requests.EffectsRequestBuilder
 * @see io.digitalbits.sdk.Server#effects()
 */
public class LiquidityPoolTradeEffectResponse extends EffectResponse {
  @SerializedName("liquidity_pool")
  protected final LiquidityPool liquidityPool;
  @SerializedName("sold")
  protected final AssetAmount sold;
  @SerializedName("bought")
  protected final AssetAmount bought;

  public LiquidityPoolTradeEffectResponse(LiquidityPool liquidityPool, AssetAmount sold, AssetAmount bought) {
    this.liquidityPool = liquidityPool;
    this.sold = sold;
    this.bought = bought;
  }

  public LiquidityPool getLiquidityPool() {
    return liquidityPool;
  }

  public AssetAmount getSold() {
    return sold;
  }

  public AssetAmount getBought() {
    return bought;
  }
}
