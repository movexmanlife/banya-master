package com.forezp.banya.api;

/**
 *
 * Singleton Factory with retrofit
 */
public class ApiFactory {

    static DoubanService mDoubanService = null;

    //return Singleton
    public static DoubanService getDoubanServiceInstance() {
        if (mDoubanService == null) {
            synchronized (ApiFactory.class) {
                if (mDoubanService == null) {
                    mDoubanService = new ApiRetrofit().getDoubanService();
                }
            }
        }

        return mDoubanService;
    }
}
