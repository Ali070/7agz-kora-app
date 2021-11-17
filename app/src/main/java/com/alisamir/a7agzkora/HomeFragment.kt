package com.alisamir.a7agzkora

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.alisamir.a7agzkora.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val matchesList = ArrayList<match>()
        matchesList.add(match("Zayed","11-11-2021","01293012309","Ali"))
        matchesList.add(match("Zayed","11-11-2021","01293012309","Ali"))
        matchesList.add(match("Zayed","11-11-2021","01293012309","Ali"))
        matchesList.add(match("Zayed","11-11-2021","01293012309","Ali"))
        val adapter = matchesAdapter(matchesList)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
    }

}