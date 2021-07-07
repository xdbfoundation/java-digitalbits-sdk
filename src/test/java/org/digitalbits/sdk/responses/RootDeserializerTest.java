package io.digitalbits.sdk.responses;

import junit.framework.TestCase;

import org.junit.Test;

public class RootDeserializerTest extends TestCase {
    @Test
    public void testDeserialize() {
        RootResponse root = GsonSingleton.getInstance().fromJson(json, RootResponse.class);

        assertEquals(root.getFrontierVersion(), "snapshot-c5fe0ff");
        assertEquals(root.getDigitalBitsCoreVersion(), "digitalbits-core 9.2.0 (7561c1d53366ec79b908de533726269e08474f77)");
        assertEquals(root.getHistoryLatestLedger(), 18369116);
        assertEquals(root.getHistoryElderLedger(), 1);
        assertEquals(root.getCoreLatestLedger(), 18369117);
        assertEquals(root.getNetworkPassphrase(), "LiveNet Global DigitalBits Network ; February 2021");
        assertEquals(root.getProtocolVersion(), 9);
        assertEquals(root.getCurrentProtocolVersion(), 10);
        assertEquals(root.getCoreSupportedProtocolVersion(), 11);
    }

    String json = "{\n" +
            "  \"_links\": {\n" +
            "    \"account\": {\n" +
            "      \"href\": \"https://frontier.livenet.digitalbits.io/accounts/{account_id}\",\n" +
            "      \"templated\": true\n" +
            "    },\n" +
            "    \"account_transactions\": {\n" +
            "      \"href\": \"https://frontier.livenet.digitalbits.io/accounts/{account_id}/transactions{?cursor,limit,order}\",\n" +
            "      \"templated\": true\n" +
            "    },\n" +
            "    \"assets\": {\n" +
            "      \"href\": \"https://frontier.livenet.digitalbits.io/assets{?asset_code,asset_issuer,cursor,limit,order}\",\n" +
            "      \"templated\": true\n" +
            "    },\n" +
            "    \"friendbot\": {\n" +
            "      \"href\": \"https://frontier.livenet.digitalbits.io/friendbot{?addr}\",\n" +
            "      \"templated\": true\n" +
            "    },\n" +
            "    \"metrics\": {\n" +
            "      \"href\": \"https://frontier.livenet.digitalbits.io/metrics\"\n" +
            "    },\n" +
            "    \"order_book\": {\n" +
            "      \"href\": \"https://frontier.livenet.digitalbits.io/order_book{?selling_asset_type,selling_asset_code,selling_issuer,buying_asset_type,buying_asset_code,buying_issuer,limit}\",\n" +
            "      \"templated\": true\n" +
            "    },\n" +
            "    \"self\": {\n" +
            "      \"href\": \"https://frontier.livenet.digitalbits.io/\"\n" +
            "    },\n" +
            "    \"transaction\": {\n" +
            "      \"href\": \"https://frontier.livenet.digitalbits.io/transactions/{hash}\",\n" +
            "      \"templated\": true\n" +
            "    },\n" +
            "    \"transactions\": {\n" +
            "      \"href\": \"https://frontier.livenet.digitalbits.io/transactions{?cursor,limit,order}\",\n" +
            "      \"templated\": true\n" +
            "    }\n" +
            "  },\n" +
            "  \"frontier_version\": \"snapshot-c5fe0ff\",\n" +
            "  \"core_version\": \"digitalbits-core 9.2.0 (7561c1d53366ec79b908de533726269e08474f77)\",\n" +
            "  \"history_latest_ledger\": 18369116,\n" +
            "  \"history_elder_ledger\": 1,\n" +
            "  \"core_latest_ledger\": 18369117,\n" +
            "  \"network_passphrase\": \"LiveNet Global DigitalBits Network ; February 2021\",\n" +
            "  \"protocol_version\": 9\n," +
            "  \"current_protocol_version\": 10\n," +
            "  \"core_supported_protocol_version\": 11\n" +
            "}";
}
