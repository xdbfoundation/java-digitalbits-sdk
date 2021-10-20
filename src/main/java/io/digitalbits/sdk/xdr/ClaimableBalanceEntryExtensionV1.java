// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package io.digitalbits.sdk.xdr;


import java.io.IOException;

import com.google.common.base.Objects;

// === xdr source ============================================================

//  struct ClaimableBalanceEntryExtensionV1
//  {
//      union switch (int v)
//      {
//      case 0:
//          void;
//      }
//      ext;
//  
//      uint32 flags; // see ClaimableBalanceFlags
//  };

//  ===========================================================================
public class ClaimableBalanceEntryExtensionV1 implements XdrElement {
  public ClaimableBalanceEntryExtensionV1 () {}
  private ClaimableBalanceEntryExtensionV1Ext ext;
  public ClaimableBalanceEntryExtensionV1Ext getExt() {
    return this.ext;
  }
  public void setExt(ClaimableBalanceEntryExtensionV1Ext value) {
    this.ext = value;
  }
  private Uint32 flags;
  public Uint32 getFlags() {
    return this.flags;
  }
  public void setFlags(Uint32 value) {
    this.flags = value;
  }
  public static void encode(XdrDataOutputStream stream, ClaimableBalanceEntryExtensionV1 encodedClaimableBalanceEntryExtensionV1) throws IOException{
    ClaimableBalanceEntryExtensionV1Ext.encode(stream, encodedClaimableBalanceEntryExtensionV1.ext);
    Uint32.encode(stream, encodedClaimableBalanceEntryExtensionV1.flags);
  }
  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static ClaimableBalanceEntryExtensionV1 decode(XdrDataInputStream stream) throws IOException {
    ClaimableBalanceEntryExtensionV1 decodedClaimableBalanceEntryExtensionV1 = new ClaimableBalanceEntryExtensionV1();
    decodedClaimableBalanceEntryExtensionV1.ext = ClaimableBalanceEntryExtensionV1Ext.decode(stream);
    decodedClaimableBalanceEntryExtensionV1.flags = Uint32.decode(stream);
    return decodedClaimableBalanceEntryExtensionV1;
  }
  @Override
  public int hashCode() {
    return Objects.hashCode(this.ext, this.flags);
  }
  @Override
  public boolean equals(Object object) {
    if (!(object instanceof ClaimableBalanceEntryExtensionV1)) {
      return false;
    }

    ClaimableBalanceEntryExtensionV1 other = (ClaimableBalanceEntryExtensionV1) object;
    return Objects.equal(this.ext, other.ext) && Objects.equal(this.flags, other.flags);
  }

  public static final class Builder {
    private ClaimableBalanceEntryExtensionV1Ext ext;
    private Uint32 flags;

    public Builder ext(ClaimableBalanceEntryExtensionV1Ext ext) {
      this.ext = ext;
      return this;
    }

    public Builder flags(Uint32 flags) {
      this.flags = flags;
      return this;
    }

    public ClaimableBalanceEntryExtensionV1 build() {
      ClaimableBalanceEntryExtensionV1 val = new ClaimableBalanceEntryExtensionV1();
      val.setExt(ext);
      val.setFlags(flags);
      return val;
    }
  }

  public static class ClaimableBalanceEntryExtensionV1Ext {
    public ClaimableBalanceEntryExtensionV1Ext () {}
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

      public ClaimableBalanceEntryExtensionV1Ext build() {
        ClaimableBalanceEntryExtensionV1Ext val = new ClaimableBalanceEntryExtensionV1Ext();
        val.setDiscriminant(discriminant);
        return val;
      }
    }

    public static void encode(XdrDataOutputStream stream, ClaimableBalanceEntryExtensionV1Ext encodedClaimableBalanceEntryExtensionV1Ext) throws IOException {
    //Xdrgen::AST::Typespecs::Int
    //Integer
    stream.writeInt(encodedClaimableBalanceEntryExtensionV1Ext.getDiscriminant().intValue());
    switch (encodedClaimableBalanceEntryExtensionV1Ext.getDiscriminant()) {
    case 0:
    break;
    }
    }
    public void encode(XdrDataOutputStream stream) throws IOException {
      encode(stream, this);
    }
    public static ClaimableBalanceEntryExtensionV1Ext decode(XdrDataInputStream stream) throws IOException {
    ClaimableBalanceEntryExtensionV1Ext decodedClaimableBalanceEntryExtensionV1Ext = new ClaimableBalanceEntryExtensionV1Ext();
    Integer discriminant = stream.readInt();
    decodedClaimableBalanceEntryExtensionV1Ext.setDiscriminant(discriminant);
    switch (decodedClaimableBalanceEntryExtensionV1Ext.getDiscriminant()) {
    case 0:
    break;
    }
      return decodedClaimableBalanceEntryExtensionV1Ext;
    }
    @Override
    public int hashCode() {
      return Objects.hashCode(this.v);
    }
    @Override
    public boolean equals(Object object) {
      if (!(object instanceof ClaimableBalanceEntryExtensionV1Ext)) {
        return false;
      }

      ClaimableBalanceEntryExtensionV1Ext other = (ClaimableBalanceEntryExtensionV1Ext) object;
      return Objects.equal(this.v, other.v);
    }

  }
}
