package io.digitalbits.sdk.federation;

import com.google.gson.annotations.SerializedName;

/**
 * Object to hold a response from a federation server.
 * @see <a href="https://developers.digitalbits.io/guides/concepts/federation.html" target="_blank">Federation docs</a>
 */
public class FederationResponse {
  @SerializedName("digitalbits_address")
  private final String digitalbitsAddress;
  @SerializedName("account_id")
  private final String accountId;
  @SerializedName("memo_type")
  private final String memoType;
  @SerializedName("memo")
  private final String memo;

  public FederationResponse(String digitalbitsAddress, String accountId, String memoType, String memo) {
    this.digitalbitsAddress = digitalbitsAddress;
    this.accountId = accountId;
    this.memoType = memoType;
    this.memo = memo;
  }

  public String getDigitalBitsAddress() {
    return digitalbitsAddress;
  }

  public String getAccountId() {
    return accountId;
  }

  /**
   * @return Memo type or null when no memo attached
   */
  public String getMemoType() {
    return memoType;
  }

  /**
   * @return Memo value or null when no memo attached
   */
  public String getMemo() {
    return memo;
  }
}
