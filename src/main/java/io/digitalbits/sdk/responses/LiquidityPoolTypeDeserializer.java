package io.digitalbits.sdk.responses;

import com.google.gson.*;
import io.digitalbits.sdk.xdr.LiquidityPoolType;

import java.lang.reflect.Type;

public class LiquidityPoolTypeDeserializer implements JsonDeserializer<LiquidityPoolType> {
  @Override
  public LiquidityPoolType deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
    String s = json.getAsString();
    if (s.equals("constant_product")) {
      return LiquidityPoolType.LIQUIDITY_POOL_CONSTANT_PRODUCT;
    }

    throw new IllegalArgumentException("Unsupported liquidity pool type: "+json.toString());
  }

}
