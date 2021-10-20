// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package io.digitalbits.sdk.xdr;


import java.io.IOException;


// === xdr source ============================================================

//  enum SurveyMessageCommandType
//  {
//      SURVEY_TOPOLOGY = 0
//  };

//  ===========================================================================
public enum SurveyMessageCommandType implements XdrElement {
  SURVEY_TOPOLOGY(0),
  ;
  private int mValue;

  SurveyMessageCommandType(int value) {
      mValue = value;
  }

  public int getValue() {
      return mValue;
  }

  public static SurveyMessageCommandType decode(XdrDataInputStream stream) throws IOException {
    int value = stream.readInt();
    switch (value) {
      case 0: return SURVEY_TOPOLOGY;
      default:
        throw new RuntimeException("Unknown enum value: " + value);
    }
  }

  public static void encode(XdrDataOutputStream stream, SurveyMessageCommandType value) throws IOException {
    stream.writeInt(value.getValue());
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
}
