package io.digitalbits.sdk.federation;

import junit.framework.TestCase;

import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class FederationTest extends TestCase {
  @Before
  public void setUp() throws IOException {
    FederationServer.httpsConnection = false;
  }

  @After
  public void tearDown() throws IOException {
    FederationServer.httpsConnection = true;
  }

  @Test
  public void testResolveSuccess() throws IOException {
    MockWebServer mockWebServer = new MockWebServer();
    mockWebServer.start();

    HttpUrl baseUrl = mockWebServer.url("");
    String domain = String.format("%s:%d", baseUrl.host(), baseUrl.port());

      String digitalbitsToml =
              "FEDERATION_SERVER = \"http://"+domain+"/federation\"";
      String successResponse =
              "{\"digitalbits_address\":\"bob*"+domain+"\",\"account_id\":\"GCW667JUHCOP5Y7KY6KGDHNPHFM4CS3FCBQ7QWDUALXTX3PGXLSOEALY\"}";

    mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(digitalbitsToml));
    mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(successResponse));

    FederationResponse response = Federation.resolve("bob*"+domain);
    assertEquals(response.getDigitalBitsAddress(), "bob*"+domain);
    assertEquals(response.getAccountId(), "GCW667JUHCOP5Y7KY6KGDHNPHFM4CS3FCBQ7QWDUALXTX3PGXLSOEALY");
    assertNull(response.getMemoType());
    assertNull(response.getMemo());
  }

  @Test
  public void testMalformedAddress() {
    try {
      FederationResponse response = Federation.resolve("bob*digitalbits.io*test");
      fail("Expected exception");
    } catch (MalformedAddressException e) {
      //
    }
  }
}
