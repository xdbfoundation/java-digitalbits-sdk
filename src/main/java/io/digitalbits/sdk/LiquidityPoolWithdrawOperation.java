package io.digitalbits.sdk;

import com.google.common.base.Objects;
import io.digitalbits.sdk.xdr.Operation.OperationBody;
import io.digitalbits.sdk.xdr.LiquidityPoolType;
import io.digitalbits.sdk.xdr.LiquidityPoolWithdrawOp;
import io.digitalbits.sdk.xdr.OperationType;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Represents <a href="https://developers.digitalbits.io/docs/start/list-of-operations/#liquidity-pool-deposit" target="_blank">LiquidityPoolDeposit</a> operation.
 * @see <a href="https://developers.digitalbits.io/docs/start/list-of-operations/" target="_blank">List of Operations</a>
 */
public class LiquidityPoolWithdrawOperation extends Operation {
    private final LiquidityPoolID liquidityPoolID;
    private final String amount;
    private final String minAmountA;
    private final String minAmountB;

    public LiquidityPoolWithdrawOperation(LiquidityPoolID liquidityPoolID, String amount, String minAmountA, String minAmountB) {
      this.liquidityPoolID = checkNotNull(liquidityPoolID, "liquidityPoolID cannot be null");
      this.amount = checkNotNull(amount, "amount cannot be null");
      this.minAmountA = checkNotNull(minAmountA, "minAmountA cannot be null");
      this.minAmountB = checkNotNull(minAmountB, "minAmountB cannot be null");
    }

    public LiquidityPoolWithdrawOperation(LiquidityPoolWithdrawOp op) {
      this.liquidityPoolID = LiquidityPoolID.fromXdr(op.getLiquidityPoolID());
      this.amount = Operation.fromXdrAmount(op.getAmount().getInt64().longValue());
      this.minAmountA = Operation.fromXdrAmount(op.getMinAmountA().getInt64().longValue());
      this.minAmountB = Operation.fromXdrAmount(op.getMinAmountB().getInt64().longValue());
    }

    public LiquidityPoolWithdrawOperation(AssetAmount a, AssetAmount b, String amount) {
      this.liquidityPoolID = new LiquidityPoolID(LiquidityPoolType.LIQUIDITY_POOL_CONSTANT_PRODUCT, a.getAsset(), b.getAsset(), LiquidityPoolParameters.Fee);
      this.amount = checkNotNull(amount, "amount cannot be null");
      this.minAmountA = a.getAmount();
      this.minAmountB = b.getAmount();
    }

    public LiquidityPoolID getLiquidityPoolID() {
        return liquidityPoolID;
    }

    public String getAmount() {
        return amount;
    }

    public String getMinAmountA() {
        return minAmountA;
    }

    public String getMinAmountB() {
        return minAmountB;
    }

    @Override
    OperationBody toOperationBody(AccountConverter accountConverter) {
        LiquidityPoolWithdrawOp op = new LiquidityPoolWithdrawOp();
        op.setLiquidityPoolID(this.getLiquidityPoolID().toXdr());
        op.setAmount(new io.digitalbits.sdk.xdr.Int64(Operation.toXdrAmount(this.getAmount())));
        op.setMinAmountA(new io.digitalbits.sdk.xdr.Int64(Operation.toXdrAmount(this.getMinAmountA())));
        op.setMinAmountB(new io.digitalbits.sdk.xdr.Int64(Operation.toXdrAmount(this.getMinAmountB())));

        OperationBody body = new io.digitalbits.sdk.xdr.Operation.OperationBody();
        body.setDiscriminant(OperationType.LIQUIDITY_POOL_WITHDRAW);
        body.setLiquidityPoolWithdrawOp(op);
        return body;
    }

    public int hashCode() {
        return Objects.hashCode(liquidityPoolID, amount, minAmountA, minAmountB);
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof LiquidityPoolWithdrawOperation)) {
            return false;
        }

        LiquidityPoolWithdrawOperation o = (LiquidityPoolWithdrawOperation) object;
        return Objects.equal(this.getLiquidityPoolID(), o.getLiquidityPoolID()) &&
                Objects.equal(this.getAmount(), o.getAmount()) &&
                Objects.equal(this.getMinAmountA(), o.getMinAmountA()) &&
                Objects.equal(this.getMinAmountB(), o.getMinAmountB());
    }
}
