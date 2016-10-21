package com.forezp.banya.api;


import com.forezp.banya.MyApp;

import java.io.File;
import java.util.concurrent.TimeUnit;

import forezp.com.douyalibrary.utils.NetUtils;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 *
 */
public class ApiRetrofit {

    public DoubanService mDoubanService;

    public static final String DOUBAN_BASE_URL = "https://api.douban.com/";

    public DoubanService getDoubanService() {
        return mDoubanService;
    }

    ApiRetrofit() {
        //cache url
        File httpCacheDirectory = new File(MyApp.mMyApp.getCacheDir(), "responses");
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(httpCacheDirectory, cacheSize);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR)
                .cache(cache)
                        .build();

        Retrofit retrofit_zhihu = new Retrofit.Builder()
                .baseUrl(DOUBAN_BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();


        mDoubanService = retrofit_zhihu.create(DoubanService.class);

    }


    Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = chain -> {

        CacheControl.Builder cacheBuilder = new CacheControl.Builder();
        cacheBuilder.maxAge(0, TimeUnit.SECONDS);
        cacheBuilder.maxStale(365, TimeUnit.DAYS);
        CacheControl cacheControl = cacheBuilder.build();

        Request request = chain.request();
        if (!NetUtils.checkNetWorkIsAvailable(MyApp.mMyApp)) {
            request = request.newBuilder()
                    .cacheControl(cacheControl)
                    .build();

        }
        Response originalResponse = chain.proceed(request);
        if (NetUtils.checkNetWorkIsAvailable(MyApp.mMyApp)) {
            int maxAge = 0; // read from cache
            return originalResponse.newBuilder()
                    .removeHeader("Pragma")
                    .header("Cache-Control", "public ,max-age=" + maxAge)
                    .build();
        } else {
            int maxStale = 60 * 60 * 24 * 28; // tolerate 4-weeks stale
            return originalResponse.newBuilder()
                    .removeHeader("Pragma")
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                    .build();
        }
    };
}
