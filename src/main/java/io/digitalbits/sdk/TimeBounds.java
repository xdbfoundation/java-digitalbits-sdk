package io.digitalbits.sdk;

import com.google.common.base.Objects;
import io.digitalbits.sdk.xdr.TimePoint;
import io.digitalbits.sdk.xdr.Uint64;

/**
 * <p>TimeBounds represents the time interval that a transaction is valid.</p>
 * @see Transaction
 */
final public class TimeBounds {
	final private long mMinTime;
	final private long mMaxTime;

	/**
	 * @param minTime 64bit Unix timestamp
	 * @param maxTime 64bit Unix timestamp
	 */
	public TimeBounds(long minTime, long maxTime) {
		if (minTime < 0) {
			throw new IllegalArgumentException("minTime cannot be negative");
		}

		if (maxTime < 0) {
			throw new IllegalArgumentException("maxTime cannot be negative");
		}

		if (maxTime != 0 && minTime > maxTime) {
			throw new IllegalArgumentException("minTime must be >= maxTime");
		}

		mMinTime = minTime;
		mMaxTime = maxTime;
	}

	/**
	 * A factory method that sets maxTime to the specified second from now.
	 *
	 * @param timeout Timeout in seconds.
	 * @return TimeBounds
	 */
	public static TimeBounds expiresAfter(long timeout) {
		long now = System.currentTimeMillis() / 1000L;
		long endTime = now + timeout;
		return new TimeBounds(0, endTime);
	}

	public long getMinTime() {
		return mMinTime;
	}

	public long getMaxTime() {
		return mMaxTime;
	}

	public static TimeBounds fromXdr(io.digitalbits.sdk.xdr.TimeBounds timeBounds) {
		if (timeBounds == null) {
			return null;
		}

		return new TimeBounds(
				timeBounds.getMinTime().getTimePoint().getUint64(),
				timeBounds.getMaxTime().getTimePoint().getUint64()
		);
	}

	public io.digitalbits.sdk.xdr.TimeBounds toXdr() {
		io.digitalbits.sdk.xdr.TimeBounds timeBounds = new io.digitalbits.sdk.xdr.TimeBounds();
		TimePoint minTime = new TimePoint();
		TimePoint maxTime = new TimePoint();
		Uint64 minTimeTemp = new Uint64();
		Uint64 maxTimeTemp = new Uint64();
		minTimeTemp.setUint64(mMinTime);
		maxTimeTemp.setUint64(mMaxTime);
		minTime.setTimePoint(minTimeTemp);
		maxTime.setTimePoint(maxTimeTemp);
		timeBounds.setMinTime(minTime);
		timeBounds.setMaxTime(maxTime);
		return timeBounds;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		TimeBounds that = (TimeBounds) o;
		return mMinTime == that.mMinTime && mMaxTime == that.mMaxTime;
	}


	@Override
	public int hashCode() {
		return Objects.hashCode(
				this.mMaxTime,
				this.mMinTime
		);
	}
}
