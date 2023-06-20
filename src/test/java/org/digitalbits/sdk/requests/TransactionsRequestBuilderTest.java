package io.digitalbits.sdk.requests;

import okhttp3.HttpUrl;
import org.junit.Test;
import io.digitalbits.sdk.KeyPair;
import io.digitalbits.sdk.LiquidityPoolID;
import io.digitalbits.sdk.Network;
import io.digitalbits.sdk.Server;

import static org.junit.Assert.assertEquals;

public class TransactionsRequestBuilderTest {
  @Test
  public void testTransactions() {
    Server server = new Server("https://frontier.testnet.digitalbits.io");
    HttpUrl uri = server.transactions()
            .limit(200)
            .order(RequestBuilder.Order.DESC)
            .buildUri();
    assertEquals("https://frontier.testnet.digitalbits.io/transactions?limit=200&order=desc", uri.toString());
  }

  @Test
  public void testForAccount() {
    Server server = new Server("https://frontier.testnet.digitalbits.io");
    HttpUrl uri = server.transactions()
            .forAccount("GBRPYHIL2CI3FNQ4BXLFMNDLFJUNPU2HY3ZMFSHONUCEOASW7QC7OX2H")
            .limit(200)
            .order(RequestBuilder.Order.DESC)
            .buildUri();
    assertEquals("https://frontier.testnet.digitalbits.io/accounts/GBRPYHIL2CI3FNQ4BXLFMNDLFJUNPU2HY3ZMFSHONUCEOASW7QC7OX2H/transactions?limit=200&order=desc", uri.toString());
  }

  @Test
  public void testForClaimableBalance() {
    Server server = new Server("https://frontier.testnet.digitalbits.io");
    HttpUrl uri = server.transactions()
            .forClaimableBalance("00000000846c047755e4a46912336f56096b48ece78ddb5fbf6d90f0eb4ecae5324fbddb")
            .limit(200)
            .order(RequestBuilder.Order.DESC)
            .buildUri();
    assertEquals("https://frontier.testnet.digitalbits.io/claimable_balances/00000000846c047755e4a46912336f56096b48ece78ddb5fbf6d90f0eb4ecae5324fbddb/transactions?limit=200&order=desc", uri.toString());
  }

  @Test
  public void testForLedger() {
    Server server = new Server("https://frontier.testnet.digitalbits.io");
    HttpUrl uri = server.transactions()
            .forLedger(200000000000L)
            .limit(50)
            .order(RequestBuilder.Order.ASC)
            .buildUri();
    assertEquals("https://frontier.testnet.digitalbits.io/ledgers/200000000000/transactions?limit=50&order=asc", uri.toString());
  }

  @Test
  public void testForLiquidityPool() {
    Server server = new Server("https://frontier.testnet.digitalbits.io");
    HttpUrl uri = server.transactions()
            .forLiquidityPool(new LiquidityPoolID("67260c4c1807b262ff851b0a3fe141194936bb0215b2f77447f1df11998eabb9"))
            .buildUri();
    assertEquals("https://frontier.testnet.digitalbits.io/liquidity_pools/67260c4c1807b262ff851b0a3fe141194936bb0215b2f77447f1df11998eabb9/transactions", uri.toString());
  }

  @Test
  public void testIncludeFailed() {
    Server server = new Server("https://frontier.testnet.digitalbits.io");
    HttpUrl uri = server.transactions()
            .forLedger(200000000000L)
            .includeFailed(true)
            .limit(50)
            .order(RequestBuilder.Order.ASC)
            .buildUri();
    assertEquals("https://frontier.testnet.digitalbits.io/ledgers/200000000000/transactions?include_failed=true&limit=50&order=asc", uri.toString());
  }
}
