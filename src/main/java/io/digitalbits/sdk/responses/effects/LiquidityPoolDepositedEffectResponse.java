package io.digitalbits.sdk.responses.effects;

import io.digitalbits.sdk.AssetAmount;

import com.google.gson.annotations.SerializedName;

/**
 * Represents liquidity_pool_deposited effect response.
 *
 * @see <a href="https://developers.digitalbits.io/api/resources/effects/" target="_blank">Effect documentation</a>
 * @see io.digitalbits.sdk.requests.EffectsRequestBuilder
 * @see io.digitalbits.sdk.Server#effects()
 */
public class LiquidityPoolDepositedEffectResponse extends EffectResponse {
  @SerializedName("liquidity_pool")
  protected final LiquidityPool liquidityPool;
  @SerializedName("reserves_deposited")
  protected final AssetAmount[] reservesDeposited;
  @SerializedName("shares_received")
  protected final String sharesReceived;

  public LiquidityPoolDepositedEffectResponse(LiquidityPool liquidityPool, AssetAmount[] reservesDeposited, String sharesReceived) {
    this.liquidityPool = liquidityPool;
    this.reservesDeposited = reservesDeposited;
    this.sharesReceived = sharesReceived;
  }

  public LiquidityPool getLiquidityPool() {
    return liquidityPool;
  }

  public AssetAmount[] getReservesDeposited() {
    return reservesDeposited;
  }

  public String getSharesReceived() {
    return sharesReceived;
  }
}
