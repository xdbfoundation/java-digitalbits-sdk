package io.digitalbits.sdk.requests;

import okhttp3.HttpUrl;
import org.junit.Test;
import io.digitalbits.sdk.Network;
import io.digitalbits.sdk.Server;

import static org.junit.Assert.assertEquals;

public class LedgersRequestBuilderTest {
  @Test
  public void testAccounts() {
    Server server = new Server("https://frontier.testnet.digitalbits.io");
    HttpUrl uri = server.ledgers()
            .limit(200)
            .order(RequestBuilder.Order.ASC)
            .buildUri();
    assertEquals("https://frontier.testnet.digitalbits.io/ledgers?limit=200&order=asc", uri.toString());
  }
}
