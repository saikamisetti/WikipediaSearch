package com.moneytap.network;

import com.moneytap.model.PageDetailAdapter;
import com.squareup.moshi.Moshi;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

/**
 * This class is to setup the retrofit client.
 */
public class NetworkAdapter {
  public static final String BASE_URL = "https://my-json-server.typicode.com/iranjith4/";

  private static Retrofit retrofit = null;

  public static Retrofit getClient() {
    if (retrofit == null) {
      HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
      loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
      OkHttpClient client = new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();

      Moshi moshi = new Moshi.Builder()
          .add(new PageDetailAdapter(new Moshi.Builder().build()))
          .build();
      retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
          .client(client)
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .addConverterFactory(MoshiConverterFactory.create(moshi))
          .build();
    }
    return retrofit;
  }
}
