package tahadeta.example.quickstartandroid.net

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tahadeta.example.quickstartandroid.util.Constants.BASE_URL

object RetrofitHelper {

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            // we need to add converter factory to
            // convert JSON object to Java object
            .build()
    }
}
