// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package io.digitalbits.sdk.xdr;


import java.io.IOException;

import java.util.Arrays;

// === xdr source ============================================================

//  typedef opaque EncryptedBody<64000>;

//  ===========================================================================
public class EncryptedBody implements XdrElement {
  private byte[] EncryptedBody;

  public EncryptedBody() {}

  public EncryptedBody(byte[] EncryptedBody) {
    this.EncryptedBody = EncryptedBody;
  }

  public byte[] getEncryptedBody() {
    return this.EncryptedBody;
  }

  public void setEncryptedBody(byte[] value) {
    this.EncryptedBody = value;
  }

  public static void encode(XdrDataOutputStream stream, EncryptedBody  encodedEncryptedBody) throws IOException {
    int EncryptedBodysize = encodedEncryptedBody.EncryptedBody.length;
    stream.writeInt(EncryptedBodysize);
    stream.write(encodedEncryptedBody.getEncryptedBody(), 0, EncryptedBodysize);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static EncryptedBody decode(XdrDataInputStream stream) throws IOException {
    EncryptedBody decodedEncryptedBody = new EncryptedBody();
    int EncryptedBodysize = stream.readInt();
    decodedEncryptedBody.EncryptedBody = new byte[EncryptedBodysize];
    stream.read(decodedEncryptedBody.EncryptedBody, 0, EncryptedBodysize);
    return decodedEncryptedBody;
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(this.EncryptedBody);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof EncryptedBody)) {
      return false;
    }

    EncryptedBody other = (EncryptedBody) object;
    return Arrays.equals(this.EncryptedBody, other.EncryptedBody);
  }
}
