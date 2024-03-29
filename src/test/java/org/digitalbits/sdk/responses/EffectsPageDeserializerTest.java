package io.digitalbits.sdk.responses;

import com.google.gson.reflect.TypeToken;

import junit.framework.TestCase;

import org.junit.Test;
import io.digitalbits.sdk.responses.effects.AccountCreatedEffectResponse;
import io.digitalbits.sdk.responses.effects.EffectResponse;
import io.digitalbits.sdk.responses.effects.SignerCreatedEffectResponse;
import io.digitalbits.sdk.responses.effects.TradeEffectResponse;

import java.math.BigInteger;

import static java.math.BigInteger.valueOf;

public class EffectsPageDeserializerTest extends TestCase {
  @Test
  public void testDeserialize() {
    Page<EffectResponse> effectsPage = GsonSingleton.getInstance().fromJson(json, new TypeToken<Page<EffectResponse>>() {}.getType());

    SignerCreatedEffectResponse signerCreatedEffect = (SignerCreatedEffectResponse) effectsPage.getRecords().get(0);
    assertEquals(signerCreatedEffect.getPublicKey(), "GAZHVTAM3NRJ6W643LOVA76T2W3TUKPF34ED5VNE4ZKJ2B5T2EUQHIQI");
    assertEquals(signerCreatedEffect.getPagingToken(), "3964757325385729-3");

    AccountCreatedEffectResponse accountCreatedEffect = (AccountCreatedEffectResponse) effectsPage.getRecords().get(8);
    assertEquals(accountCreatedEffect.getStartingBalance(), "10000.0");
    assertEquals(accountCreatedEffect.getAccount(), "GDIQJ6G5AWSBRMHIZYWVWCFN64Q4BZ4TYEAQRO5GVR4EWR23RKBJ2A4R");

    assertEquals(effectsPage.getLinks().getNext().getHref(), "http://frontier-testnet.digitalbits.io/effects?order=desc&limit=10&cursor=3962163165138945-3");
  }

  @Test
  public void testTradesEffects() {
    Page<EffectResponse> effectsPage = GsonSingleton.getInstance().fromJson(tradesJson, new TypeToken<Page<EffectResponse>>() {}.getType());

    TradeEffectResponse first = (TradeEffectResponse) effectsPage.getRecords().get(0);
    TradeEffectResponse second = (TradeEffectResponse) effectsPage.getRecords().get(1);

    assertEquals(first.getAccountMuxed().get(), new MuxedAccount(
      "MBB4JST32UWKOLGYYSCEYBHBCOFL2TGBHDVOMZP462ET4ZRD4ULA6AAAAAAAAAAAPN7BA",
      "GBB4JST32UWKOLGYYSCEYBHBCOFL2TGBHDVOMZP462ET4ZRD4ULA7S2L",
      new BigInteger("18446744073709551615")
    ));
    assertFalse(second.getAccountMuxed().isPresent());

    assertEquals(first.getSellerMuxed().get().getUnmuxedAddress(), "GAVH5JM5OKXGMQDS7YPRJ4MQCPXJUGH26LYQPQJ4SOMOJ4SXY472ZM7G");
    assertEquals(first.getSellerMuxed().get().toString(), "MAVH5JM5OKXGMQDS7YPRJ4MQCPXJUGH26LYQPQJ4SOMOJ4SXY472YAAAAAAAAAABUSON4");
    assertEquals(first.getSellerMuxed().get().getId().longValue(), 420l);
    assertFalse(second.getSellerMuxed().isPresent());
  }

