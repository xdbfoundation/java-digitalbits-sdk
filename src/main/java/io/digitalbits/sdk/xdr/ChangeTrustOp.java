// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package io.digitalbits.sdk.xdr;


import java.io.IOException;

import com.google.common.base.Objects;

// === xdr source ============================================================

//  struct ChangeTrustOp
//  {
//      ChangeTrustAsset line;
//  
//      // if limit is set to 0, deletes the trust line
//      int64 limit;
//  };

//  ===========================================================================
public class ChangeTrustOp implements XdrElement {
  public ChangeTrustOp () {}
  private ChangeTrustAsset line;
  public ChangeTrustAsset getLine() {
    return this.line;
  }
  public void setLine(ChangeTrustAsset value) {
    this.line = value;
  }
  private Int64 limit;
  public Int64 getLimit() {
    return this.limit;
  }
  public void setLimit(Int64 value) {
    this.limit = value;
  }
  public static void encode(XdrDataOutputStream stream, ChangeTrustOp encodedChangeTrustOp) throws IOException{
    ChangeTrustAsset.encode(stream, encodedChangeTrustOp.line);
    Int64.encode(stream, encodedChangeTrustOp.limit);
  }
  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static ChangeTrustOp decode(XdrDataInputStream stream) throws IOException {
    ChangeTrustOp decodedChangeTrustOp = new ChangeTrustOp();
    decodedChangeTrustOp.line = ChangeTrustAsset.decode(stream);
    decodedChangeTrustOp.limit = Int64.decode(stream);
    return decodedChangeTrustOp;
  }
  @Override
  public int hashCode() {
    return Objects.hashCode(this.line, this.limit);
  }
  @Override
  public boolean equals(Object object) {
    if (!(object instanceof ChangeTrustOp)) {
      return false;
    }

    ChangeTrustOp other = (ChangeTrustOp) object;
    return Objects.equal(this.line, other.line) && Objects.equal(this.limit, other.limit);
  }

  public static final class Builder {
    private ChangeTrustAsset line;
    private Int64 limit;

    public Builder line(ChangeTrustAsset line) {
      this.line = line;
      return this;
    }

    public Builder limit(Int64 limit) {
      this.limit = limit;
      return this;
    }

    public ChangeTrustOp build() {
      ChangeTrustOp val = new ChangeTrustOp();
      val.setLine(line);
      val.setLimit(limit);
      return val;
    }
  }
}
