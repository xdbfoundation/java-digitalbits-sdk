// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package io.digitalbits.sdk.xdr;


import java.io.IOException;


// === xdr source ============================================================

//  enum LedgerUpgradeType
//  {
//      LEDGER_UPGRADE_VERSION = 1,
//      LEDGER_UPGRADE_BASE_FEE = 2,
//      LEDGER_UPGRADE_MAX_TX_SET_SIZE = 3,
//      LEDGER_UPGRADE_BASE_RESERVE = 4,
//      LEDGER_UPGRADE_FLAGS = 5
//  };

//  ===========================================================================
public enum LedgerUpgradeType implements XdrElement {
  LEDGER_UPGRADE_VERSION(1),
  LEDGER_UPGRADE_BASE_FEE(2),
  LEDGER_UPGRADE_MAX_TX_SET_SIZE(3),
  LEDGER_UPGRADE_BASE_RESERVE(4),
  LEDGER_UPGRADE_FLAGS(5),
  ;
  private int mValue;

  LedgerUpgradeType(int value) {
      mValue = value;
  }

  public int getValue() {
      return mValue;
  }

  public static LedgerUpgradeType decode(XdrDataInputStream stream) throws IOException {
    int value = stream.readInt();
    switch (value) {
      case 1: return LEDGER_UPGRADE_VERSION;
      case 2: return LEDGER_UPGRADE_BASE_FEE;
      case 3: return LEDGER_UPGRADE_MAX_TX_SET_SIZE;
      case 4: return LEDGER_UPGRADE_BASE_RESERVE;
      case 5: return LEDGER_UPGRADE_FLAGS;
      default:
        throw new RuntimeException("Unknown enum value: " + value);
    }
  }

  public static void encode(XdrDataOutputStream stream, LedgerUpgradeType value) throws IOException {
    stream.writeInt(value.getValue());
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
}
