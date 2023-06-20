package io.digitalbits.sdk.requests;

import okhttp3.HttpUrl;
import org.junit.Test;
import io.digitalbits.sdk.*;

import static org.junit.Assert.assertEquals;

public class LiquidityPoolsRequestBuilderTest {
  @Test
  public void testLiquidityPools() {
    Server server = new Server("https://frontier.testnet.digitalbits.io");
    HttpUrl uri = server.liquidityPools()
            .cursor("13537736921089")
            .limit(200)
            .order(RequestBuilder.Order.ASC)
            .buildUri();
    assertEquals("https://frontier.testnet.digitalbits.io/liquidity_pools?cursor=13537736921089&limit=200&order=asc", uri.toString());
  }

  @Test
  public void testForReserves() {
    Server server = new Server("https://frontier.testnet.digitalbits.io");
    HttpUrl uri = server.liquidityPools()
        .forReserves("EURT:GAP5LETOV6YIE62YAM56STDANPRDO7ZFDBGSNHJQIYGGKSMOZAHOOS2S", "PHP:GAP5LETOV6YIE62YAM56STDANPRDO7ZFDBGSNHJQIYGGKSMOZAHOOS2S")
        .buildUri();
    assertEquals("https://frontier.testnet.digitalbits.io/liquidity_pools?reserves=EURT%3AGAP5LETOV6YIE62YAM56STDANPRDO7ZFDBGSNHJQIYGGKSMOZAHOOS2S%2CPHP%3AGAP5LETOV6YIE62YAM56STDANPRDO7ZFDBGSNHJQIYGGKSMOZAHOOS2S", uri.toString());
  }
}
