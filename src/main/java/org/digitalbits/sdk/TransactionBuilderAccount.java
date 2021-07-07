package io.digitalbits.sdk;

/**
 * Specifies interface for Account object used in {@link io.digitalbits.sdk.Transaction.Builder}
 */
public interface TransactionBuilderAccount {
  /**
   * Returns ID associated with this Account
   */
  String getAccountId();

  /**
   * Returns keypair associated with this Account
   */
  KeyPair getKeyPair();

  /**
   * Returns current sequence number ot this Account.
   */
  Long getSequenceNumber();

  /**
   * Returns sequence number incremented by one, but does not increment internal counter.
   */
  Long getIncrementedSequenceNumber();

  /**
   * Increments sequence number in this object by one.
   */
  void incrementSequenceNumber();
}
