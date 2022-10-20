package tahadeta.example.quickstartandroid.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import tahadeta.example.quickstartandroid.R
import tahadeta.example.quickstartandroid.databinding.FragmentHomeBinding
import tahadeta.example.quickstartandroid.model.News
import tahadeta.example.quickstartandroid.net.RetrofitHelper
import tahadeta.example.quickstartandroid.net.ServicesApi

class HomeFragment : Fragment() {

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
        val quotesApi = RetrofitHelper.getInstance().create(ServicesApi::class.java)
        // launching a new coroutine
        GlobalScope.launch {
            val result = quotesApi.getNews()
            if (result != null) {
                result.body()!!.results.forEach {
                    // Create our object in a mutable array list
                    val actualNew = News(it.idNews, it.idCountry, it.idLeague, it.title, it.description, it.publishedDate)
                    mutableList.add(it.idNews?.toInt() ?: 0, actualNew)
                }
            }
        }
    }
}
