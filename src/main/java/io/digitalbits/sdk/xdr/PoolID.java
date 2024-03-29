// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package io.digitalbits.sdk.xdr;


import java.io.IOException;

import com.google.common.base.Objects;

// === xdr source ============================================================

//  typedef Hash PoolID;

//  ===========================================================================
public class PoolID implements XdrElement {
  private Hash PoolID;

  public PoolID() {}

  public PoolID(Hash PoolID) {
    this.PoolID = PoolID;
  }

  public Hash getPoolID() {
    return this.PoolID;
  }

  public void setPoolID(Hash value) {
    this.PoolID = value;
  }

  public static void encode(XdrDataOutputStream stream, PoolID  encodedPoolID) throws IOException {
    Hash.encode(stream, encodedPoolID.PoolID);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static PoolID decode(XdrDataInputStream stream) throws IOException {
    PoolID decodedPoolID = new PoolID();
    decodedPoolID.PoolID = Hash.decode(stream);
    return decodedPoolID;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.PoolID);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof PoolID)) {
      return false;
    }

    PoolID other = (PoolID) object;
    return Objects.equal(this.PoolID, other.PoolID);
  }
}
