package io.digitalbits.sdk.requests;

import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.Test;
import io.digitalbits.sdk.KeyPair;
import io.digitalbits.sdk.Network;
import io.digitalbits.sdk.Server;
import io.digitalbits.sdk.responses.operations.OperationResponse;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class OperationsRequestBuilderTest {

  private static final String operationResponse = "{\n" +
      "  \"_links\": {\n" +
      "    \"self\": {\n" +
      "      \"href\": \"https://frontier.testnet.digitalbits.io/operations/438086668289\"\n" +
      "    },\n" +
      "    \"transaction\": {\n" +
      "      \"href\": \"https://frontier.testnet.digitalbits.io/transactions/749e4f8933221b9942ef38a02856803f379789ec8d971f1f60535db70135673e\"\n" +
      "    },\n" +
      "    \"effects\": {\n" +
      "      \"href\": \"https://frontier.testnet.digitalbits.io/operations/438086668289/effects\"\n" +
      "    },\n" +
      "    \"succeeds\": {\n" +
      "      \"href\": \"https://frontier.testnet.digitalbits.io/effects?order=desc\\u0026cursor=438086668289\"\n" +
      "    },\n" +
      "    \"precedes\": {\n" +
      "      \"href\": \"https://frontier.testnet.digitalbits.io/effects?order=asc\\u0026cursor=438086668289\"\n" +
      "    }\n" +
      "  },\n" +
      "  \"id\": \"438086668289\",\n" +
      "  \"paging_token\": \"438086668289\",\n" +
      "  \"transaction_successful\": true,\n" +
      "  \"source_account\": \"GBRPYHIL2CI3FNQ4BXLFMNDLFJUNPU2HY3ZMFSHONUCEOASW7QC7OX2H\",\n" +
      "  \"type\": \"create_account\",\n" +
      "  \"type_i\": 0,\n" +
      "  \"created_at\": \"2019-10-30T09:34:07Z\",\n" +
      "  \"transaction_hash\": \"749e4f8933221b9942ef38a02856803f379789ec8d971f1f60535db70135673e\",\n" +
      "  \"starting_balance\": \"10000000000.0000000\",\n" +
      "  \"funder\": \"GBRPYHIL2CI3FNQ4BXLFMNDLFJUNPU2HY3ZMFSHONUCEOASW7QC7OX2H\",\n" +
      "  \"account\": \"GAIH3ULLFQ4DGSECF2AR555KZ4KNDGEKN4AFI4SU2M7B43MGK3QJZNSR\"\n" +
      "}";

  @Test
  public void testOperations() {
    Server server = new Server("https://frontier.testnet.digitalbits.io");
    HttpUrl uri = server.operations()
            .limit(200)
            .order(RequestBuilder.Order.DESC)
            .buildUri();
    assertEquals("https://frontier.testnet.digitalbits.io/operations?limit=200&order=desc", uri.toString());
  }

  @Test
  public void testOperationById() throws IOException, InterruptedException {
    MockWebServer mockWebServer = new MockWebServer();
    mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(operationResponse));
    mockWebServer.start();
    Server server = new Server(mockWebServer.url("").toString());
    OperationResponse response = server.operations()
        .operation(438086668289l) ;
    assertEquals(response.getType(), "create_account");
    assertEquals(response.getId(), new Long(438086668289l));
    assertEquals(response.getSourceAccount(), "GBRPYHIL2CI3FNQ4BXLFMNDLFJUNPU2HY3ZMFSHONUCEOASW7QC7OX2H");
    RecordedRequest request = mockWebServer.takeRequest();
    assertEquals(request.getMethod(), "GET");
    assertEquals(request.getPath(), "/operations/438086668289");
  }

  @Test
  public void testForAccount() {
    Server server = new Server("https://frontier.testnet.digitalbits.io");
    HttpUrl uri = server.operations()
            .forAccount("GBRPYHIL2CI3FNQ4BXLFMNDLFJUNPU2HY3ZMFSHONUCEOASW7QC7OX2H")
            .limit(200)
            .order(RequestBuilder.Order.DESC)
            .buildUri();
    assertEquals("https://frontier.testnet.digitalbits.io/accounts/GBRPYHIL2CI3FNQ4BXLFMNDLFJUNPU2HY3ZMFSHONUCEOASW7QC7OX2H/operations?limit=200&order=desc", uri.toString());
  }

  @Test
  public void testForClaimableBalance() {
    Server server = new Server("https://frontier.testnet.digitalbits.io");
    HttpUrl uri = server.operations()
            .forClaimableBalance("00000000846c047755e4a46912336f56096b48ece78ddb5fbf6d90f0eb4ecae5324fbddb")
            .limit(200)
            .order(RequestBuilder.Order.DESC)
            .buildUri();
    assertEquals("https://frontier.testnet.digitalbits.io/claimable_balances/00000000846c047755e4a46912336f56096b48ece78ddb5fbf6d90f0eb4ecae5324fbddb/operations?limit=200&order=desc", uri.toString());
  }

  @Test
  public void testForLedger() {
    Server server = new Server("https://frontier.testnet.digitalbits.io");
    HttpUrl uri = server.operations()
            .forLedger(200000000000L)
            .limit(50)
            .order(RequestBuilder.Order.ASC)
            .buildUri();
    assertEquals("https://frontier.testnet.digitalbits.io/ledgers/200000000000/operations?limit=50&order=asc", uri.toString());
  }

  @Test
  public void testForTransaction() {
    Server server = new Server("https://frontier.testnet.digitalbits.io");
    HttpUrl uri = server.operations()
            .forTransaction("991534d902063b7715cd74207bef4e7bd7aa2f108f62d3eba837ce6023b2d4f3")
            .buildUri();
    assertEquals("https://frontier.testnet.digitalbits.io/transactions/991534d902063b7715cd74207bef4e7bd7aa2f108f62d3eba837ce6023b2d4f3/operations", uri.toString());
  }

  @Test
  public void testIncludeFailed() {
    Server server = new Server("https://frontier.testnet.digitalbits.io");
    HttpUrl uri = server.operations()
            .forLedger(200000000000L)
            .includeFailed(true)
            .limit(50)
            .order(RequestBuilder.Order.ASC)
            .buildUri();
    assertEquals("https://frontier.testnet.digitalbits.io/ledgers/200000000000/operations?include_failed=true&limit=50&order=asc", uri.toString());
  }

  @Test
  public void testIncludeTransactions() {
    Server server = new Server("https://frontier.testnet.digitalbits.io");
    HttpUrl uri = server.operations()
        .forLedger(200000000000L)
        .includeTransactions(true)
        .limit(50)
        .order(RequestBuilder.Order.ASC)
        .buildUri();
    assertEquals("https://frontier.testnet.digitalbits.io/ledgers/200000000000/operations?join=transactions&limit=50&order=asc", uri.toString());

    uri = server.operations()
        .forLedger(200000000000L)
        .includeTransactions(true)
        .limit(50)
        .includeTransactions(false)
        .order(RequestBuilder.Order.ASC)
        .includeTransactions(true)
        .buildUri();
    assertEquals("https://frontier.testnet.digitalbits.io/ledgers/200000000000/operations?limit=50&order=asc&join=transactions", uri.toString());
  }

  @Test
  public void testExcludeTransactions() {
    Server server = new Server("https://frontier.testnet.digitalbits.io");
    HttpUrl uri = server.operations()
        .forLedger(200000000000L)
        .includeTransactions(true)
        .limit(50)
        .order(RequestBuilder.Order.ASC)
        .includeTransactions(false)
        .buildUri();
    assertEquals("https://frontier.testnet.digitalbits.io/ledgers/200000000000/operations?limit=50&order=asc", uri.toString());
  }
}
