// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package io.digitalbits.sdk.xdr;


import java.io.IOException;

import com.google.common.base.Objects;

// === xdr source ============================================================

//  union ClaimAtom switch (ClaimAtomType type)
//  {
//  case CLAIM_ATOM_TYPE_V0:
//      ClaimOfferAtomV0 v0;
//  case CLAIM_ATOM_TYPE_ORDER_BOOK:
//      ClaimOfferAtom orderBook;
//  case CLAIM_ATOM_TYPE_LIQUIDITY_POOL:
//      ClaimLiquidityAtom liquidityPool;
//  };

//  ===========================================================================
public class ClaimAtom implements XdrElement {
  public ClaimAtom () {}
  ClaimAtomType type;
  public ClaimAtomType getDiscriminant() {
    return this.type;
  }
  public void setDiscriminant(ClaimAtomType value) {
    this.type = value;
  }
  private ClaimOfferAtomV0 v0;
  public ClaimOfferAtomV0 getV0() {
    return this.v0;
  }
  public void setV0(ClaimOfferAtomV0 value) {
    this.v0 = value;
  }
  private ClaimOfferAtom orderBook;
  public ClaimOfferAtom getOrderBook() {
    return this.orderBook;
  }
  public void setOrderBook(ClaimOfferAtom value) {
    this.orderBook = value;
  }
  private ClaimLiquidityAtom liquidityPool;
  public ClaimLiquidityAtom getLiquidityPool() {
    return this.liquidityPool;
  }
  public void setLiquidityPool(ClaimLiquidityAtom value) {
    this.liquidityPool = value;
  }

  public static final class Builder {
    private ClaimAtomType discriminant;
    private ClaimOfferAtomV0 v0;
    private ClaimOfferAtom orderBook;
    private ClaimLiquidityAtom liquidityPool;

    public Builder discriminant(ClaimAtomType discriminant) {
      this.discriminant = discriminant;
      return this;
    }

    public Builder v0(ClaimOfferAtomV0 v0) {
      this.v0 = v0;
      return this;
    }

    public Builder orderBook(ClaimOfferAtom orderBook) {
      this.orderBook = orderBook;
      return this;
    }

    public Builder liquidityPool(ClaimLiquidityAtom liquidityPool) {
      this.liquidityPool = liquidityPool;
      return this;
    }

    public ClaimAtom build() {
      ClaimAtom val = new ClaimAtom();
      val.setDiscriminant(discriminant);
      val.setV0(v0);
      val.setOrderBook(orderBook);
      val.setLiquidityPool(liquidityPool);
      return val;
    }
  }

  public static void encode(XdrDataOutputStream stream, ClaimAtom encodedClaimAtom) throws IOException {
  //Xdrgen::AST::Identifier
  //ClaimAtomType
  stream.writeInt(encodedClaimAtom.getDiscriminant().getValue());
  switch (encodedClaimAtom.getDiscriminant()) {
  case CLAIM_ATOM_TYPE_V0:
  ClaimOfferAtomV0.encode(stream, encodedClaimAtom.v0);
  break;
  case CLAIM_ATOM_TYPE_ORDER_BOOK:
  ClaimOfferAtom.encode(stream, encodedClaimAtom.orderBook);
  break;
  case CLAIM_ATOM_TYPE_LIQUIDITY_POOL:
  ClaimLiquidityAtom.encode(stream, encodedClaimAtom.liquidityPool);
  break;
  }
  }
  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static ClaimAtom decode(XdrDataInputStream stream) throws IOException {
  ClaimAtom decodedClaimAtom = new ClaimAtom();
  ClaimAtomType discriminant = ClaimAtomType.decode(stream);
  decodedClaimAtom.setDiscriminant(discriminant);
  switch (decodedClaimAtom.getDiscriminant()) {
  case CLAIM_ATOM_TYPE_V0:
  decodedClaimAtom.v0 = ClaimOfferAtomV0.decode(stream);
  break;
  case CLAIM_ATOM_TYPE_ORDER_BOOK:
  decodedClaimAtom.orderBook = ClaimOfferAtom.decode(stream);
  break;
  case CLAIM_ATOM_TYPE_LIQUIDITY_POOL:
  decodedClaimAtom.liquidityPool = ClaimLiquidityAtom.decode(stream);
  break;
  }
    return decodedClaimAtom;
  }
  @Override
  public int hashCode() {
    return Objects.hashCode(this.v0, this.orderBook, this.liquidityPool, this.type);
  }
  @Override
  public boolean equals(Object object) {
    if (!(object instanceof ClaimAtom)) {
      return false;
    }

    ClaimAtom other = (ClaimAtom) object;
    return Objects.equal(this.v0, other.v0) && Objects.equal(this.orderBook, other.orderBook) && Objects.equal(this.liquidityPool, other.liquidityPool) && Objects.equal(this.type, other.type);
  }
}
