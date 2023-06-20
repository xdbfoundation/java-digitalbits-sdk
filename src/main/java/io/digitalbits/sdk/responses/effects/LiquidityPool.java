package io.digitalbits.sdk.responses.effects;

import io.digitalbits.sdk.AssetAmount;
import io.digitalbits.sdk.LiquidityPoolID;

import com.google.gson.annotations.SerializedName;
import io.digitalbits.sdk.xdr.LiquidityPoolType;

public class LiquidityPool {
  @SerializedName("id")
  protected final LiquidityPoolID id;
  @SerializedName("fee_bp")
  protected final Integer feeBP;
  @SerializedName("type")
  protected final LiquidityPoolType type;
  @SerializedName("total_trustlines")
  protected final Long totalTrustlines;
  @SerializedName("total_shares")
  protected final String totalShares;
  @SerializedName("reserves")
  protected final AssetAmount[] reserves;

  public LiquidityPool(LiquidityPoolID id, Integer feeBP, LiquidityPoolType type, Long totalTrustlines, String totalShares, AssetAmount[] reserves) {
    this.id = id;
    this.feeBP = feeBP;
    this.type = type;
    this.totalTrustlines = totalTrustlines;
    this.totalShares = totalShares;
    this.reserves = reserves;
  }

  public LiquidityPoolID getID() {
    return id;
  }

  public Integer getFeeBP() {
    return feeBP;
  }

  public LiquidityPoolType getType() {
    return type;
  }

  public Long getTotalTrustlines() {
    return totalTrustlines;
  }

  public String getTotalShares() {
    return totalShares;
  }

  public AssetAmount[] getReserves() {
    return reserves;
  }
}
