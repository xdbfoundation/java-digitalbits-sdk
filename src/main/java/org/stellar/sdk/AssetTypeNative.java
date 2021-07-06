package io.digitalbits.sdk;

import io.digitalbits.sdk.xdr.AssetType;

/**
 * Represents DigitalBits native asset - <a href="https://developers.digitalbits.io/guides/concepts/assets.html" target="_blank">lumens (XLM)</a>
 * @see <a href="https://developers.digitalbits.io/guides/concepts/assets.html" target="_blank">Assets</a>
 */
public final class AssetTypeNative extends Asset {

  public AssetTypeNative() {}

  @Override
  public String toString() {
    return "native";
  }

  @Override
  public String getType() {
    return "native";
  }

  @Override
  public boolean equals(Object object) {
    if (object != null) {
      return this.getClass().equals(object.getClass());
    } else {
      return false;
    }
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public io.digitalbits.sdk.xdr.Asset toXdr() {
    io.digitalbits.sdk.xdr.Asset xdr = new io.digitalbits.sdk.xdr.Asset();
    xdr.setDiscriminant(AssetType.ASSET_TYPE_NATIVE);
    return xdr;
  }
}
