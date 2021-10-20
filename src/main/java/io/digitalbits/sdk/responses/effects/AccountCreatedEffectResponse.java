package io.digitalbits.sdk.responses.effects;

import com.google.gson.annotations.SerializedName;

/**
 * Represents account_created effect response.
 * @see <a href="https://developers.digitalbits.io/frontier/reference/resources/effect.html" target="_blank">Effect documentation</a>
 * @see io.digitalbits.sdk.requests.EffectsRequestBuilder
 * @see io.digitalbits.sdk.Server#effects()
 */
public class AccountCreatedEffectResponse extends EffectResponse {
  @SerializedName("starting_balance")
  protected final String startingBalance;

  AccountCreatedEffectResponse(String startingBalance) {
    this.startingBalance = startingBalance;
  }

  public String getStartingBalance() {
    return startingBalance;
  }
}
