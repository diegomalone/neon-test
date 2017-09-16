package com.diegomalone.neontest.network.response;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diego Malone on 16/09/17.
 */

public class ApiResponseConverter<T> {

    private final String TAG = getClass().getSimpleName();

    public List<T> getModelList(List<? extends BaseApiResponse> baseApiResponseList) {
        List<T> newApiResponseList = new ArrayList<>();

        for (BaseApiResponse<T> baseApiResponse : baseApiResponseList) {
            newApiResponseList.add(baseApiResponse.toModel());
        }

        return newApiResponseList;
    }
}
