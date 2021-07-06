package io.digitalbits.sdk.requests;

import okhttp3.HttpUrl;
import org.junit.Test;
import io.digitalbits.sdk.Asset;
import io.digitalbits.sdk.KeyPair;
import io.digitalbits.sdk.Network;
import io.digitalbits.sdk.Server;

import static org.junit.Assert.assertEquals;

public class TradesRequestBuilderTest {
    @Test
    public void testTrades() {
        Server server = new Server("https://frontier.testnet.digitalbits.io");
        HttpUrl uri = server.trades()
                .baseAsset(Asset.createNonNativeAsset("EUR", "GAUPA4HERNBDPVO4IUA3MJXBCRRK5W54EVXTDK6IIUTGDQRB6D5W242W"))
                .counterAsset(Asset.createNonNativeAsset("USD", "GDRRHSJMHXDTQBT4JTCILNGF5AS54FEMTXL7KOLMF6TFTHRK6SSUSUZZ"))
                .cursor("13537736921089")
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
}
