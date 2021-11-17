package com.alisamir.a7agzkora

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alisamir.a7agzkora.databinding.MatchItemBinding

class matchesAdapter(val matchesList:ArrayList<match>): RecyclerView.Adapter<matchesAdapter.myViewHolder>() {
    inner class myViewHolder(val binding: MatchItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(getMatch:match){
            binding.nameTv.text = getMatch.name
            binding.phoneTv.text = getMatch.phoneNumber
            binding.dateTv.text = getMatch.date
            binding.addressTv.text = getMatch.address
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): matchesAdapter.myViewHolder {
        return myViewHolder(MatchItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: matchesAdapter.myViewHolder, position: Int) {
        val oneMatch:match = matchesList.get(position)
        holder.bind(oneMatch)
    }

    override fun getItemCount(): Int {
        return matchesList.size
    }
}