  String json = "{\n" +
          "  \"_links\": {\n" +
          "    \"self\": {\n" +
          "      \"href\": \"http://frontier-testnet.digitalbits.io/effects?order=desc\\u0026limit=10\\u0026cursor=\"\n" +
          "    },\n" +
          "    \"next\": {\n" +
          "      \"href\": \"http://frontier-testnet.digitalbits.io/effects?order=desc\\u0026limit=10\\u0026cursor=3962163165138945-3\"\n" +
          "    },\n" +
          "    \"prev\": {\n" +
          "      \"href\": \"http://frontier-testnet.digitalbits.io/effects?order=asc\\u0026limit=10\\u0026cursor=3964757325385729-3\"\n" +
          "    }\n" +
          "  },\n" +
          "  \"_embedded\": {\n" +
          "    \"records\": [\n" +
          "      {\n" +
          "        \"_links\": {\n" +
          "          \"operation\": {\n" +
          "            \"href\": \"http://frontier-testnet.digitalbits.io/operations/3964757325385729\"\n" +
          "          },\n" +
          "          \"succeeds\": {\n" +
          "            \"href\": \"http://frontier-testnet.digitalbits.io/effects?order=desc\\u0026cursor=3964757325385729-3\"\n" +
          "          },\n" +
          "          \"precedes\": {\n" +
          "            \"href\": \"http://frontier-testnet.digitalbits.io/effects?order=asc\\u0026cursor=3964757325385729-3\"\n" +
          "          }\n" +
          "        },\n" +
          "        \"id\": \"0003964757325385729-0000000003\",\n" +
          "        \"paging_token\": \"3964757325385729-3\",\n" +
          "        \"account\": \"GAZHVTAM3NRJ6W643LOVA76T2W3TUKPF34ED5VNE4ZKJ2B5T2EUQHIQI\",\n" +
          "        \"type\": \"signer_created\",\n" +
          "        \"type_i\": 10,\n" +
          "        \"weight\": 1,\n" +
          "        \"public_key\": \"GAZHVTAM3NRJ6W643LOVA76T2W3TUKPF34ED5VNE4ZKJ2B5T2EUQHIQI\"\n" +
          "      },\n" +
          "      {\n" +
          "        \"_links\": {\n" +
          "          \"operation\": {\n" +
          "            \"href\": \"http://frontier-testnet.digitalbits.io/operations/3964757325385729\"\n" +
          "          },\n" +
          "          \"succeeds\": {\n" +
          "            \"href\": \"http://frontier-testnet.digitalbits.io/effects?order=desc\\u0026cursor=3964757325385729-2\"\n" +
          "          },\n" +
          "          \"precedes\": {\n" +
          "            \"href\": \"http://frontier-testnet.digitalbits.io/effects?order=asc\\u0026cursor=3964757325385729-2\"\n" +
          "          }\n" +
          "        },\n" +
          "        \"id\": \"0003964757325385729-0000000002\",\n" +
          "        \"paging_token\": \"3964757325385729-2\",\n" +
          "        \"account\": \"GBS43BF24ENNS3KPACUZVKK2VYPOZVBQO2CISGZ777RYGOPYC2FT6S3K\",\n" +
          "        \"type\": \"account_debited\",\n" +
          "        \"type_i\": 3,\n" +
          "        \"asset_type\": \"native\",\n" +
          "        \"amount\": \"10000.0\"\n" +
          "      },\n" +
          "      {\n" +
          "        \"_links\": {\n" +
          "          \"operation\": {\n" +
          "            \"href\": \"http://frontier-testnet.digitalbits.io/operations/3964757325385729\"\n" +
          "          },\n" +
          "          \"succeeds\": {\n" +
          "            \"href\": \"http://frontier-testnet.digitalbits.io/effects?order=desc\\u0026cursor=3964757325385729-1\"\n" +
          "          },\n" +
          "          \"precedes\": {\n" +
          "            \"href\": \"http://frontier-testnet.digitalbits.io/effects?order=asc\\u0026cursor=3964757325385729-1\"\n" +
          "          }\n" +
          "        },\n" +
          "        \"id\": \"0003964757325385729-0000000001\",\n" +
          "        \"paging_token\": \"3964757325385729-1\",\n" +
          "        \"account\": \"GAZHVTAM3NRJ6W643LOVA76T2W3TUKPF34ED5VNE4ZKJ2B5T2EUQHIQI\",\n" +
          "        \"type\": \"account_created\",\n" +
          "        \"type_i\": 0,\n" +
          "        \"starting_balance\": \"10000.0\"\n" +
          "      },\n" +
          "      {\n" +
          "        \"_links\": {\n" +
          "          \"operation\": {\n" +
          "            \"href\": \"http://frontier-testnet.digitalbits.io/operations/3964645656236033\"\n" +
          "          },\n" +
          "          \"succeeds\": {\n" +
          "            \"href\": \"http://frontier-testnet.digitalbits.io/effects?order=desc\\u0026cursor=3964645656236033-3\"\n" +
          "          },\n" +
          "          \"precedes\": {\n" +
          "            \"href\": \"http://frontier-testnet.digitalbits.io/effects?order=asc\\u0026cursor=3964645656236033-3\"\n" +
          "          }\n" +
          "        },\n" +
          "        \"id\": \"0003964645656236033-0000000003\",\n" +
          "        \"paging_token\": \"3964645656236033-3\",\n" +
          "        \"account\": \"GA43X7ERPZQUVNDVHBGN42AK3SYJRVJ7TUWQGNFVY2O74YVDQFW2KP7C\",\n" +
          "        \"type\": \"signer_created\",\n" +
          "        \"type_i\": 10,\n" +
          "        \"weight\": 1,\n" +
          "        \"public_key\": \"GA43X7ERPZQUVNDVHBGN42AK3SYJRVJ7TUWQGNFVY2O74YVDQFW2KP7C\"\n" +
          "      },\n" +
          "      {\n" +
          "        \"_links\": {\n" +
          "          \"operation\": {\n" +
          "            \"href\": \"http://frontier-testnet.digitalbits.io/operations/3964645656236033\"\n" +
          "          },\n" +
          "          \"succeeds\": {\n" +
          "            \"href\": \"http://frontier-testnet.digitalbits.io/effects?order=desc\\u0026cursor=3964645656236033-2\"\n" +
          "          },\n" +
          "          \"precedes\": {\n" +
          "            \"href\": \"http://frontier-testnet.digitalbits.io/effects?order=asc\\u0026cursor=3964645656236033-2\"\n" +
          "          }\n" +
          "        },\n" +
          "        \"id\": \"0003964645656236033-0000000002\",\n" +
          "        \"paging_token\": \"3964645656236033-2\",\n" +
          "        \"account\": \"GBS43BF24ENNS3KPACUZVKK2VYPOZVBQO2CISGZ777RYGOPYC2FT6S3K\",\n" +
          "        \"type\": \"account_debited\",\n" +
          "        \"type_i\": 3,\n" +
          "        \"asset_type\": \"native\",\n" +
          "        \"amount\": \"10000.0\"\n" +
          "      },\n" +
          "      {\n" +
          "        \"_links\": {\n" +
          "          \"operation\": {\n" +
          "            \"href\": \"http://frontier-testnet.digitalbits.io/operations/3964645656236033\"\n" +
          "          },\n" +
          "          \"succeeds\": {\n" +
          "            \"href\": \"http://frontier-testnet.digitalbits.io/effects?order=desc\\u0026cursor=3964645656236033-1\"\n" +
          "          },\n" +
          "          \"precedes\": {\n" +
          "            \"href\": \"http://frontier-testnet.digitalbits.io/effects?order=asc\\u0026cursor=3964645656236033-1\"\n" +
          "          }\n" +
          "        },\n" +
          "        \"id\": \"0003964645656236033-0000000001\",\n" +
          "        \"paging_token\": \"3964645656236033-1\",\n" +
          "        \"account\": \"GA43X7ERPZQUVNDVHBGN42AK3SYJRVJ7TUWQGNFVY2O74YVDQFW2KP7C\",\n" +
          "        \"type\": \"account_created\",\n" +
          "        \"type_i\": 0,\n" +
          "        \"starting_balance\": \"10000.0\"\n" +
          "      },\n" +
          "      {\n" +
          "        \"_links\": {\n" +
          "          \"operation\": {\n" +
          "            \"href\": \"http://frontier-testnet.digitalbits.io/operations/3963559029510145\"\n" +
          "          },\n" +
          "          \"succeeds\": {\n" +
          "            \"href\": \"http://frontier-testnet.digitalbits.io/effects?order=desc\\u0026cursor=3963559029510145-3\"\n" +
          "          },\n" +
          "          \"precedes\": {\n" +
          "            \"href\": \"http://frontier-testnet.digitalbits.io/effects?order=asc\\u0026cursor=3963559029510145-3\"\n" +
          "          }\n" +
          "        },\n" +
          "        \"id\": \"0003963559029510145-0000000003\",\n" +
          "        \"paging_token\": \"3963559029510145-3\",\n" +
          "        \"account\": \"GDIQJ6G5AWSBRMHIZYWVWCFN64Q4BZ4TYEAQRO5GVR4EWR23RKBJ2A4R\",\n" +
          "        \"type\": \"signer_created\",\n" +
          "        \"type_i\": 10,\n" +
          "        \"weight\": 1,\n" +
          "        \"public_key\": \"GDIQJ6G5AWSBRMHIZYWVWCFN64Q4BZ4TYEAQRO5GVR4EWR23RKBJ2A4R\"\n" +
          "      },\n" +
          "      {\n" +
          "        \"_links\": {\n" +
          "          \"operation\": {\n" +
          "            \"href\": \"http://frontier-testnet.digitalbits.io/operations/3963559029510145\"\n" +
          "          },\n" +
          "          \"succeeds\": {\n" +
          "            \"href\": \"http://frontier-testnet.digitalbits.io/effects?order=desc\\u0026cursor=3963559029510145-2\"\n" +
          "          },\n" +
          "          \"precedes\": {\n" +
          "            \"href\": \"http://frontier-testnet.digitalbits.io/effects?order=asc\\u0026cursor=3963559029510145-2\"\n" +
          "          }\n" +
          "        },\n" +
          "        \"id\": \"0003963559029510145-0000000002\",\n" +
          "        \"paging_token\": \"3963559029510145-2\",\n" +
          "        \"account\": \"GBS43BF24ENNS3KPACUZVKK2VYPOZVBQO2CISGZ777RYGOPYC2FT6S3K\",\n" +
          "        \"type\": \"account_debited\",\n" +
          "        \"type_i\": 3,\n" +
          "        \"asset_type\": \"native\",\n" +
          "        \"amount\": \"10000.0\"\n" +
          "      },\n" +
          "      {\n" +
          "        \"_links\": {\n" +
          "          \"operation\": {\n" +
          "            \"href\": \"http://frontier-testnet.digitalbits.io/operations/3963559029510145\"\n" +
          "          },\n" +
          "          \"succeeds\": {\n" +
          "            \"href\": \"http://frontier-testnet.digitalbits.io/effects?order=desc\\u0026cursor=3963559029510145-1\"\n" +
          "          },\n" +
          "          \"precedes\": {\n" +
          "            \"href\": \"http://frontier-testnet.digitalbits.io/effects?order=asc\\u0026cursor=3963559029510145-1\"\n" +
          "          }\n" +
          "        },\n" +
          "        \"id\": \"0003963559029510145-0000000001\",\n" +
          "        \"paging_token\": \"3963559029510145-1\",\n" +
          "        \"account\": \"GDIQJ6G5AWSBRMHIZYWVWCFN64Q4BZ4TYEAQRO5GVR4EWR23RKBJ2A4R\",\n" +
          "        \"type\": \"account_created\",\n" +
          "        \"type_i\": 0,\n" +
          "        \"starting_balance\": \"10000.0\"\n" +
          "      },\n" +
          "      {\n" +
          "        \"_links\": {\n" +
          "          \"operation\": {\n" +
          "            \"href\": \"http://frontier-testnet.digitalbits.io/operations/3962163165138945\"\n" +
          "          },\n" +
          "          \"succeeds\": {\n" +
          "            \"href\": \"http://frontier-testnet.digitalbits.io/effects?order=desc\\u0026cursor=3962163165138945-3\"\n" +
          "          },\n" +
          "          \"precedes\": {\n" +
          "            \"href\": \"http://frontier-testnet.digitalbits.io/effects?order=asc\\u0026cursor=3962163165138945-3\"\n" +
          "          }\n" +
          "        },\n" +
          "        \"id\": \"0003962163165138945-0000000003\",\n" +
          "        \"paging_token\": \"3962163165138945-3\",\n" +
          "        \"account\": \"GAXHEECODLEAGGSC4ERUH3YW7G47IS7TS32NZQT4YLP5FK7HQZZWLLFC\",\n" +
          "        \"type\": \"signer_created\",\n" +
          "        \"type_i\": 10,\n" +
          "        \"weight\": 1,\n" +
          "        \"public_key\": \"GAXHEECODLEAGGSC4ERUH3YW7G47IS7TS32NZQT4YLP5FK7HQZZWLLFC\"\n" +
          "      }\n" +
          "    ]\n" +
          "  }\n" +
          "}";

