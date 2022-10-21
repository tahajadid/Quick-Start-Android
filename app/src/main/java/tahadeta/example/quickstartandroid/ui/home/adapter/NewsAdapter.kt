package tahadeta.example.quickstartandroid.ui.home.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import tahadeta.example.quickstartandroid.R
import tahadeta.example.quickstartandroid.model.News
import tahadeta.example.quickstartandroid.util.actualNews
import java.util.ArrayList

class NewsAdapter(
    private val context: Context?,
    private var listOfNews: ArrayList<News>,
    private val newsClickListenner: NewsClickListenner

) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    /**
     * Find all the views of the list item
     */
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        lateinit var title: TextView
        lateinit var description: TextView
        lateinit var date: TextView
        lateinit var league: ImageView
        lateinit var nextBtn: ImageView

        /**
         * Show the data in the views
         */
        @SuppressLint("SetTextI18n")
        fun bindView(item: News, position: Int, newsClickListenner: NewsClickListenner) {

            title = itemView.findViewById(R.id.title)
            description = itemView.findViewById(R.id.description)
            league = itemView.findViewById(R.id.logo_league)
            date = itemView.findViewById(R.id.date)

            IconAdapter.adaptIcon(league, item.idLeague.toString())

            title.setText(item.title)
            description.setText((item.description?.substring(0, 15) ?: " ") + " ...")
            date.setText(item.publishedDate)

            itemView.setOnClickListener {
                actualNews = item
                Log.d("LoglALL", actualNews.idNews.toString())

                itemView.findNavController().navigate(R.id.detailsFragment)
            }
        }
    }

    override fun getItemCount(): Int = listOfNews.size

    /**
     * Inside this method data will be displayed at the specified position
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listOfNews[position]
        holder.setIsRecyclable(false)
        holder.bindView(item, position, newsClickListenner)
    }

    /**
     * Inside this method we specify the layout that each item of the RecyclerView should use
     * onCreateViewHolder has return type of RecyclerView.ViewHolder which represent each row of recyclerView.
     * Using Inflator get the view of above defined custom_new_item and pass it to viewholder
     * constructor and then return.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(context).inflate(R.layout.custom_new_item, parent, false)
        return ViewHolder(itemView)
    }

    fun clearData() {
        if (!listOfNews.isEmpty()) listOfNews.clear()

        notifyDataSetChanged()
    }
}
