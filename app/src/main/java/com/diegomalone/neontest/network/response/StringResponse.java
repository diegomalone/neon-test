package com.diegomalone.neontest.network.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Diego Malone on 15/09/17.
 */

public class StringResponse extends BaseApiResponse {

    private String token;

    public StringResponse(String token) {
        this.token = token;
    }

    public StringResponse(boolean hasError) {
        super(hasError);
    }

    public String getValue() {
        return token;
    }

    @Override
    public String toString() {
        return "StringResponse{" +
                "token='" + token + '\'' +
                '}';
    }
}
