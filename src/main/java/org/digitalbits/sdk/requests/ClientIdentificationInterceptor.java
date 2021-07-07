package io.digitalbits.sdk.requests;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import io.digitalbits.sdk.Util;

import java.io.IOException;

public class ClientIdentificationInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        Request requestWithHeaders;

        requestWithHeaders = originalRequest.newBuilder()
                .addHeader("X-Client-Name", "java-digitalbits-sdk")
                .addHeader("X-Client-Version", Util.getSdkVersion())
                .build();
        return chain.proceed(requestWithHeaders);
    }
}
