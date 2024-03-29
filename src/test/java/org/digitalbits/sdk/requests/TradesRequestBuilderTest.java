package io.digitalbits.sdk.requests;

import okhttp3.HttpUrl;
import org.junit.Test;
import io.digitalbits.sdk.LiquidityPoolID;
import io.digitalbits.sdk.Server;

import static org.junit.Assert.assertEquals;
import static io.digitalbits.sdk.Asset.create;

public class TradesRequestBuilderTest {
    @Test
    public void testTrades() {
        Server server = new Server("https://frontier.testnet.digitalbits.io");
        HttpUrl uri = server.trades()
                .baseAsset(create(null,"EUR", "GAUPA4HERNBDPVO4IUA3MJXBCRRK5W54EVXTDK6IIUTGDQRB6D5W242W"))
                .counterAsset(create(null,"USD", "GDRRHSJMHXDTQBT4JTCILNGF5AS54FEMTXL7KOLMF6TFTHRK6SSUSUZZ"))
                .cursor("13537736921089")
                .offerId(123L)
                .limit(200)
                .order(RequestBuilder.Order.ASC)
                .buildUri();

        assertEquals("https://frontier.testnet.digitalbits.io/trades?" +
                "base_asset_type=credit_alphanum4&" +
                "base_asset_code=EUR&" +
                "base_asset_issuer=GAUPA4HERNBDPVO4IUA3MJXBCRRK5W54EVXTDK6IIUTGDQRB6D5W242W&" +
                "counter_asset_type=credit_alphanum4&" +
                "counter_asset_code=USD&" +
                "counter_asset_issuer=GDRRHSJMHXDTQBT4JTCILNGF5AS54FEMTXL7KOLMF6TFTHRK6SSUSUZZ&" +
                "cursor=13537736921089&" +
                "offer_id=123&" +
                "limit=200&" +
                "order=asc", uri.toString());
    }

    @Test
    public void testTradesForAccount() {
        Server server = new Server("https://frontier.testnet.digitalbits.io");
        HttpUrl uri = server.trades()
                .forAccount("GDRRHSJMHXDTQBT4JTCILNGF5AS54FEMTXL7KOLMF6TFTHRK6SSUSUZZ")
                .cursor("13537736921089")
                .limit(200)
                .order(RequestBuilder.Order.ASC)
                .buildUri();

        assertEquals("https://frontier.testnet.digitalbits.io/accounts/GDRRHSJMHXDTQBT4JTCILNGF5AS54FEMTXL7KOLMF6TFTHRK6SSUSUZZ/trades?" +
                "cursor=13537736921089&" +
                "limit=200&" +
                "order=asc", uri.toString());
    }

  @Test
  public void testForLiquidityPool() {
    Server server = new Server("https://frontier.testnet.digitalbits.io");
    HttpUrl uri = server.trades()
            .forLiquidityPool(new LiquidityPoolID("67260c4c1807b262ff851b0a3fe141194936bb0215b2f77447f1df11998eabb9"))
            .buildUri();
    assertEquals("https://frontier.testnet.digitalbits.io/liquidity_pools/67260c4c1807b262ff851b0a3fe141194936bb0215b2f77447f1df11998eabb9/trades", uri.toString());
  }

    @Test
    public void testForNullOfferId() {
        Server server = new Server("https://frontier.testnet.digitalbits.io");
        HttpUrl uri = server.trades()
                .offerId(12345L)
                .cursor("13537736921089")
                .offerId(null)
                .limit(200)
                .buildUri();
        assertEquals("https://frontier.testnet.digitalbits.io/trades?cursor=13537736921089&limit=200", uri.toString());
    }
}
