// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package io.digitalbits.sdk.xdr;


import java.io.IOException;

import com.google.common.base.Objects;

// === xdr source ============================================================

//  union ChangeTrustResult switch (ChangeTrustResultCode code)
//  {
//  case CHANGE_TRUST_SUCCESS:
//      void;
//  default:
//      void;
//  };

//  ===========================================================================
public class ChangeTrustResult implements XdrElement {
  public ChangeTrustResult () {}
  ChangeTrustResultCode code;
  public ChangeTrustResultCode getDiscriminant() {
    return this.code;
  }
  public void setDiscriminant(ChangeTrustResultCode value) {
    this.code = value;
  }

  public static final class Builder {
    private ChangeTrustResultCode discriminant;

    public Builder discriminant(ChangeTrustResultCode discriminant) {
      this.discriminant = discriminant;
      return this;
    }

    public ChangeTrustResult build() {
      ChangeTrustResult val = new ChangeTrustResult();
      val.setDiscriminant(discriminant);
      return val;
    }
  }

  public static void encode(XdrDataOutputStream stream, ChangeTrustResult encodedChangeTrustResult) throws IOException {
  //Xdrgen::AST::Identifier
  //ChangeTrustResultCode
  stream.writeInt(encodedChangeTrustResult.getDiscriminant().getValue());
  switch (encodedChangeTrustResult.getDiscriminant()) {
  case CHANGE_TRUST_SUCCESS:
  break;
  default:
  break;
  }
  }
  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static ChangeTrustResult decode(XdrDataInputStream stream) throws IOException {
  ChangeTrustResult decodedChangeTrustResult = new ChangeTrustResult();
  ChangeTrustResultCode discriminant = ChangeTrustResultCode.decode(stream);
  decodedChangeTrustResult.setDiscriminant(discriminant);
  switch (decodedChangeTrustResult.getDiscriminant()) {
  case CHANGE_TRUST_SUCCESS:
  break;
  default:
  break;
  }
    return decodedChangeTrustResult;
  }
  @Override
  public int hashCode() {
    return Objects.hashCode(this.code);
  }
  @Override
  public boolean equals(Object object) {
    if (!(object instanceof ChangeTrustResult)) {
      return false;
    }

    ChangeTrustResult other = (ChangeTrustResult) object;
    return Objects.equal(this.code, other.code);
  }
}
