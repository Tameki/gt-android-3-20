package com.geektech.boredapp_20.data.remote;

import android.util.Log;

import com.geektech.boredapp_20.core.CoreCallback;
import com.geektech.boredapp_20.model.BoredAction;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class BoredApiClient {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://www.boredapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    BoredApi client = retrofit.create(BoredApi.class);

    public void getAction(
            String type,
            Float minPrice,
            BoredActionCallback callback
    ) {
        Call<BoredAction> call = client.getAction(
                type,
                minPrice
        );

        Log.d("ololo", call.request().url().toString());

        call.enqueue(new CoreCallback<BoredAction>() {
            @Override
            public void onSuccess(BoredAction result) {
                callback.onSuccess(result);
            }

            @Override
            public void onFailure(Exception exception) {
                callback.onFailure(exception);
            }
        });
    }

    public interface BoredActionCallback extends BaseCallback<BoredAction> { }

    public interface BaseCallback<T> {
        void onSuccess(T result);
        void onFailure(Exception exception);
    }

    private interface BoredApi {
        @GET("api/activity/")
        Call<BoredAction> getAction(
                @Query("type") String type,
                @Query("minprice") Float minPrice
        );
    }
}
