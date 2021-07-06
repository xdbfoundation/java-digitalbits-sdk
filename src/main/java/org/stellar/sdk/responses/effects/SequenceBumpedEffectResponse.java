package io.digitalbits.sdk.responses.effects;

import com.google.gson.annotations.SerializedName;

/**
 * Represents sequence_bumped effect response.
 * @see <a href="https://developers.digitalbits.io/frontier/reference/resources/effect.html" target="_blank">Effect documentation</a>
 * @see io.digitalbits.sdk.requests.EffectsRequestBuilder
 * @see io.digitalbits.sdk.Server#effects()
 */
public class SequenceBumpedEffectResponse extends EffectResponse {
    @SerializedName("new_seq")
    protected final Long newSequence;

    public SequenceBumpedEffectResponse(Long newSequence) {
        this.newSequence = newSequence;
    }

    public Long getNewSequence() {
        return newSequence;
    }
}
