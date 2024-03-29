package io.digitalbits.sdk;

import com.google.common.base.Objects;
import io.digitalbits.sdk.xdr.Operation.OperationBody;
import io.digitalbits.sdk.xdr.OperationType;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Represents <a href="https://developers.digitalbits.io/guides/concepts/list-of-operations.html#account-merge" target="_blank">AccountMerge</a> operation.
 * @see <a href="https://developers.digitalbits.io/guides/concepts/list-of-operations.html" target="_blank">List of Operations</a>
 */
public class AccountMergeOperation extends Operation {

    private final String destination;

    private AccountMergeOperation(String destination) {
        this.destination = checkNotNull(destination, "destination cannot be null");
    }

    /**
     * The account that receives the remaining XDB balance of the source account.
     */
    public String getDestination() {
        return destination;
    }

    @Override
    OperationBody toOperationBody(AccountConverter accountConverter) {
        OperationBody body = new io.digitalbits.sdk.xdr.Operation.OperationBody();
        body.setDestination(accountConverter.encode(this.destination));
        body.setDiscriminant(OperationType.ACCOUNT_MERGE);
        return body;
    }

    /**
     * Builds AccountMerge operation.
     * @see AccountMergeOperation
     */
    public static class Builder {
        private final String destination;

        private String mSourceAccount;

        Builder(AccountConverter accountConverter, OperationBody op) {
            destination = accountConverter.decode(op.getDestination());
        }

        /**
         * Creates a new AccountMerge builder.
         * @param destination The account that receives the remaining XDB balance of the source account.
         */
        public Builder(String destination) {
            this.destination = destination;
        }

        /**
         * Set source account of this operation
         * @param sourceAccount Source account
         * @return Builder object so you can chain methods.
         */
        public Builder setSourceAccount(String sourceAccount) {
            mSourceAccount = sourceAccount;
            return this;
        }

        /**
         * Builds an operation
         */
        public AccountMergeOperation build() {
            AccountMergeOperation operation = new AccountMergeOperation(destination);
            if (mSourceAccount != null) {
                operation.setSourceAccount(mSourceAccount);
            }
            return operation;
        }
    }

    public int hashCode() {
        return Objects.hashCode(this.destination, this.getSourceAccount());
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof AccountMergeOperation)) {
            return false;
        }

        AccountMergeOperation other = (AccountMergeOperation) object;
        return Objects.equal(this.destination, other.destination) &&
                Objects.equal(this.getSourceAccount(), other.getSourceAccount());
    }
}
