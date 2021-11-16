package com.alisamir.a7agzkora

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.alisamir.a7agzkora.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {

    lateinit var binding:FragmentSplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSplashBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val firstAnim = AnimationUtils.loadAnimation(context,R.anim.splash_back)
        val secondAnim = AnimationUtils.loadAnimation(context,R.anim.splash_text)
        binding.messageTV.startAnimation(secondAnim)
        binding.messgae2TV.startAnimation(secondAnim)
        secondAnim.setAnimationListener(object:Animation.AnimationListener{
            override fun onAnimationStart(p0: Animation?) {

            }

            override fun onAnimationEnd(p0: Animation?) {
                binding.splashLayout.startAnimation(firstAnim)
            }

            override fun onAnimationRepeat(p0: Animation?) {

            }

        })
        firstAnim.setAnimationListener(object :Animation.AnimationListener{
            override fun onAnimationStart(p0: Animation?) {
            }

            override fun onAnimationEnd(p0: Animation?) {
                findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
            }

            override fun onAnimationRepeat(p0: Animation?) {
            }

        })
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar?.hide()
        (activity as MainActivity).enableDrawer(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity?)!!.supportActionBar?.show()
        (activity as MainActivity).enableDrawer(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
    }


}