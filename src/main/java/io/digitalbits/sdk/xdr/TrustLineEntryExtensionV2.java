// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package io.digitalbits.sdk.xdr;


import java.io.IOException;

import com.google.common.base.Objects;

// === xdr source ============================================================

//  struct TrustLineEntryExtensionV2
//  {
//      int32 liquidityPoolUseCount;
//  
//      union switch (int v)
//      {
//      case 0:
//          void;
//      }
//      ext;
//  };

//  ===========================================================================
public class TrustLineEntryExtensionV2 implements XdrElement {
  public TrustLineEntryExtensionV2 () {}
  private Int32 liquidityPoolUseCount;
  public Int32 getLiquidityPoolUseCount() {
    return this.liquidityPoolUseCount;
  }
  public void setLiquidityPoolUseCount(Int32 value) {
    this.liquidityPoolUseCount = value;
  }
  private TrustLineEntryExtensionV2Ext ext;
  public TrustLineEntryExtensionV2Ext getExt() {
    return this.ext;
  }
  public void setExt(TrustLineEntryExtensionV2Ext value) {
    this.ext = value;
  }
  public static void encode(XdrDataOutputStream stream, TrustLineEntryExtensionV2 encodedTrustLineEntryExtensionV2) throws IOException{
    Int32.encode(stream, encodedTrustLineEntryExtensionV2.liquidityPoolUseCount);
    TrustLineEntryExtensionV2Ext.encode(stream, encodedTrustLineEntryExtensionV2.ext);
  }
  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static TrustLineEntryExtensionV2 decode(XdrDataInputStream stream) throws IOException {
    TrustLineEntryExtensionV2 decodedTrustLineEntryExtensionV2 = new TrustLineEntryExtensionV2();
    decodedTrustLineEntryExtensionV2.liquidityPoolUseCount = Int32.decode(stream);
    decodedTrustLineEntryExtensionV2.ext = TrustLineEntryExtensionV2Ext.decode(stream);
    return decodedTrustLineEntryExtensionV2;
  }
  @Override
  public int hashCode() {
    return Objects.hashCode(this.liquidityPoolUseCount, this.ext);
  }
  @Override
  public boolean equals(Object object) {
    if (!(object instanceof TrustLineEntryExtensionV2)) {
      return false;
    }

    TrustLineEntryExtensionV2 other = (TrustLineEntryExtensionV2) object;
    return Objects.equal(this.liquidityPoolUseCount, other.liquidityPoolUseCount) && Objects.equal(this.ext, other.ext);
  }

  public static final class Builder {
    private Int32 liquidityPoolUseCount;
    private TrustLineEntryExtensionV2Ext ext;

    public Builder liquidityPoolUseCount(Int32 liquidityPoolUseCount) {
      this.liquidityPoolUseCount = liquidityPoolUseCount;
      return this;
    }

    public Builder ext(TrustLineEntryExtensionV2Ext ext) {
      this.ext = ext;
      return this;
    }

    public TrustLineEntryExtensionV2 build() {
      TrustLineEntryExtensionV2 val = new TrustLineEntryExtensionV2();
      val.setLiquidityPoolUseCount(liquidityPoolUseCount);
      val.setExt(ext);
      return val;
    }
  }

  public static class TrustLineEntryExtensionV2Ext {
    public TrustLineEntryExtensionV2Ext () {}
    Integer v;
    public Integer getDiscriminant() {
      return this.v;
    }
    public void setDiscriminant(Integer value) {
      this.v = value;
    }

    public static final class Builder {
      private Integer discriminant;

      public Builder discriminant(Integer discriminant) {
        this.discriminant = discriminant;
        return this;
      }

      public TrustLineEntryExtensionV2Ext build() {
        TrustLineEntryExtensionV2Ext val = new TrustLineEntryExtensionV2Ext();
        val.setDiscriminant(discriminant);
        return val;
      }
    }

    public static void encode(XdrDataOutputStream stream, TrustLineEntryExtensionV2Ext encodedTrustLineEntryExtensionV2Ext) throws IOException {
    //Xdrgen::AST::Typespecs::Int
    //Integer
    stream.writeInt(encodedTrustLineEntryExtensionV2Ext.getDiscriminant().intValue());
    switch (encodedTrustLineEntryExtensionV2Ext.getDiscriminant()) {
    case 0:
    break;
    }
    }
    public void encode(XdrDataOutputStream stream) throws IOException {
      encode(stream, this);
    }
    public static TrustLineEntryExtensionV2Ext decode(XdrDataInputStream stream) throws IOException {
    TrustLineEntryExtensionV2Ext decodedTrustLineEntryExtensionV2Ext = new TrustLineEntryExtensionV2Ext();
    Integer discriminant = stream.readInt();
    decodedTrustLineEntryExtensionV2Ext.setDiscriminant(discriminant);
    switch (decodedTrustLineEntryExtensionV2Ext.getDiscriminant()) {
    case 0:
    break;
    }
      return decodedTrustLineEntryExtensionV2Ext;
    }
    @Override
    public int hashCode() {
      return Objects.hashCode(this.v);
    }
    @Override
    public boolean equals(Object object) {
      if (!(object instanceof TrustLineEntryExtensionV2Ext)) {
        return false;
      }

      TrustLineEntryExtensionV2Ext other = (TrustLineEntryExtensionV2Ext) object;
      return Objects.equal(this.v, other.v);
    }

  }
}
