package tahadeta.example.quickstartandroid.ui.splash

import android.animation.Animator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.airbnb.lottie.LottieAnimationView
import tahadeta.example.quickstartandroid.R
import tahadeta.example.quickstartandroid.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {

    private lateinit var binding: FragmentSplashBinding

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
            R.layout.fragment_splash,
            container,
            false
        )

        startAnimation()

        return binding.root
    }

    private fun startAnimation() {
        // get the instance of the animated JSON
        val animationView: LottieAnimationView = binding.animationView

        animationView.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {
                // Set Arab as default Lang
                // localeDelegate.setLocale(LoginActivity.activityInstance, Locales.Arabic)
                findNavController().navigate(R.id.homeFragment)
            }

            override fun onAnimationEnd(animation: Animator?) {
                // Do nothing
            }

            override fun onAnimationCancel(animation: Animator?) {
                // Do nothing
            }

            override fun onAnimationStart(animation: Animator?) {
                // Do nothing
            }
        })
    }
}
