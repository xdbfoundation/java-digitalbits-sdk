package io.digitalbits.sdk.xdr;

import org.junit.Test;
import io.digitalbits.sdk.AccountConverter;
import io.digitalbits.sdk.InflationOperation;

import static org.junit.Assert.assertTrue;
import io.digitalbits.sdk.Network;


public class InflationDecodeTest {

    @Test
    public void testDecodeInflationOperation() throws Exception {
        io.digitalbits.sdk.Transaction tx = (io.digitalbits.sdk.Transaction) io.digitalbits.sdk.Transaction.fromEnvelopeXdr(
            AccountConverter.enableMuxed(),
            "AAAAAALC+FwxReetNDfMNvY5LOS1qSe7QqrfQPS28dnIV95NAAAAZAAAAAAAAATSAAAAAQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAQAAAAAAAAAJAAAAAAAAAAA=",
            Network.TESTNET
        );
        io.digitalbits.sdk.Operation[] ops = tx.getOperations();
        assertTrue(ops[0] instanceof InflationOperation);
    }
}
