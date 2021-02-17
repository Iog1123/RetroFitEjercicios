package com.example.retrofitejercicios

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitejercicios.pojo.MarsTerrain
import kotlinx.coroutines.launch

class MarsViewModel :ViewModel(){
    private val repository : MarsRepository = MarsRepository()


    init {
        viewModelScope.launch {
           repository.getTerrainMarsWithCoroutines()
       }
    }

     // voy a observar en las vistas y realizar la solicitud de datos
    fun getFetchTerrains(): LiveData<List<MarsTerrain>>{
         return repository.fetchMarsTerrainEnqueue()

    }

    fun getFetchTerrainsWithCoroutines(): LiveData<List<MarsTerrain>>{
        return repository.liveDataMarsTerrain
    }




}