package io.digitalbits.sdk;

import io.digitalbits.sdk.xdr.Memo;
import io.digitalbits.sdk.xdr.MemoType;

/**
 * Represents MEMO_RETURN.
 */
public class MemoReturnHash extends MemoHashAbstract {
  public MemoReturnHash(byte[] bytes) {
    super(bytes);
  }

  public MemoReturnHash(String hexString) {
    super(hexString);
  }

  @Override
  Memo toXdr() {
    io.digitalbits.sdk.xdr.Memo memo = new io.digitalbits.sdk.xdr.Memo();
    memo.setDiscriminant(MemoType.MEMO_RETURN);

    io.digitalbits.sdk.xdr.Hash hash = new io.digitalbits.sdk.xdr.Hash();
    hash.setHash(bytes);

    memo.setRetHash(hash);
    return memo;
  }
}