  String tradesJson = "{\n" +
      "  \"_links\": {\n" +
      "    \"self\": {\n" +
      "      \"href\": \"https://frontier.livenet.digitalbits.io/operations/3697472920621057/effects?cursor=\\u0026limit=2\\u0026order=asc\"\n" +
      "    },\n" +
      "    \"next\": {\n" +
      "      \"href\": \"https://frontier.livenet.digitalbits.io/operations/3697472920621057/effects?cursor=3697472920621057-2\\u0026limit=2\\u0026order=asc\"\n" +
      "    },\n" +
      "    \"prev\": {\n" +
      "      \"href\": \"https://frontier.livenet.digitalbits.io/operations/3697472920621057/effects?cursor=3697472920621057-1\\u0026limit=2\\u0026order=desc\"\n" +
      "    }\n" +
      "  },\n" +
      "  \"_embedded\": {\n" +
      "    \"records\": [\n" +
      "      {\n" +
      "        \"_links\": {\n" +
      "          \"operation\": {\n" +
      "            \"href\": \"https://frontier.livenet.digitalbits.io/operations/3697472920621057\"\n" +
      "          },\n" +
      "          \"succeeds\": {\n" +
      "            \"href\": \"https://frontier.livenet.digitalbits.io/effects?order=desc\\u0026cursor=3697472920621057-1\"\n" +
      "          },\n" +
      "          \"precedes\": {\n" +
      "            \"href\": \"https://frontier.livenet.digitalbits.io/effects?order=asc\\u0026cursor=3697472920621057-1\"\n" +
      "          }\n" +
      "        },\n" +
      "        \"id\": \"0003697472920621057-0000000001\",\n" +
      "        \"paging_token\": \"3697472920621057-1\",\n" +
      "        \"account\": \"GBB4JST32UWKOLGYYSCEYBHBCOFL2TGBHDVOMZP462ET4ZRD4ULA7S2L\",\n" +
      "        \"account_muxed\": \"MBB4JST32UWKOLGYYSCEYBHBCOFL2TGBHDVOMZP462ET4ZRD4ULA6AAAAAAAAAAAPN7BA\",\n" +
      "        \"account_muxed_id\": \"18446744073709551615\",\n" +
      "        \"type\": \"trade\",\n" +
      "        \"type_i\": 33,\n" +
      "        \"created_at\": \"2015-11-18T03:47:47Z\",\n" +
      "        \"seller\": \"GAVH5JM5OKXGMQDS7YPRJ4MQCPXJUGH26LYQPQJ4SOMOJ4SXY472ZM7G\",\n" +
      "        \"seller_muxed\": \"MAVH5JM5OKXGMQDS7YPRJ4MQCPXJUGH26LYQPQJ4SOMOJ4SXY472YAAAAAAAAAABUSON4\",\n" +
      "        \"seller_muxed_id\": \"420\",\n" +
      "        \"offer_id\": \"9\",\n" +
      "        \"sold_amount\": \"2.6700000\",\n" +
      "        \"sold_asset_type\": \"credit_alphanum4\",\n" +
      "        \"sold_asset_code\": \"JPY\",\n" +
      "        \"sold_asset_issuer\": \"GBVAOIACNSB7OVUXJYC5UE2D4YK2F7A24T7EE5YOMN4CE6GCHUTOUQXM\",\n" +
      "        \"bought_amount\": \"10.0000000\",\n" +
      "        \"bought_asset_type\": \"native\"\n" +
      "      },\n" +
      "      {\n" +
      "        \"_links\": {\n" +
      "          \"operation\": {\n" +
      "            \"href\": \"https://frontier.livenet.digitalbits.io/operations/3697472920621057\"\n" +
      "          },\n" +
      "          \"succeeds\": {\n" +
      "            \"href\": \"https://frontier.livenet.digitalbits.io/effects?order=desc\\u0026cursor=3697472920621057-2\"\n" +
      "          },\n" +
      "          \"precedes\": {\n" +
      "            \"href\": \"https://frontier.livenet.digitalbits.io/effects?order=asc\\u0026cursor=3697472920621057-2\"\n" +
      "          }\n" +
      "        },\n" +
      "        \"id\": \"0003697472920621057-0000000002\",\n" +
      "        \"paging_token\": \"3697472920621057-2\",\n" +
      "        \"account\": \"GAVH5JM5OKXGMQDS7YPRJ4MQCPXJUGH26LYQPQJ4SOMOJ4SXY472ZM7G\",\n" +
      "        \"type\": \"trade\",\n" +
      "        \"type_i\": 33,\n" +
      "        \"created_at\": \"2015-11-18T03:47:47Z\",\n" +
      "        \"seller\": \"GBB4JST32UWKOLGYYSCEYBHBCOFL2TGBHDVOMZP462ET4ZRD4ULA7S2L\",\n" +
      "        \"offer_id\": \"9\",\n" +
      "        \"sold_amount\": \"10.0000000\",\n" +
      "        \"sold_asset_type\": \"native\",\n" +
      "        \"bought_amount\": \"2.6700000\",\n" +
      "        \"bought_asset_type\": \"credit_alphanum4\",\n" +
      "        \"bought_asset_code\": \"JPY\",\n" +
      "        \"bought_asset_issuer\": \"GBVAOIACNSB7OVUXJYC5UE2D4YK2F7A24T7EE5YOMN4CE6GCHUTOUQXM\"\n" +
      "      }\n" +
      "    ]\n" +
      "  }\n" +
      "}";
}
