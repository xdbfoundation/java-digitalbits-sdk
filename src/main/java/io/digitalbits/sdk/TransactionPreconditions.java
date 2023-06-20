package io.digitalbits.sdk;

import lombok.Builder;
import lombok.NonNull;
import lombok.Singular;
import lombok.Value;
import io.digitalbits.sdk.xdr.Duration;
import io.digitalbits.sdk.xdr.Int64;
import io.digitalbits.sdk.xdr.PreconditionType;
import io.digitalbits.sdk.xdr.Preconditions;
import io.digitalbits.sdk.xdr.PreconditionsV2;
import io.digitalbits.sdk.xdr.SequenceNumber;
import io.digitalbits.sdk.xdr.SignerKey;
import io.digitalbits.sdk.xdr.Uint32;
import io.digitalbits.sdk.xdr.Uint64;

import java.util.Arrays;
import java.util.List;

@Value
@Builder(toBuilder=true)
/**
 * Preconditions of a transaction per <a href="https://github.com/xdbfoundation/digitalbits-protocol/blob/master/core/cap-0021.md#specification">CAP-21<a/>
 */
public class TransactionPreconditions {
    public static final long MAX_EXTRA_SIGNERS_COUNT = 2;
    public static final long TIMEOUT_INFINITE = 0;

    LedgerBounds ledgerBounds;
    Long minSeqNumber;
    long minSeqAge;
    int minSeqLedgerGap;
    @Singular
    @NonNull
    List<SignerKey> extraSigners;
    TimeBounds timeBounds;

    public void isValid() {
        if (timeBounds == null) {
            throw new FormatException("Invalid preconditions, must define timebounds");
        }

        if (extraSigners.size() > MAX_EXTRA_SIGNERS_COUNT) {
            throw new FormatException("Invalid preconditions, too many extra signers, can only have up to " + MAX_EXTRA_SIGNERS_COUNT);
        }
    }

    public boolean hasV2() {
        return (ledgerBounds != null ||
                (minSeqLedgerGap > 0) ||
                (minSeqAge > 0) ||
                minSeqNumber != null ||
                !extraSigners.isEmpty());
    }

    public static TransactionPreconditions fromXdr(Preconditions preconditions) {
        TransactionPreconditionsBuilder builder = new TransactionPreconditionsBuilder();

        if (preconditions.getDiscriminant().equals(PreconditionType.PRECOND_V2)) {
            if (preconditions.getV2().getTimeBounds() != null) {
                builder.timeBounds(new TimeBounds(
                        preconditions.getV2().getTimeBounds().getMinTime().getTimePoint().getUint64(),
                        preconditions.getV2().getTimeBounds().getMaxTime().getTimePoint().getUint64()));
            }
            if (preconditions.getV2().getExtraSigners() != null && preconditions.getV2().getExtraSigners().length > 0) {
                builder.extraSigners(Arrays.asList(preconditions.getV2().getExtraSigners()));
            }
            if (preconditions.getV2().getMinSeqAge() != null) {
                builder.minSeqAge(preconditions.getV2().getMinSeqAge().getDuration().getUint64());
            }
            if (preconditions.getV2().getLedgerBounds() != null) {
                builder.ledgerBounds(LedgerBounds.fromXdr(preconditions.getV2().getLedgerBounds()));
            }
            if (preconditions.getV2().getMinSeqNum() != null) {
                builder.minSeqNumber(preconditions.getV2().getMinSeqNum().getSequenceNumber().getInt64());
            }
            if (preconditions.getV2().getMinSeqLedgerGap() != null) {
                builder.minSeqLedgerGap(preconditions.getV2().getMinSeqLedgerGap().getUint32());
            }
        } else {
            if (preconditions.getTimeBounds() != null) {
                builder.timeBounds(new TimeBounds(preconditions.getTimeBounds().getMinTime().getTimePoint().getUint64(),
                        preconditions.getTimeBounds().getMaxTime().getTimePoint().getUint64()));
            }
        }

        return builder.build();
    }

    public Preconditions toXdr() {
        Preconditions.Builder preconditionsBuilder = new Preconditions.Builder();

        if (hasV2()) {
            preconditionsBuilder.discriminant(PreconditionType.PRECOND_V2);
            PreconditionsV2.Builder v2Builder = new PreconditionsV2.Builder();

            v2Builder.extraSigners(extraSigners.toArray(new SignerKey[]{}));
            v2Builder.minSeqAge(new Duration(new Uint64(minSeqAge)));

            if (ledgerBounds != null) {
                v2Builder.ledgerBounds(new io.digitalbits.sdk.xdr.LedgerBounds.Builder()
                        .minLedger(new Uint32(ledgerBounds.getMinLedger()))
                        .maxLedger(new Uint32(ledgerBounds.getMaxLedger()))
                        .build());
            }
            if (minSeqNumber != null) {
                v2Builder.minSeqNum(new SequenceNumber(new Int64(minSeqNumber)));
            }

            v2Builder.minSeqLedgerGap(new Uint32(minSeqLedgerGap));

            if (timeBounds != null) {
                v2Builder.timeBounds(timeBounds.toXdr());
            }
            preconditionsBuilder.v2(v2Builder.build());
        } else {
            if (timeBounds == null) {
                preconditionsBuilder.discriminant(PreconditionType.PRECOND_NONE);
            } else {
                preconditionsBuilder.discriminant(PreconditionType.PRECOND_TIME);
                preconditionsBuilder.timeBounds(timeBounds.toXdr());
            }
        }

        return preconditionsBuilder.build();
    }
}
