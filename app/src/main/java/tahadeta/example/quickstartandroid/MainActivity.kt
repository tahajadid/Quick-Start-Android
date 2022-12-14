package tahadeta.example.quickstartandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import tahadeta.example.quickstartandroid.databinding.ActivityMainBinding
import tahadeta.example.quickstartandroid.model.News

class MainActivity : AppCompatActivity() {

    lateinit var mutableList: MutableList<News>
    private lateinit var binding: ActivityMainBinding

    companion object {
        lateinit var navController: NavController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main)

        mutableList = mutableListOf()

    }
}
