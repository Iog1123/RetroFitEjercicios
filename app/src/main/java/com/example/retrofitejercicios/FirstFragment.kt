package com.example.retrofitejercicios

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.retrofitejercicios.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private val viewModel: MarsViewModel by activityViewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentFirstBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter= MarsAdapter()
        binding.RecyclerView.adapter= adapter
        binding.RecyclerView.layoutManager= GridLayoutManager(context,2)


        // observador vieja confiable
        viewModel.getFetchTerrains().observe(viewLifecycleOwner, Observer {
            it?.let {
             adapter.update(it)
            }
        })

           viewModel.getFetchTerrainsWithCoroutines().observe(viewLifecycleOwner, Observer {
               it?.let {
                   adapter.update(it)
               }
           })

    }
}