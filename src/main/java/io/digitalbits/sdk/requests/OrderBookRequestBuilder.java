package io.digitalbits.sdk.requests;

import com.google.gson.reflect.TypeToken;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import io.digitalbits.sdk.Asset;
import io.digitalbits.sdk.AssetTypeCreditAlphaNum;
import io.digitalbits.sdk.responses.OrderBookResponse;

import java.io.IOException;

/**
 * Builds requests connected to order book.
 */
public class OrderBookRequestBuilder extends RequestBuilder {
  public OrderBookRequestBuilder(OkHttpClient httpClient, HttpUrl serverURI) {
    super(httpClient, serverURI, "order_book");
  }

  public OrderBookRequestBuilder buyingAsset(Asset asset) {
    uriBuilder.setQueryParameter("buying_asset_type", asset.getType());
    if (asset instanceof AssetTypeCreditAlphaNum) {
      AssetTypeCreditAlphaNum creditAlphaNumAsset = (AssetTypeCreditAlphaNum) asset;
      uriBuilder.setQueryParameter("buying_asset_code", creditAlphaNumAsset.getCode());
      uriBuilder.setQueryParameter("buying_asset_issuer", creditAlphaNumAsset.getIssuer());
    }
    return this;
  }
  
  public OrderBookRequestBuilder sellingAsset(Asset asset) {
    uriBuilder.setQueryParameter("selling_asset_type", asset.getType());
    if (asset instanceof AssetTypeCreditAlphaNum) {
      AssetTypeCreditAlphaNum creditAlphaNumAsset = (AssetTypeCreditAlphaNum) asset;
      uriBuilder.setQueryParameter("selling_asset_code", creditAlphaNumAsset.getCode());
      uriBuilder.setQueryParameter("selling_asset_issuer", creditAlphaNumAsset.getIssuer());
    }
    return this;
  }

  public static OrderBookResponse execute(OkHttpClient httpClient, HttpUrl uri) throws IOException, TooManyRequestsException {
    TypeToken type = new TypeToken<OrderBookResponse>() {};
    ResponseHandler<OrderBookResponse> responseHandler = new ResponseHandler<OrderBookResponse>(type);

    Request request = new Request.Builder().get().url(uri).build();
    Response response = httpClient.newCall(request).execute();

    return responseHandler.handleResponse(response);
  }

  /**
   * Allows to stream SSE events from frontier.
   * Certain endpoints in Frontier can be called in streaming mode using Server-Sent Events.
   * This mode will keep the connection to frontier open and frontier will continue to return
   * responses as ledgers close.
   * @see <a href="http://www.w3.org/TR/eventsource/" target="_blank">Server-Sent Events</a>
   * @see <a href="https://developers.digitalbits.io/frontier/learn/responses.html" target="_blank">Response Format documentation</a>
   * @param listener {@link OrderBookResponse} implementation with {@link OrderBookResponse} type
   * @return EventSource object, so you can <code>close()</code> connection when not needed anymore
   */
  public SSEStream<OrderBookResponse> stream(final EventListener<OrderBookResponse> listener) {
    return SSEStream.create(httpClient,this,OrderBookResponse.class,listener);
  }

  public OrderBookResponse execute() throws IOException, TooManyRequestsException {
    return this.execute(this.httpClient, this.buildUri());
  }

  @Override
  public RequestBuilder cursor(String cursor) {
    throw new RuntimeException("Not implemented yet.");
  }

  @Override
  public RequestBuilder order(Order direction) {
    throw new RuntimeException("Not implemented yet.");
  }
}
