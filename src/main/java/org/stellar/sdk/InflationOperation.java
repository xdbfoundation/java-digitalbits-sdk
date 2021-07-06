package io.digitalbits.sdk;

import com.google.common.base.Objects;
import io.digitalbits.sdk.xdr.OperationType;

/**
 * Represents <a href="https://developers.digitalbits.io/guides/concepts/list-of-operations.html#inflation" target="_blank">Inflation</a> operation.
 * @see <a href="https://developers.digitalbits.io/guides/concepts/list-of-operations.html" target="_blank">List of Operations</a>
 */
public class InflationOperation extends Operation {
    @Override
    io.digitalbits.sdk.xdr.Operation.OperationBody toOperationBody(AccountConverter accountConverter) {
        io.digitalbits.sdk.xdr.Operation.OperationBody body = new io.digitalbits.sdk.xdr.Operation.OperationBody();
        body.setDiscriminant(OperationType.INFLATION);
        return body;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.getSourceAccount());
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof InflationOperation)) {
            return false;
        }

        InflationOperation other = (InflationOperation) object;
        return Objects.equal(this.getSourceAccount(), other.getSourceAccount());
    }
}
