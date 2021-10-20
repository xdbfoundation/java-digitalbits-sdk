// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package io.digitalbits.sdk.xdr;


import java.io.IOException;

import com.google.common.base.Objects;
import java.util.Arrays;

// === xdr source ============================================================

//  struct CreateClaimableBalanceOp
//  {
//      Asset asset;
//      int64 amount;
//      Claimant claimants<10>;
//  };

//  ===========================================================================
public class CreateClaimableBalanceOp implements XdrElement {
  public CreateClaimableBalanceOp () {}
  private Asset asset;
  public Asset getAsset() {
    return this.asset;
  }
  public void setAsset(Asset value) {
    this.asset = value;
  }
  private Int64 amount;
  public Int64 getAmount() {
    return this.amount;
  }
  public void setAmount(Int64 value) {
    this.amount = value;
  }
  private Claimant[] claimants;
  public Claimant[] getClaimants() {
    return this.claimants;
  }
  public void setClaimants(Claimant[] value) {
    this.claimants = value;
  }
  public static void encode(XdrDataOutputStream stream, CreateClaimableBalanceOp encodedCreateClaimableBalanceOp) throws IOException{
    Asset.encode(stream, encodedCreateClaimableBalanceOp.asset);
    Int64.encode(stream, encodedCreateClaimableBalanceOp.amount);
    int claimantssize = encodedCreateClaimableBalanceOp.getClaimants().length;
    stream.writeInt(claimantssize);
    for (int i = 0; i < claimantssize; i++) {
      Claimant.encode(stream, encodedCreateClaimableBalanceOp.claimants[i]);
    }
  }
  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static CreateClaimableBalanceOp decode(XdrDataInputStream stream) throws IOException {
    CreateClaimableBalanceOp decodedCreateClaimableBalanceOp = new CreateClaimableBalanceOp();
    decodedCreateClaimableBalanceOp.asset = Asset.decode(stream);
    decodedCreateClaimableBalanceOp.amount = Int64.decode(stream);
    int claimantssize = stream.readInt();
    decodedCreateClaimableBalanceOp.claimants = new Claimant[claimantssize];
    for (int i = 0; i < claimantssize; i++) {
      decodedCreateClaimableBalanceOp.claimants[i] = Claimant.decode(stream);
    }
    return decodedCreateClaimableBalanceOp;
  }
  @Override
  public int hashCode() {
    return Objects.hashCode(this.asset, this.amount, Arrays.hashCode(this.claimants));
  }
  @Override
  public boolean equals(Object object) {
    if (!(object instanceof CreateClaimableBalanceOp)) {
      return false;
    }

    CreateClaimableBalanceOp other = (CreateClaimableBalanceOp) object;
    return Objects.equal(this.asset, other.asset) && Objects.equal(this.amount, other.amount) && Arrays.equals(this.claimants, other.claimants);
  }

  public static final class Builder {
    private Asset asset;
    private Int64 amount;
    private Claimant[] claimants;

    public Builder asset(Asset asset) {
      this.asset = asset;
      return this;
    }

    public Builder amount(Int64 amount) {
      this.amount = amount;
      return this;
    }

    public Builder claimants(Claimant[] claimants) {
      this.claimants = claimants;
      return this;
    }

    public CreateClaimableBalanceOp build() {
      CreateClaimableBalanceOp val = new CreateClaimableBalanceOp();
      val.setAsset(asset);
      val.setAmount(amount);
      val.setClaimants(claimants);
      return val;
    }
  }
}
