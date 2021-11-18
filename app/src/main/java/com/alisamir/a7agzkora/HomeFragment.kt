package com.alisamir.a7agzkora

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.alisamir.a7agzkora.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    val TAG = "lifeHome"
    lateinit var binding: FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(TAG,"onCreate")
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.i(TAG,"onCreateView")
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i(TAG,"onViewCreated")
        val matchesList = ArrayList<match>()
        matchesList.add(match("Zayed","20-11-2021","01003012309","Ali"))
        matchesList.add(match("Giza,Haram","21-11-2021","01093012309","Ahmed"))
        matchesList.add(match("El Dokki","22-11-2021","01193012309","Hossam"))
        matchesList.add(match("6 October","22-11-2021","011593012309","Hussein"))
        val adapter = matchesAdapter(matchesList,true)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.addTv.setOnClickListener {
            if(binding.inputName.text.isEmpty()){
                binding.inputName.error = "Enter your name"
                binding.inputName.requestFocus()
            }else if(binding.inputAddress.text.isEmpty()){
                binding.inputAddress.error = "Enter address"
                binding.inputAddress.requestFocus()
            }else if(binding.inputDate.text.isEmpty()){
                binding.inputDate.error = "Enter date"
                binding.inputDate.requestFocus()
            }else if (binding.inputNumber.text.isEmpty()){
                binding.inputNumber.error = "Enter your phone number"
                binding.inputNumber.requestFocus()
            }else{
                binding.frameLayout.transitionToStart()
                val tempMatch = match(binding.inputAddress.text.toString(),binding.inputDate.text.toString(),binding.inputNumber.text.toString(),binding.inputName.text.toString())
                matchesList.add(tempMatch)
                adapter.notifyItemInserted(matchesList.size-1)
            }
        }


    }

    override fun onPause() {
        Log.i(TAG,"pause")
        super.onPause()
    }

    override fun onStop() {
        Log.i(TAG,"stop")
        super.onStop()
    }
    override fun onDestroy() {
        Log.i(TAG,"destroy")
        super.onDestroy()
    }

}