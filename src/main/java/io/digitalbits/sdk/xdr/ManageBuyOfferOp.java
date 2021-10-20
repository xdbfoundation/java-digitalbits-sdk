// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package io.digitalbits.sdk.xdr;


import java.io.IOException;

import com.google.common.base.Objects;

// === xdr source ============================================================

//  struct ManageBuyOfferOp
//  {
//      Asset selling;
//      Asset buying;
//      int64 buyAmount; // amount being bought. if set to 0, delete the offer
//      Price price;     // price of thing being bought in terms of what you are
//                       // selling
//  
//      // 0=create a new offer, otherwise edit an existing offer
//      int64 offerID;
//  };

//  ===========================================================================
public class ManageBuyOfferOp implements XdrElement {
  public ManageBuyOfferOp () {}
  private Asset selling;
  public Asset getSelling() {
    return this.selling;
  }
  public void setSelling(Asset value) {
    this.selling = value;
  }
  private Asset buying;
  public Asset getBuying() {
    return this.buying;
  }
  public void setBuying(Asset value) {
    this.buying = value;
  }
  private Int64 buyAmount;
  public Int64 getBuyAmount() {
    return this.buyAmount;
  }
  public void setBuyAmount(Int64 value) {
    this.buyAmount = value;
  }
  private Price price;
  public Price getPrice() {
    return this.price;
  }
  public void setPrice(Price value) {
    this.price = value;
  }
  private Int64 offerID;
  public Int64 getOfferID() {
    return this.offerID;
  }
  public void setOfferID(Int64 value) {
    this.offerID = value;
  }
  public static void encode(XdrDataOutputStream stream, ManageBuyOfferOp encodedManageBuyOfferOp) throws IOException{
    Asset.encode(stream, encodedManageBuyOfferOp.selling);
    Asset.encode(stream, encodedManageBuyOfferOp.buying);
    Int64.encode(stream, encodedManageBuyOfferOp.buyAmount);
    Price.encode(stream, encodedManageBuyOfferOp.price);
    Int64.encode(stream, encodedManageBuyOfferOp.offerID);
  }
  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static ManageBuyOfferOp decode(XdrDataInputStream stream) throws IOException {
    ManageBuyOfferOp decodedManageBuyOfferOp = new ManageBuyOfferOp();
    decodedManageBuyOfferOp.selling = Asset.decode(stream);
    decodedManageBuyOfferOp.buying = Asset.decode(stream);
    decodedManageBuyOfferOp.buyAmount = Int64.decode(stream);
    decodedManageBuyOfferOp.price = Price.decode(stream);
    decodedManageBuyOfferOp.offerID = Int64.decode(stream);
    return decodedManageBuyOfferOp;
  }
  @Override
  public int hashCode() {
    return Objects.hashCode(this.selling, this.buying, this.buyAmount, this.price, this.offerID);
  }
  @Override
  public boolean equals(Object object) {
    if (!(object instanceof ManageBuyOfferOp)) {
      return false;
    }

    ManageBuyOfferOp other = (ManageBuyOfferOp) object;
    return Objects.equal(this.selling, other.selling) && Objects.equal(this.buying, other.buying) && Objects.equal(this.buyAmount, other.buyAmount) && Objects.equal(this.price, other.price) && Objects.equal(this.offerID, other.offerID);
  }

  public static final class Builder {
    private Asset selling;
    private Asset buying;
    private Int64 buyAmount;
    private Price price;
    private Int64 offerID;

    public Builder selling(Asset selling) {
      this.selling = selling;
      return this;
    }

    public Builder buying(Asset buying) {
      this.buying = buying;
      return this;
    }

    public Builder buyAmount(Int64 buyAmount) {
      this.buyAmount = buyAmount;
      return this;
    }

    public Builder price(Price price) {
      this.price = price;
      return this;
    }

    public Builder offerID(Int64 offerID) {
      this.offerID = offerID;
      return this;
    }

    public ManageBuyOfferOp build() {
      ManageBuyOfferOp val = new ManageBuyOfferOp();
      val.setSelling(selling);
      val.setBuying(buying);
      val.setBuyAmount(buyAmount);
      val.setPrice(price);
      val.setOfferID(offerID);
      return val;
    }
  }
}
