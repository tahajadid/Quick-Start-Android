package tahadeta.example.quickstartandroid.model

import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("page") var page: Int? = null,
    @SerializedName("results") var results: ArrayList<News> = arrayListOf()
)
