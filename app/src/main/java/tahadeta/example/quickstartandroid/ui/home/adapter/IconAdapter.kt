package tahadeta.example.quickstartandroid.ui.home.adapter

import android.widget.ImageView
import tahadeta.example.quickstartandroid.R

object IconAdapter {

    fun adaptIcon(imageView: ImageView, label:String){
        when(label){
            "es" -> imageView.setImageResource(R.drawable.es)
            "it" -> imageView.setImageResource(R.drawable.it)
            "fr" -> imageView.setImageResource(R.drawable.fr)
            "en" -> imageView.setImageResource(R.drawable.en)
            else -> imageView.setImageResource(R.drawable.en)
        }
    }

}