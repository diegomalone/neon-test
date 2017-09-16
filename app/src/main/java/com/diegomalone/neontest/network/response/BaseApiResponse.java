package com.diegomalone.neontest.network.response;

/**
 * Created by Diego Malone on 15/09/17.
 */

public abstract class BaseApiResponse<T> {

    protected boolean mHasError;

    public BaseApiResponse() {
    }

    public BaseApiResponse(boolean hasError) {
        this.mHasError = hasError;
    }

    public boolean hasErrorOcurred() {
        return mHasError;
    }

    public abstract T toModel();
}
