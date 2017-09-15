package com.diegomalone.neontest.network.restclient;

import com.diegomalone.neontest.network.response.StringResponse;
import com.diegomalone.neontest.network.response.TransferListResponse;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Diego Malone on 15/09/17.
 */

public interface TransferRestClient {

    @GET("GenerateToken")
    Observable<StringResponse> generateToken(@Query("email") String email,
                                             @Query("name") String name);

    @POST("SendMoney")
    @FormUrlEncoded
    Observable<StringResponse> sendMoney(@Field("clientId") String clientId,
                                         @Field("token") String token,
                                         @Field("value") Double value);

    @GET("GetTransfers")
    Observable<TransferListResponse> getTransfers(@Query("token") String token);
}
