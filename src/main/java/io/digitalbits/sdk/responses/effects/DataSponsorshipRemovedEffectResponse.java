package io.digitalbits.sdk.responses.effects;


import com.google.gson.annotations.SerializedName;

/**
 * Represents data_sponsorship_removed effect response.
 * @see <a href="https://developers.digitalbits.io/frontier/reference/resources/effect.html" target="_blank">Effect documentation</a>
 * @see io.digitalbits.sdk.requests.EffectsRequestBuilder
 * @see io.digitalbits.sdk.Server#effects()
 */
public class DataSponsorshipRemovedEffectResponse extends EffectResponse {
  @SerializedName("former_sponsor")
  private final String formerSponsor;
  @SerializedName("data_name")
  private final String dataName;

  public DataSponsorshipRemovedEffectResponse(String dataName, String formerSponsor) {
    this.dataName = dataName;
    this.formerSponsor = formerSponsor;
  }

  public String getFormerSponsor() {
    return formerSponsor;
  }
  public String getDataName() {
    return dataName;
  }
}
