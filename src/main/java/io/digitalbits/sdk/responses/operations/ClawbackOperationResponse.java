package io.digitalbits.sdk.responses.operations;

import com.google.common.base.Optional;
import com.google.gson.annotations.SerializedName;
import io.digitalbits.sdk.Asset;
import io.digitalbits.sdk.responses.MuxedAccount;

import java.math.BigInteger;

import static io.digitalbits.sdk.Asset.create;

/**
 * Represents a Clawback operation response.
 *
 * @see io.digitalbits.sdk.requests.OperationsRequestBuilder
 * @see io.digitalbits.sdk.Server#operations()
 */
public class ClawbackOperationResponse extends OperationResponse {
  @SerializedName("asset_type")
  private String assetType;
  @SerializedName("asset_code")
  private String assetCode;
  @SerializedName("asset_issuer")
  private String assetIssuer;
  @SerializedName("amount")
  private String amount;
  @SerializedName("from")
  private String from;
  @SerializedName("from_muxed")
  private String fromMuxed;
  @SerializedName("from_muxed_id")
  private BigInteger fromMuxedId;

  public String getAssetType() {
    return assetType;
  }

  public String getAssetIssuer() {
    return assetIssuer;
  }

  public String getAssetCode() {
    return assetCode;
  }

  public Asset getAsset() {
    return create(assetType, assetCode, assetIssuer);
  }

  public String getAmount() {
    return amount;
  }

  public String getFrom() {
    return from;
  }

  public Optional<MuxedAccount> getFromMuxed() {
    if (this.fromMuxed == null || this.fromMuxed.isEmpty()) {
      return Optional.absent();
    }
    return Optional.of(new MuxedAccount(this.fromMuxed, this.from, this.fromMuxedId));
  }

}
