package io.digitalbits.sdk.requests;

import okhttp3.HttpUrl;
import org.junit.Test;
import io.digitalbits.sdk.KeyPair;
import io.digitalbits.sdk.LiquidityPoolID;
import io.digitalbits.sdk.Network;
import io.digitalbits.sdk.Server;

import static org.junit.Assert.assertEquals;

public class EffectsRequestBuilderTest {
  @Test
  public void testEffects() {
    Server server = new Server("https://frontier.testnet.digitalbits.io");
    HttpUrl uri = server.effects()
            .limit(200)
            .order(RequestBuilder.Order.DESC)
            .buildUri();
    assertEquals("https://frontier.testnet.digitalbits.io/effects?limit=200&order=desc", uri.toString());
  }

  @Test
  public void testForAccount() {
    Server server = new Server("https://frontier.testnet.digitalbits.io");
    HttpUrl uri = server.effects()
            .forAccount("GBRPYHIL2CI3FNQ4BXLFMNDLFJUNPU2HY3ZMFSHONUCEOASW7QC7OX2H")
            .limit(200)
            .order(RequestBuilder.Order.DESC)
            .buildUri();
    assertEquals("https://frontier.testnet.digitalbits.io/accounts/GBRPYHIL2CI3FNQ4BXLFMNDLFJUNPU2HY3ZMFSHONUCEOASW7QC7OX2H/effects?limit=200&order=desc", uri.toString());
  }

  @Test
  public void testForLedger() {
    Server server = new Server("https://frontier.testnet.digitalbits.io");
    HttpUrl uri = server.effects()
            .forLedger(200000000000L)
            .limit(50)
            .order(RequestBuilder.Order.ASC)
            .buildUri();
    assertEquals("https://frontier.testnet.digitalbits.io/ledgers/200000000000/effects?limit=50&order=asc", uri.toString());
  }

  @Test
  public void testForLiquidityPool() {
    Server server = new Server("https://frontier.testnet.digitalbits.io");
    HttpUrl uri = server.effects()
            .forLiquidityPool(new LiquidityPoolID("67260c4c1807b262ff851b0a3fe141194936bb0215b2f77447f1df11998eabb9"))
            .buildUri();
    assertEquals("https://frontier.testnet.digitalbits.io/liquidity_pools/67260c4c1807b262ff851b0a3fe141194936bb0215b2f77447f1df11998eabb9/effects", uri.toString());
  }

  @Test
  public void testForTransaction() {
    Server server = new Server("https://frontier.testnet.digitalbits.io");
    HttpUrl uri = server.effects()
            .forTransaction("991534d902063b7715cd74207bef4e7bd7aa2f108f62d3eba837ce6023b2d4f3")
            .buildUri();
    assertEquals("https://frontier.testnet.digitalbits.io/transactions/991534d902063b7715cd74207bef4e7bd7aa2f108f62d3eba837ce6023b2d4f3/effects", uri.toString());
  }

  @Test
  public void testForOperation() {
    Server server = new Server("https://frontier.testnet.digitalbits.io");
    HttpUrl uri = server.effects()
            .forOperation(28798257847L)
            .cursor("85794837")
            .buildUri();
    assertEquals("https://frontier.testnet.digitalbits.io/operations/28798257847/effects?cursor=85794837", uri.toString());
  }
}
