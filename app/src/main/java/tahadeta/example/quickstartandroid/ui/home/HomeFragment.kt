package tahadeta.example.quickstartandroid.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import tahadeta.example.quickstartandroid.R
import tahadeta.example.quickstartandroid.databinding.FragmentHomeBinding
import tahadeta.example.quickstartandroid.model.News
import tahadeta.example.quickstartandroid.net.RetrofitHelper
import tahadeta.example.quickstartandroid.net.ServicesApi
import tahadeta.example.quickstartandroid.ui.home.adapter.NewsAdapter
import tahadeta.example.quickstartandroid.ui.home.adapter.NewsClickListenner
import java.util.ArrayList

class HomeFragment : Fragment(), NewsClickListenner {

    private lateinit var newsAdapter: NewsAdapter
    lateinit var newsClickListenner: NewsClickListenner
    private lateinit var binding: FragmentHomeBinding
    var mutableList: MutableList<News> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_home,
            container,
            false
        )

        initComponents()

        return binding.root
    }

    private fun initComponents() {

        getData()
    }

    private fun getData() {

        newsClickListenner = this
        val quotesApi = RetrofitHelper.getInstance().create(ServicesApi::class.java)
        // launching a new coroutine$

        GlobalScope.launch {
            val result = quotesApi.getNews()
            if (result != null) {
                result.body()!!.results.forEach {
                    Log.d("TESTAPP", "inside foreachj")
                    // Create our object in a mutable array list
                    val actualNew = News(
                        it.idNews,
                        it.idCountry,
                        it.idLeague,
                        it.title,
                        it.description,
                        it.publishedDate
                    )
                    mutableList.add(it.idNews?.toInt() ?: 0, actualNew)
                }
            }

            withContext(Dispatchers.Main) {
                newsAdapter = NewsAdapter(
                    requireContext(),
                    mutableList as ArrayList<News>,
                    newsClickListenner
                )

                binding.list.apply {
                    layoutManager = GridLayoutManager(this.context, 1)
                    adapter = newsAdapter
                }

                binding.list.scheduleLayoutAnimation()
            }
        }
    }

    override fun onItemClick(position: Int, news: News) {
    }
}
