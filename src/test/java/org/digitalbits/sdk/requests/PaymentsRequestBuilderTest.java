package io.digitalbits.sdk.requests;

import okhttp3.HttpUrl;
import org.junit.Test;
import io.digitalbits.sdk.Server;

import static org.junit.Assert.assertEquals;

public class PaymentsRequestBuilderTest {
  @Test
  public void testPayments() {
    Server server = new Server("https://frontier.testnet.digitalbits.io");
    HttpUrl uri = server.payments()
            .limit(200)
            .order(RequestBuilder.Order.DESC)
            .buildUri();
    assertEquals("https://frontier.testnet.digitalbits.io/payments?limit=200&order=desc", uri.toString());
  }

  @Test
  public void testForAccount() {
    Server server = new Server("https://frontier.testnet.digitalbits.io");
    HttpUrl uri = server.payments()
            .forAccount("GBRPYHIL2CI3FNQ4BXLFMNDLFJUNPU2HY3ZMFSHONUCEOASW7QC7OX2H")
            .limit(200)
            .order(RequestBuilder.Order.DESC)
            .buildUri();
    assertEquals("https://frontier.testnet.digitalbits.io/accounts/GBRPYHIL2CI3FNQ4BXLFMNDLFJUNPU2HY3ZMFSHONUCEOASW7QC7OX2H/payments?limit=200&order=desc", uri.toString());
  }

  @Test
  public void testForLedger() {
    Server server = new Server("https://frontier.testnet.digitalbits.io");
    HttpUrl uri = server.payments()
            .forLedger(200000000000L)
            .limit(50)
            .order(RequestBuilder.Order.ASC)
            .buildUri();
    assertEquals("https://frontier.testnet.digitalbits.io/ledgers/200000000000/payments?limit=50&order=asc", uri.toString());
  }

  @Test
  public void testForTransaction() {
    Server server = new Server("https://frontier.testnet.digitalbits.io");
    HttpUrl uri = server.payments()
            .forTransaction("991534d902063b7715cd74207bef4e7bd7aa2f108f62d3eba837ce6023b2d4f3")
            .buildUri();
    assertEquals("https://frontier.testnet.digitalbits.io/transactions/991534d902063b7715cd74207bef4e7bd7aa2f108f62d3eba837ce6023b2d4f3/payments", uri.toString());
  }


  @Test
  public void testIncludeTransactions() {
    Server server = new Server("https://frontier.testnet.digitalbits.io");
    HttpUrl uri = server.payments()
        .forTransaction("991534d902063b7715cd74207bef4e7bd7aa2f108f62d3eba837ce6023b2d4f3")
        .includeTransactions(true)
        .buildUri();
    assertEquals("https://frontier.testnet.digitalbits.io/transactions/991534d902063b7715cd74207bef4e7bd7aa2f108f62d3eba837ce6023b2d4f3/payments?join=transactions", uri.toString());

    uri = server.payments()
        .forTransaction("991534d902063b7715cd74207bef4e7bd7aa2f108f62d3eba837ce6023b2d4f3")
        .includeTransactions(true)
        .includeTransactions(false)
        .order(RequestBuilder.Order.ASC)
        .includeTransactions(true)
        .buildUri();
    assertEquals("https://frontier.testnet.digitalbits.io/transactions/991534d902063b7715cd74207bef4e7bd7aa2f108f62d3eba837ce6023b2d4f3/payments?order=asc&join=transactions", uri.toString());
  }

  @Test
  public void testExcludeTransactions() {
    Server server = new Server("https://frontier.testnet.digitalbits.io");
    HttpUrl uri = server.payments()
        .forTransaction("991534d902063b7715cd74207bef4e7bd7aa2f108f62d3eba837ce6023b2d4f3")
        .includeTransactions(false)
        .buildUri();
    assertEquals("https://frontier.testnet.digitalbits.io/transactions/991534d902063b7715cd74207bef4e7bd7aa2f108f62d3eba837ce6023b2d4f3/payments", uri.toString());
  }
}
