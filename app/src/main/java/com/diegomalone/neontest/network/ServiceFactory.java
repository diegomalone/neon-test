package com.diegomalone.neontest.network;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Diego Malone on 15/09/17.
 */

public class ServiceFactory {

    private static Map<String, Object> mServices = new HashMap<>();

    private static ServiceFactory mInstance;

    private Context mContext;

    public ServiceFactory(Context context) {
        this.mContext = context;
    }

    public static ServiceFactory getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new ServiceFactory(context);
        }

        return mInstance;
    }

    public <T> T getService(Class<T> clazz, String url) {
        if (mServices.get(clazz.getSimpleName()) == null) {
            Retrofit.Builder builder = getRestAdapterBuilder(url);

            mServices.put(clazz.getSimpleName(), builder.build().create(clazz));
        }

        return (T) mServices.get(clazz.getSimpleName());
    }

    private Retrofit.Builder getRestAdapterBuilder(String url) {

        // Logging interceptor
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();

        Retrofit.Builder builder = new Retrofit.Builder()
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(url);

        return builder;
    }
}
