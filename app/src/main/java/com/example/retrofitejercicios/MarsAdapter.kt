package com.example.retrofitejercicios

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitejercicios.databinding.MarsItemListBinding
import com.example.retrofitejercicios.pojo.MarsTerrain

class MarsAdapter: RecyclerView.Adapter<MarsAdapter.MarsVH>() {

    private var listMarsITEM= listOf<MarsTerrain>()

    fun update(list: List<MarsTerrain>) {
        listMarsITEM = list
        notifyDataSetChanged()

    }
    inner class MarsVH(private val binding: MarsItemListBinding) :
            RecyclerView.ViewHolder(binding.root){

            fun bind(marsTerrain: MarsTerrain){
                Glide.with(binding.Imagen).load(marsTerrain.srcImg).centerCrop().into(binding.Imagen)
                
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsVH {
        return MarsVH(MarsItemListBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int = listMarsITEM.size

    override fun onBindViewHolder(holder: MarsVH, position: Int) {
       val marsTerrain= listMarsITEM[position]
        holder.bind(marsTerrain)
    }


}
