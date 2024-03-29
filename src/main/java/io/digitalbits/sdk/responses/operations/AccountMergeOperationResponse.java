package io.digitalbits.sdk.responses.operations;

import com.google.common.base.Optional;
import com.google.gson.annotations.SerializedName;
import io.digitalbits.sdk.responses.MuxedAccount;

import java.math.BigInteger;

/**
 * Represents AccountMerge operation response.
 * @see <a href="https://developers.digitalbits.io/frontier/reference/resources/operation.html" target="_blank">Operation documentation</a>
 * @see io.digitalbits.sdk.requests.OperationsRequestBuilder
 * @see io.digitalbits.sdk.Server#operations()
 */
public class AccountMergeOperationResponse extends OperationResponse {
  @SerializedName("account")
  private String account;
  @SerializedName("account_muxed")
  private String accountMuxed;
  @SerializedName("account_muxed_id")
  private BigInteger accountMuxedId;

  @SerializedName("into")
  private String into;
  @SerializedName("into_muxed")
  private String intoMuxed;
  @SerializedName("into_muxed_id")
  private BigInteger intoMuxedId;

  public Optional<MuxedAccount> getAccountMuxed() {
    if (this.accountMuxed == null || this.accountMuxed.isEmpty()) {
      return Optional.absent();
    }
    return Optional.of(new MuxedAccount(this.accountMuxed, this.account, this.accountMuxedId));
  }

  public Optional<MuxedAccount> getIntoMuxed() {
    if (this.intoMuxed == null || this.intoMuxed.isEmpty()) {
      return Optional.absent();
    }
    return Optional.of(new MuxedAccount(this.intoMuxed, this.into, this.intoMuxedId));
  }

  public String getAccount() {
    return account;
  }

  public String getInto() {
    return into;
  }
}
