package tahadeta.example.quickstartandroid.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import tahadeta.example.quickstartandroid.R
import tahadeta.example.quickstartandroid.databinding.FragmentDetailsBinding
import tahadeta.example.quickstartandroid.model.News
import tahadeta.example.quickstartandroid.ui.home.adapter.IconAdapter
import tahadeta.example.quickstartandroid.util.actualNews

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding


   lateinit var news: News


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
            R.layout.fragment_details,
            container,
            false
        )

        initComponents()

        return binding.root
    }

    private fun initComponents() {
        news = actualNews

        binding.bigTitle.setText(actualNews.title)
        binding.bigDescription.setText(actualNews.description)
        binding.datePublish.setText(actualNews.publishedDate)
        IconAdapter.adaptIcon(binding.logoLeague, actualNews.idLeague.toString())
    }
}
