package io.digitalbits.sdk;

import com.google.common.base.Objects;
import io.digitalbits.sdk.xdr.AssetType;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Class for LiquidityPoolShareTrustLineAsset
 * @see <a href="https://developers.digitalbits.io/docs/glossary/liquidity-pool/" target="_blank">Liquidity Pool</a>
 */
public final class LiquidityPoolShareTrustLineAsset extends TrustLineAsset {
  protected final LiquidityPoolID mId;

  /**
   * Constructor
   *
   * @param params the LiquidityPoolParameters
   */
  public LiquidityPoolShareTrustLineAsset(LiquidityPoolParameters params) {
    checkNotNull(params, "params cannot be null");
    mId = params.getId();
  }

  /**
   * Constructor
   *
   * @param id the LiquidityPoolID
   */
  public LiquidityPoolShareTrustLineAsset(LiquidityPoolID id) {
    checkNotNull(id, "id cannot be null");
    mId = id;
  }

  /**
   * Get the liquidity pool id
   *
   * @return LiquidityPoolID
   */
  public LiquidityPoolID getLiquidityPoolID() {
    return mId;
  }

  @Override
  public String getType() {
    return "pool_share";
  }

  @Override
  public String toString() {
    return this.getLiquidityPoolID().toString();
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.mId);
  }

  @Override
  public boolean equals(Object object) {
    if (object == null || !this.getClass().equals(object.getClass())) {
        return false;
    }

    LiquidityPoolShareTrustLineAsset o = (LiquidityPoolShareTrustLineAsset) object;

    return this.toString() == o.toString();
  }

  @Override
  public int compareTo(TrustLineAsset other) {
    if (other.getType() != "pool_share") {
      return 1;
    }
    return this.toString().compareTo(((LiquidityPoolShareTrustLineAsset) other).toString());
  }

  @Override
  public io.digitalbits.sdk.xdr.TrustLineAsset toXdr() {
    io.digitalbits.sdk.xdr.TrustLineAsset xdr = new io.digitalbits.sdk.xdr.TrustLineAsset();
    xdr.setDiscriminant(AssetType.ASSET_TYPE_POOL_SHARE);
    xdr.setLiquidityPoolID(mId.toXdr());
    return xdr;
  }
}
