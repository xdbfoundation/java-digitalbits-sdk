package io.digitalbits.sdk;

import com.google.common.base.Objects;
import io.digitalbits.sdk.xdr.OperationType;

import static com.google.common.base.Preconditions.checkNotNull;

public class EndSponsoringFutureReservesOperation extends Operation {
  public EndSponsoringFutureReservesOperation() {

  }

  public EndSponsoringFutureReservesOperation(String sourceAccount) {
    setSourceAccount(checkNotNull(sourceAccount, "sourceAccount cannot be null"));
  }

  @Override
  io.digitalbits.sdk.xdr.Operation.OperationBody toOperationBody(AccountConverter accountConverter) {
    io.digitalbits.sdk.xdr.Operation.OperationBody body = new io.digitalbits.sdk.xdr.Operation.OperationBody();
    body.setDiscriminant(OperationType.END_SPONSORING_FUTURE_RESERVES);

    return body;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.getSourceAccount());
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof EndSponsoringFutureReservesOperation)) {
      return false;
    }

    EndSponsoringFutureReservesOperation other = (EndSponsoringFutureReservesOperation) object;
    return Objects.equal(this.getSourceAccount(), other.getSourceAccount());
  }
}
