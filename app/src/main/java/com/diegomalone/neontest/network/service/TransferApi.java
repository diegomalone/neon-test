package com.diegomalone.neontest.network.service;

import android.content.Context;

import com.diegomalone.neontest.R;
import com.diegomalone.neontest.network.ServiceFactory;
import com.diegomalone.neontest.network.response.TransferListResponse;
import com.diegomalone.neontest.network.restclient.TransferRestClient;

import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Diego Malone on 15/09/17.
 */

public class TransferApi {

    private final String TAG = getClass().getSimpleName();

    private ServiceFactory mServiceFactory;

    private TransferRestClient mTransferRestClient;

    public TransferApi(Context context) {
        mServiceFactory = ServiceFactory.getInstance(context);

        mTransferRestClient = mServiceFactory.getService(TransferRestClient.class, context.getString(R.string.base_api_url));
    }

    public Observable<String> generateToken(String email, String name) {
        return mTransferRestClient.generateToken(email, name)
                .subscribeOn(Schedulers.io());
    }

    public Observable<String> sendMoney(String clientId, String token, Double value) {
        return mTransferRestClient.sendMoney(clientId, token, value)
                .subscribeOn(Schedulers.io());
    }

    public Observable<TransferListResponse> getTransfers(String token) {
        return mTransferRestClient.getTransfers(token)
                .subscribeOn(Schedulers.io())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends TransferListResponse>>() {
                    @Override
                    public Observable<? extends TransferListResponse> call(Throwable throwable) {
                        return Observable.just(new TransferListResponse(true));
                    }
                });
    }
}
