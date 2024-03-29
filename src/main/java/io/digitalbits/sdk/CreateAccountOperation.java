package io.digitalbits.sdk;

import com.google.common.base.Objects;
import io.digitalbits.sdk.xdr.CreateAccountOp;
import io.digitalbits.sdk.xdr.Int64;
import io.digitalbits.sdk.xdr.OperationType;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Represents <a href="https://developers.digitalbits.io/guides/concepts/list-of-operations.html#create-account" target="_blank">CreateAccount</a> operation.
 * @see <a href="https://developers.digitalbits.io/guides/concepts/list-of-operations.html" target="_blank">List of Operations</a>
 */
public class CreateAccountOperation extends Operation {

  private final String destination;
  private final String startingBalance;

  private CreateAccountOperation(String destination, String startingBalance) {
    this.destination = checkNotNull(destination, "destination cannot be null");
    this.startingBalance = checkNotNull(startingBalance, "startingBalance cannot be null");
  }

  /**
   * Amount of XDB to send to the newly created account.
   */
  public String getStartingBalance() {
    return startingBalance;
  }

  /**
   * Account that is created and funded
   */
  public String getDestination() {
    return destination;
  }

  @Override
  io.digitalbits.sdk.xdr.Operation.OperationBody toOperationBody(AccountConverter accountConverter) {
    CreateAccountOp op = new CreateAccountOp();
    op.setDestination(StrKey.encodeToXDRAccountId(this.destination));
    Int64 startingBalance = new Int64();
    startingBalance.setInt64(Operation.toXdrAmount(this.startingBalance));
    op.setStartingBalance(startingBalance);

    io.digitalbits.sdk.xdr.Operation.OperationBody body = new io.digitalbits.sdk.xdr.Operation.OperationBody();
    body.setDiscriminant(OperationType.CREATE_ACCOUNT);
    body.setCreateAccountOp(op);
    return body;
  }

  /**
   * Builds CreateAccount operation.
   * @see CreateAccountOperation
   */
  public static class Builder {
    private final String destination;
    private final String startingBalance;

    private String mSourceAccount;

    /**
     * Construct a new CreateAccount builder from a CreateAccountOp XDR.
     * @param op {@link CreateAccountOp}
     */
    Builder(CreateAccountOp op) {
      destination = StrKey.encodeDigitalBitsAccountId(op.getDestination());
      startingBalance = Operation.fromXdrAmount(op.getStartingBalance().getInt64().longValue());
    }

    /**
     * Creates a new CreateAccount builder.
     * @param destination The destination keypair (uses only the public key).
     * @param startingBalance The initial balance to start with in lumens.
     * @throws ArithmeticException when startingBalance has more than 7 decimal places.
     */
    public Builder(String destination, String startingBalance) {
      this.destination = destination;
      this.startingBalance = startingBalance;
    }

    /**
     * Sets the source account for this operation.
     * @param account The operation's source account.
     * @return Builder object so you can chain methods.
     */
    public Builder setSourceAccount(String account) {
      mSourceAccount = account;
      return this;
    }

    /**
     * Builds an operation
     */
    public CreateAccountOperation build() {
      CreateAccountOperation operation = new CreateAccountOperation(destination, startingBalance);
      if (mSourceAccount != null) {
        operation.setSourceAccount(mSourceAccount);
      }
      return operation;
    }
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.destination, this.startingBalance, this.getSourceAccount());
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof CreateAccountOperation)) {
      return false;
    }

    CreateAccountOperation other = (CreateAccountOperation) object;
    return Objects.equal(this.destination, other.destination) &&
            Objects.equal(this.startingBalance, other.startingBalance) &&
            Objects.equal(this.getSourceAccount(), other.getSourceAccount());

  }
}
