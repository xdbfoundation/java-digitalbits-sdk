// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package io.digitalbits.sdk.xdr;


import java.io.IOException;

import com.google.common.base.Objects;

// === xdr source ============================================================

//  struct BumpSequenceOp
//  {
//      SequenceNumber bumpTo;
//  };

//  ===========================================================================
public class BumpSequenceOp implements XdrElement {
  public BumpSequenceOp () {}
  private SequenceNumber bumpTo;
  public SequenceNumber getBumpTo() {
    return this.bumpTo;
  }
  public void setBumpTo(SequenceNumber value) {
    this.bumpTo = value;
  }
  public static void encode(XdrDataOutputStream stream, BumpSequenceOp encodedBumpSequenceOp) throws IOException{
    SequenceNumber.encode(stream, encodedBumpSequenceOp.bumpTo);
  }
  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static BumpSequenceOp decode(XdrDataInputStream stream) throws IOException {
    BumpSequenceOp decodedBumpSequenceOp = new BumpSequenceOp();
    decodedBumpSequenceOp.bumpTo = SequenceNumber.decode(stream);
    return decodedBumpSequenceOp;
  }
  @Override
  public int hashCode() {
    return Objects.hashCode(this.bumpTo);
  }
  @Override
  public boolean equals(Object object) {
    if (!(object instanceof BumpSequenceOp)) {
      return false;
    }

    BumpSequenceOp other = (BumpSequenceOp) object;
    return Objects.equal(this.bumpTo, other.bumpTo);
  }

  public static final class Builder {
    private SequenceNumber bumpTo;

    public Builder bumpTo(SequenceNumber bumpTo) {
      this.bumpTo = bumpTo;
      return this;
    }

    public BumpSequenceOp build() {
      BumpSequenceOp val = new BumpSequenceOp();
      val.setBumpTo(bumpTo);
      return val;
    }
  }
}
