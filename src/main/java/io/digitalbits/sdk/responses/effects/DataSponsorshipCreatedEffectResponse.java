package io.digitalbits.sdk.responses.effects;


import com.google.gson.annotations.SerializedName;

/**
 * Represents data_sponsorship_created effect response.
 * @see <a href="https://developers.digitalbits.io/frontier/reference/resources/effect.html" target="_blank">Effect documentation</a>
 * @see io.digitalbits.sdk.requests.EffectsRequestBuilder
 * @see io.digitalbits.sdk.Server#effects()
 */
public class DataSponsorshipCreatedEffectResponse extends EffectResponse {
  @SerializedName("sponsor")
  private final String sponsor;

  @SerializedName("data_name")
  private final String dataName;

  public DataSponsorshipCreatedEffectResponse(String dataName, String sponsor) {
    this.dataName = dataName;
    this.sponsor = sponsor;
  }

  public String getSponsor() {
    return sponsor;
  }

  public String getDataName() {
    return dataName;
  }
}
