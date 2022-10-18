package tahadeta.example.quickstartandroid

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import tahadeta.example.quickstartandroid.net.RetrofitHelper
import tahadeta.example.quickstartandroid.net.ServicesApi

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quotesApi = RetrofitHelper.getInstance().create(ServicesApi::class.java)
        // launching a new coroutine
        GlobalScope.launch {
            val result = quotesApi.getNews()
            if (result != null)
            // Checking the results
                Log.d("TESTAPI", result.body().toString())
        }
    }
}
