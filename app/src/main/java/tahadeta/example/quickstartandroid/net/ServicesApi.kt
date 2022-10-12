package tahadeta.example.quickstartandroid.net

import retrofit2.Response
import retrofit2.http.GET
import tahadeta.example.quickstartandroid.model.News

interface ServicesApi {
    @GET("/news")
    suspend fun getQuotes(): Response<News>
}
