package io.digitalbits.sdk.requests;


import com.google.common.base.Optional;

/**
 * Exception thrown when too many requests were sent to the Frontier server.
 * @see <a href="https://developers.digitalbits.io/frontier/learn/rate-limiting.html" target="_blank">Rate Limiting</a>
 */
public class TooManyRequestsException extends RuntimeException {
  private Integer retryAfter;

  public TooManyRequestsException(Integer retryAfter) {
    super("The rate limit for the requesting IP address is over its alloted limit.");
    this.retryAfter = retryAfter;
  }

  /**
   * Returns number of seconds a client should wait before sending requests again,
   * or -1 this time is unknown.
   */
  public Optional<Integer> getRetryAfter() {
    return Optional.fromNullable(retryAfter);
  }
}
