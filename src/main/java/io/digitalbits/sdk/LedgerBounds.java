package io.digitalbits.sdk;

import lombok.Value;
import io.digitalbits.sdk.xdr.Uint32;

@Value
@lombok.Builder
/**
 * LedgerBounds are Preconditions of a transaction per <a href="https://github.com/xdbfoundation/digitalbits-protocol/blob/master/core/cap-0021.md#specification">CAP-21<a/>
 */
public class LedgerBounds {
    int minLedger;
    int maxLedger;

    public static LedgerBounds fromXdr(io.digitalbits.sdk.xdr.LedgerBounds xdrLedgerBounds) {
        return new LedgerBoundsBuilder()
                .minLedger(xdrLedgerBounds.getMinLedger().getUint32())
                .maxLedger(xdrLedgerBounds.getMaxLedger().getUint32()).build();
    }

    public io.digitalbits.sdk.xdr.LedgerBounds toXdr() {
        return new io.digitalbits.sdk.xdr.LedgerBounds.Builder()
                .maxLedger(new Uint32(maxLedger))
                .minLedger(new Uint32(minLedger)).build();
    }
}
