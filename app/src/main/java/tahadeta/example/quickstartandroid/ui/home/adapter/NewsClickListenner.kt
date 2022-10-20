package tahadeta.example.quickstartandroid.ui.home.adapter

import tahadeta.example.quickstartandroid.model.News

interface NewsClickListenner {
    fun onItemClick(position: Int, news: News)
}
