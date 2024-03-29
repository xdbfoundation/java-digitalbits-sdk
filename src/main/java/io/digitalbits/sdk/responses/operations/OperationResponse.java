package io.digitalbits.sdk.responses.operations;

import com.google.common.base.Optional;
import com.google.gson.annotations.SerializedName;

import io.digitalbits.sdk.responses.*;

import java.math.BigInteger;

/**
 * Abstract class for operation responses.
 * @see <a href="https://developers.digitalbits.io/frontier/reference/resources/operation.html" target="_blank">Operation documentation</a>
 * @see io.digitalbits.sdk.requests.OperationsRequestBuilder
 * @see io.digitalbits.sdk.Server#operations()
 */
public abstract class OperationResponse extends Response implements Pageable {
  @SerializedName("id")
  private Long id;
  @SerializedName("source_account")
  private String sourceAccount;
  @SerializedName("source_account_muxed")
  private String sourceAccountMuxed;
  @SerializedName("source_account_muxed_id")
  private BigInteger sourceAccountMuxedId;
  @SerializedName("paging_token")
  private String pagingToken;
  @SerializedName("created_at")
  private String createdAt;
  @SerializedName("transaction_hash")
  private String transactionHash;
  @SerializedName("transaction_successful")
  private Boolean transactionSuccessful;
  @SerializedName("type")
  private String type;
  @SerializedName("_links")
  private Links links;
  @SerializedName("transaction")
  private TransactionResponse transaction;

  public Optional<MuxedAccount> getSourceAccountMuxed() {
    if (this.sourceAccountMuxed == null|| this.sourceAccountMuxed.isEmpty()) {
      return Optional.absent();
    }
    return Optional.of(new MuxedAccount(this.sourceAccountMuxed, this.sourceAccount, this.sourceAccountMuxedId));
  }

  public Long getId() {
    return id;
  }

  public String getSourceAccount() {
    return sourceAccount;
  }

  public String getPagingToken() {
    return pagingToken;
  }

  /**
   * <p>Returns operation type. Possible types:</p>
   * <ul>
   *   <li>create_account</li>
   *   <li>payment</li>
   *   <li>allow_trust</li>
   *   <li>change_trust</li>
   *   <li>set_options</li>
   *   <li>account_merge</li>
   *   <li>manage_offer</li>
   *   <li>path_payment</li>
   *   <li>create_passive_offer</li>
   *   <li>inflation</li>
   *   <li>manage_data</li>
   * </ul>
   */
  public String getType() {
    return type;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  /**
   * Returns transaction hash of transaction this operation belongs to.
   */
  public String getTransactionHash() {
    return transactionHash;
  }

  public Boolean isTransactionSuccessful() {
    return transactionSuccessful;
  }

  public Links getLinks() {
    return links;
  }

  public Optional<TransactionResponse> getTransaction() {
    return Optional.fromNullable(transaction);
  }

  /**
   * Represents operation links.
   */
  public static class Links {
    @SerializedName("effects")
    private final Link effects;
    @SerializedName("precedes")
    private final Link precedes;
    @SerializedName("self")
    private final Link self;
    @SerializedName("succeeds")
    private final Link succeeds;
    @SerializedName("transaction")
    private final Link transaction;

    public Links(Link effects, Link precedes, Link self, Link succeeds, Link transaction) {
      this.effects = effects;
      this.precedes = precedes;
      this.self = self;
      this.succeeds = succeeds;
      this.transaction = transaction;
    }

    public Link getEffects() {
      return effects;
    }

    public Link getPrecedes() {
      return precedes;
    }

    public Link getSelf() {
      return self;
    }

    public Link getSucceeds() {
      return succeeds;
    }

    public Link getTransaction() {
      return transaction;
    }
  }
}
