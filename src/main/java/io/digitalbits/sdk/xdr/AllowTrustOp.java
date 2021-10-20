// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package io.digitalbits.sdk.xdr;


import java.io.IOException;

import com.google.common.base.Objects;

// === xdr source ============================================================

//  struct AllowTrustOp
//  {
//      AccountID trustor;
//      AssetCode asset;
//  
//      // 0, or any bitwise combination of the AUTHORIZED_* flags of TrustLineFlags
//      uint32 authorize;
//  };

//  ===========================================================================
public class AllowTrustOp implements XdrElement {
  public AllowTrustOp () {}
  private AccountID trustor;
  public AccountID getTrustor() {
    return this.trustor;
  }
  public void setTrustor(AccountID value) {
    this.trustor = value;
  }
  private AssetCode asset;
  public AssetCode getAsset() {
    return this.asset;
  }
  public void setAsset(AssetCode value) {
    this.asset = value;
  }
  private Uint32 authorize;
  public Uint32 getAuthorize() {
    return this.authorize;
  }
  public void setAuthorize(Uint32 value) {
    this.authorize = value;
  }
  public static void encode(XdrDataOutputStream stream, AllowTrustOp encodedAllowTrustOp) throws IOException{
    AccountID.encode(stream, encodedAllowTrustOp.trustor);
    AssetCode.encode(stream, encodedAllowTrustOp.asset);
    Uint32.encode(stream, encodedAllowTrustOp.authorize);
  }
  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static AllowTrustOp decode(XdrDataInputStream stream) throws IOException {
    AllowTrustOp decodedAllowTrustOp = new AllowTrustOp();
    decodedAllowTrustOp.trustor = AccountID.decode(stream);
    decodedAllowTrustOp.asset = AssetCode.decode(stream);
    decodedAllowTrustOp.authorize = Uint32.decode(stream);
    return decodedAllowTrustOp;
  }
  @Override
  public int hashCode() {
    return Objects.hashCode(this.trustor, this.asset, this.authorize);
  }
  @Override
  public boolean equals(Object object) {
    if (!(object instanceof AllowTrustOp)) {
      return false;
    }

    AllowTrustOp other = (AllowTrustOp) object;
    return Objects.equal(this.trustor, other.trustor) && Objects.equal(this.asset, other.asset) && Objects.equal(this.authorize, other.authorize);
  }

  public static final class Builder {
    private AccountID trustor;
    private AssetCode asset;
    private Uint32 authorize;

    public Builder trustor(AccountID trustor) {
      this.trustor = trustor;
      return this;
    }

    public Builder asset(AssetCode asset) {
      this.asset = asset;
      return this;
    }

    public Builder authorize(Uint32 authorize) {
      this.authorize = authorize;
      return this;
    }

    public AllowTrustOp build() {
      AllowTrustOp val = new AllowTrustOp();
      val.setTrustor(trustor);
      val.setAsset(asset);
      val.setAuthorize(authorize);
      return val;
    }
  }
}
