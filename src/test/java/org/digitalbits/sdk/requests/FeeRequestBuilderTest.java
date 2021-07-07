package io.digitalbits.sdk.requests;

import okhttp3.HttpUrl;
import org.junit.Test;
import io.digitalbits.sdk.Network;
import io.digitalbits.sdk.Server;

import static org.junit.Assert.assertEquals;

public class FeeRequestBuilderTest {
    @Test
    public void testBuilder() {
        Server server = new Server("https://frontier.testnet.digitalbits.io");
        HttpUrl uri = server.feeStats().buildUri();
        assertEquals("https://frontier.testnet.digitalbits.io/fee_stats", uri.toString());
    }
}
