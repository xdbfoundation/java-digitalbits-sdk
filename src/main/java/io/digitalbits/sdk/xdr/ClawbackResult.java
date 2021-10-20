// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package io.digitalbits.sdk.xdr;


import java.io.IOException;

import com.google.common.base.Objects;

// === xdr source ============================================================

//  union ClawbackResult switch (ClawbackResultCode code)
//  {
//  case CLAWBACK_SUCCESS:
//      void;
//  default:
//      void;
//  };

//  ===========================================================================
public class ClawbackResult implements XdrElement {
  public ClawbackResult () {}
  ClawbackResultCode code;
  public ClawbackResultCode getDiscriminant() {
    return this.code;
  }
  public void setDiscriminant(ClawbackResultCode value) {
    this.code = value;
  }

  public static final class Builder {
    private ClawbackResultCode discriminant;

    public Builder discriminant(ClawbackResultCode discriminant) {
      this.discriminant = discriminant;
      return this;
    }

    public ClawbackResult build() {
      ClawbackResult val = new ClawbackResult();
      val.setDiscriminant(discriminant);
      return val;
    }
  }

  public static void encode(XdrDataOutputStream stream, ClawbackResult encodedClawbackResult) throws IOException {
  //Xdrgen::AST::Identifier
  //ClawbackResultCode
  stream.writeInt(encodedClawbackResult.getDiscriminant().getValue());
  switch (encodedClawbackResult.getDiscriminant()) {
  case CLAWBACK_SUCCESS:
  break;
  default:
  break;
  }
  }
  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static ClawbackResult decode(XdrDataInputStream stream) throws IOException {
  ClawbackResult decodedClawbackResult = new ClawbackResult();
  ClawbackResultCode discriminant = ClawbackResultCode.decode(stream);
  decodedClawbackResult.setDiscriminant(discriminant);
  switch (decodedClawbackResult.getDiscriminant()) {
  case CLAWBACK_SUCCESS:
  break;
  default:
  break;
  }
    return decodedClawbackResult;
  }
  @Override
  public int hashCode() {
    return Objects.hashCode(this.code);
  }
  @Override
  public boolean equals(Object object) {
    if (!(object instanceof ClawbackResult)) {
      return false;
    }

    ClawbackResult other = (ClawbackResult) object;
    return Objects.equal(this.code, other.code);
  }
}
