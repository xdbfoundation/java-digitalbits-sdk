package io.digitalbits.sdk;

import io.digitalbits.sdk.xdr.MemoType;

/**
 * Represents MEMO_HASH.
 */
public class MemoHash extends MemoHashAbstract {
  public MemoHash(byte[] bytes) {
    super(bytes);
  }

  public MemoHash(String hexString) {
    super(hexString);
  }

  @Override
  io.digitalbits.sdk.xdr.Memo toXdr() {
    io.digitalbits.sdk.xdr.Memo memo = new io.digitalbits.sdk.xdr.Memo();
    memo.setDiscriminant(MemoType.MEMO_HASH);

    io.digitalbits.sdk.xdr.Hash hash = new io.digitalbits.sdk.xdr.Hash();
    hash.setHash(bytes);

    memo.setHash(hash);
    return memo;
  }
}
