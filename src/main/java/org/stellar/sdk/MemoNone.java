package io.digitalbits.sdk;

import io.digitalbits.sdk.xdr.MemoType;


/**
 * Represents MEMO_NONE.
 */
public class MemoNone extends Memo {
  @Override
  io.digitalbits.sdk.xdr.Memo toXdr() {
    io.digitalbits.sdk.xdr.Memo memo = new io.digitalbits.sdk.xdr.Memo();
    memo.setDiscriminant(MemoType.MEMO_NONE);
    return memo;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    return true;
  }

  @Override
  public String toString() {
    return "";
  }
}
