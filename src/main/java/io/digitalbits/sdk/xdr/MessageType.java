// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package io.digitalbits.sdk.xdr;


import java.io.IOException;


// === xdr source ============================================================

//  enum MessageType
//  {
//      ERROR_MSG = 0,
//      AUTH = 2,
//      DONT_HAVE = 3,
//  
//      GET_PEERS = 4, // gets a list of peers this guy knows about
//      PEERS = 5,
//  
//      GET_TX_SET = 6, // gets a particular txset by hash
//      TX_SET = 7,
//  
//      TRANSACTION = 8, // pass on a tx you have heard about
//  
//      // SCP
//      GET_SCP_QUORUMSET = 9,
//      SCP_QUORUMSET = 10,
//      SCP_MESSAGE = 11,
//      GET_SCP_STATE = 12,
//  
//      // new messages
//      HELLO = 13,
//  
//      SURVEY_REQUEST = 14,
//      SURVEY_RESPONSE = 15,
//  
//      SEND_MORE = 16
//  };

//  ===========================================================================
public enum MessageType implements XdrElement {
  ERROR_MSG(0),
  AUTH(2),
  DONT_HAVE(3),
  GET_PEERS(4),
  PEERS(5),
  GET_TX_SET(6),
  TX_SET(7),
  TRANSACTION(8),
  GET_SCP_QUORUMSET(9),
  SCP_QUORUMSET(10),
  SCP_MESSAGE(11),
  GET_SCP_STATE(12),
  HELLO(13),
  SURVEY_REQUEST(14),
  SURVEY_RESPONSE(15),
  SEND_MORE(16),
  ;
  private int mValue;

  MessageType(int value) {
      mValue = value;
  }

  public int getValue() {
      return mValue;
  }

  public static MessageType decode(XdrDataInputStream stream) throws IOException {
    int value = stream.readInt();
    switch (value) {
      case 0: return ERROR_MSG;
      case 2: return AUTH;
      case 3: return DONT_HAVE;
      case 4: return GET_PEERS;
      case 5: return PEERS;
      case 6: return GET_TX_SET;
      case 7: return TX_SET;
      case 8: return TRANSACTION;
      case 9: return GET_SCP_QUORUMSET;
      case 10: return SCP_QUORUMSET;
      case 11: return SCP_MESSAGE;
      case 12: return GET_SCP_STATE;
      case 13: return HELLO;
      case 14: return SURVEY_REQUEST;
      case 15: return SURVEY_RESPONSE;
      case 16: return SEND_MORE;
      default:
        throw new RuntimeException("Unknown enum value: " + value);
    }
  }

  public static void encode(XdrDataOutputStream stream, MessageType value) throws IOException {
    stream.writeInt(value.getValue());
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
}
