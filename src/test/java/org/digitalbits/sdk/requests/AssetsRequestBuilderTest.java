package io.digitalbits.sdk.requests;

import okhttp3.HttpUrl;
import org.junit.Test;
import io.digitalbits.sdk.Network;
import io.digitalbits.sdk.Server;

import static org.junit.Assert.assertEquals;

public class AssetsRequestBuilderTest {
    @Test
    public void testAccounts() {
        Server server = new Server("https://frontier.testnet.digitalbits.io");
        HttpUrl uri = server.assets()
                .assetCode("USD")
                .assetIssuer("GDSBCQO34HWPGUGQSP3QBFEXVTSR2PW46UIGTHVWGWJGQKH3AFNHXHXN")
                .cursor("13537736921089")
                .limit(200)
                .order(RequestBuilder.Order.ASC)
                .buildUri();
        assertEquals("https://frontier.testnet.digitalbits.io/assets?asset_code=USD&asset_issuer=GDSBCQO34HWPGUGQSP3QBFEXVTSR2PW46UIGTHVWGWJGQKH3AFNHXHXN&cursor=13537736921089&limit=200&order=asc", uri.toString());
    }
}
