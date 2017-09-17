package com.diegomalone.neontest.network.restclient;

import com.diegomalone.neontest.network.response.TransferResponse;

import java.util.List;

import retrofit2.Response;
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
    Observable<String> generateToken(@Query("email") String email,
                                     @Query("nome") String name);

    @POST("SendMoney")
    @FormUrlEncoded
    Observable<String> sendMoney(@Field("ClienteId") int contactId,
                                 @Field("token") String token,
                                 @Field("valor") Double value);

    @GET("GetTransfers")
    Observable<Response<List<TransferResponse>>> getTransfers(@Query("token") String token);
}
