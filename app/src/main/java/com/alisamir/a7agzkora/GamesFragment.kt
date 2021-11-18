package com.alisamir.a7agzkora

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.alisamir.a7agzkora.databinding.FragmentGamesBinding


class GamesFragment : Fragment() {
    lateinit var binding:FragmentGamesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGamesBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val matchesList:ArrayList<match> = ArrayList()
        matchesList.add(match("Giza,Haram","21-11-2021","01093012309","Ahmed"))
        val adapter = matchesAdapter(matchesList,false)
        binding.gamesList.adapter = adapter
        binding.gamesList.layoutManager = LinearLayoutManager(context)
    }


}