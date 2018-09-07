package inburst.com.osrshelper.Networking;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * lennyhicks
 * 9/4/18
 */
public class RetrofitRuneScapeDb {

    private static Retrofit retrofit;
    private static final String BASE_URL = "http://services.runescape.com/m=itemdb_rs/api/catalogue/detail.json/";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit =
                    new retrofit2.Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
        }
        return retrofit;
    }
}
