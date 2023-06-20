package io.digitalbits.sdk;

import org.junit.Test;
import io.digitalbits.sdk.xdr.LiquidityPoolType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static io.digitalbits.sdk.Asset.create;

public class LiquidityPoolDepositOperationTest {
    // GC5SIC4E3V56VOHJ3OZAX5SJDTWY52JYI2AFK6PUGSXFVRJQYQXXZBZF
    KeyPair source = KeyPair.fromSecretSeed("SC4CGETADVYTCR5HEAVZRB3DZQY5Y4J7RFNJTRA6ESMHIPEZUSTE2QDK");
    Asset nativeAsset = create("native");
    Asset creditAsset = create(null, "ABC", "GCRA6COW27CY5MTKIA7POQ2326C5ABYCXODBN4TFF5VL4FMBRHOT3YHU");
    LiquidityPoolID liquidityPoolID = new LiquidityPoolID(
        LiquidityPoolType.LIQUIDITY_POOL_CONSTANT_PRODUCT,
        nativeAsset,
        creditAsset,
        LiquidityPoolParameters.Fee
    );

    @Test
    public void testLiquidityPoolDepositOperationValid() {
        String maxAmountA = "1000";
        String maxAmountB = "2000";
        Price minPrice = Price.fromString("0.01");
        Price maxPrice = Price.fromString("0.02");
        LiquidityPoolDepositOperation operation = new LiquidityPoolDepositOperation(liquidityPoolID, maxAmountA, maxAmountB, minPrice, maxPrice);
        operation.setSourceAccount(source.getAccountId());

        io.digitalbits.sdk.xdr.Operation xdr = operation.toXdr(AccountConverter.enableMuxed());
        LiquidityPoolDepositOperation parsedOperation = (LiquidityPoolDepositOperation) Operation.fromXdr(AccountConverter.enableMuxed(), xdr);

        assertEquals(source.getAccountId(), parsedOperation.getSourceAccount());
        assertEquals(liquidityPoolID, parsedOperation.getLiquidityPoolID());
        assertEquals(maxAmountA, parsedOperation.getMaxAmountA());
        assertEquals(maxAmountB, parsedOperation.getMaxAmountB());
        assertEquals(minPrice, parsedOperation.getMinPrice());
        assertEquals(maxPrice, parsedOperation.getMaxPrice());

        assertEquals(
                "AAAAAQAAAAC7JAuE3XvquOnbsgv2SRztjuk4RoBVefQ0rlrFMMQvfAAAABb5NUX4ubtAgBk7zCsrbB/oCH2ADwtupaNB0FyfhxedxwAAAAJUC+QAAAAABKgXyAAAAAABAAAAZAAAAAEAAAAy",
                operation.toXdrBase64(AccountConverter.enableMuxed()));
    }

    @Test
    public void testConstructorPairs() {
        String maxAmountA = "1000";
        String maxAmountB = "2000";
        Price minPrice = Price.fromString("0.01");
        Price maxPrice = Price.fromString("0.02");
        LiquidityPoolDepositOperation operation = new LiquidityPoolDepositOperation(
            new AssetAmount(nativeAsset, maxAmountA),
            new AssetAmount(creditAsset, maxAmountB),
            minPrice,
            maxPrice
        );
        operation.setSourceAccount(source.getAccountId());

        io.digitalbits.sdk.xdr.Operation xdr = operation.toXdr(AccountConverter.enableMuxed());
        LiquidityPoolDepositOperation parsedOperation = (LiquidityPoolDepositOperation) Operation.fromXdr(AccountConverter.enableMuxed(), xdr);

        assertEquals(source.getAccountId(), parsedOperation.getSourceAccount());
        assertEquals(liquidityPoolID, parsedOperation.getLiquidityPoolID());
        assertEquals(maxAmountA, parsedOperation.getMaxAmountA());
        assertEquals(maxAmountB, parsedOperation.getMaxAmountB());
        assertEquals(minPrice, parsedOperation.getMinPrice());
        assertEquals(maxPrice, parsedOperation.getMaxPrice());

        assertEquals(
                "AAAAAQAAAAC7JAuE3XvquOnbsgv2SRztjuk4RoBVefQ0rlrFMMQvfAAAABb5NUX4ubtAgBk7zCsrbB/oCH2ADwtupaNB0FyfhxedxwAAAAJUC+QAAAAABKgXyAAAAAABAAAAZAAAAAEAAAAy",
                operation.toXdrBase64(AccountConverter.enableMuxed()));
    }

    @Test
    public void testConstructorPairsMisorderedAssets() {
        String maxAmountA = "1000";
        String maxAmountB = "2000";
        Price minPrice = Price.fromString("0.01");
        Price maxPrice = Price.fromString("0.02");
        try {
            new LiquidityPoolDepositOperation(
                new AssetAmount(creditAsset, maxAmountB),
                new AssetAmount(nativeAsset, maxAmountA),
                minPrice,
                maxPrice
            ).setSourceAccount(source.getAccountId());
            fail();
        } catch (RuntimeException e) {
            assertEquals("AssetA must be < AssetB", e.getMessage());
        }
    }
}
