// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package io.digitalbits.sdk.xdr;


import java.io.IOException;

import com.google.common.base.Objects;

// === xdr source ============================================================

//  union BumpSequenceResult switch (BumpSequenceResultCode code)
//  {
//  case BUMP_SEQUENCE_SUCCESS:
//      void;
//  default:
//      void;
//  };

//  ===========================================================================
public class BumpSequenceResult implements XdrElement {
  public BumpSequenceResult () {}
  BumpSequenceResultCode code;
  public BumpSequenceResultCode getDiscriminant() {
    return this.code;
  }
  public void setDiscriminant(BumpSequenceResultCode value) {
    this.code = value;
  }

  public static final class Builder {
    private BumpSequenceResultCode discriminant;

    public Builder discriminant(BumpSequenceResultCode discriminant) {
      this.discriminant = discriminant;
      return this;
    }

    public BumpSequenceResult build() {
      BumpSequenceResult val = new BumpSequenceResult();
      val.setDiscriminant(discriminant);
      return val;
    }
  }

  public static void encode(XdrDataOutputStream stream, BumpSequenceResult encodedBumpSequenceResult) throws IOException {
  //Xdrgen::AST::Identifier
  //BumpSequenceResultCode
  stream.writeInt(encodedBumpSequenceResult.getDiscriminant().getValue());
  switch (encodedBumpSequenceResult.getDiscriminant()) {
  case BUMP_SEQUENCE_SUCCESS:
  break;
  default:
  break;
  }
  }
  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static BumpSequenceResult decode(XdrDataInputStream stream) throws IOException {
  BumpSequenceResult decodedBumpSequenceResult = new BumpSequenceResult();
  BumpSequenceResultCode discriminant = BumpSequenceResultCode.decode(stream);
  decodedBumpSequenceResult.setDiscriminant(discriminant);
  switch (decodedBumpSequenceResult.getDiscriminant()) {
  case BUMP_SEQUENCE_SUCCESS:
  break;
  default:
  break;
  }
    return decodedBumpSequenceResult;
  }
  @Override
  public int hashCode() {
    return Objects.hashCode(this.code);
  }
  @Override
  public boolean equals(Object object) {
    if (!(object instanceof BumpSequenceResult)) {
      return false;
    }

    BumpSequenceResult other = (BumpSequenceResult) object;
    return Objects.equal(this.code, other.code);
  }
}
