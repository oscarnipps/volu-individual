package com.example.volu.di;

public class NetworkModule {

/*    @Provides
    static Retrofit providesRetrofit(OkHttpClient okHttpClient, GsonConverterFactory gsonConverterFactory) {
        return new Retrofit.Builder()
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Constants.DATABASE_NAME)
                .client(okHttpClient)
                .build();
    }

    @Provides
    static OkHttpClient providesOkHttp(Application appContext, List<Interceptor> interceptors, Cache cache) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        for (Interceptor interceptor : interceptors) {
            builder.addInterceptor(interceptor);
        }

        return builder
                .readTimeout(60, TimeUnit.SECONDS)
                .cache(cache)
                .build();
    }


    @Provides
    public static Cache providesCache(Application appContext) {
        //cache size of 10mb
        long cacheSize = 10 * 1024 * 1024;

        Cache cache = new Cache(appContext.getCacheDir(), cacheSize);

        return cache;
    }


    @Provides
    static List<Interceptor> provideInterceptors(Application appContext) {
        List<Interceptor> interceptors = new ArrayList<>();

        interceptors.add(new VoluNetworkInterceptor());

        //todo: add logging only if the build version is debug
        interceptors.add(new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY));

        return interceptors;
    }

    @Singleton
    @Provides
    static GsonConverterFactory provideGsonConverterFactory() {
        //customize to exclude fields
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();

        return GsonConverterFactory.create(gson);
    }*/
}
