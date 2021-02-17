package com.example.retrofitejercicios

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofitejercicios.pojo.MarsTerrain
import retrofit2.Call
import retrofit2.Response

class MarsRepository {
    private val services = RetrofitClient.retrofitInstance()
    val liveDataMarsTerrain = MutableLiveData<List<MarsTerrain>>()

    // vieja confiable
    fun fetchMarsTerrainEnqueue(): LiveData<List<MarsTerrain>> {
        services.fetchMarsTerrainEnqueue().enqueue(object : retrofit2.Callback<List<MarsTerrain>> {
            override fun onResponse(
                    call: Call<List<MarsTerrain>>,
                    response: Response<List<MarsTerrain>>) {

                when (response.code()) {
                    in 200..299 -> liveDataMarsTerrain.value = response.body()
                    in 300..399 -> Log.d("Error", response.errorBody().toString())
                    else -> Log.d("Error", "error del server ${response.code()}")
                }

            }

            override fun onFailure(call: Call<List<MarsTerrain>>, t: Throwable) {
                Log.e("Error", t.message.toString())
            }

        })
        return liveDataMarsTerrain
    }

        // esta funcion utiliza las coroutines para la conexion al servicio

        suspend fun getTerrainMarsWithCoroutines() {
            Log.d("repository", "utilizando coroutines")

            try {

            val response = RetrofitClient.retrofitInstance().fetchMarsTerraCorutines()
            when (response.isSuccessful) {
                true -> response.body()?.let {
                    liveDataMarsTerrain.value = it
                }
                false -> Log.d("ERROR", "${response.code()} : ${response.errorBody()}")
            }

        } catch (t: Throwable){
                Log.e("error corrutina",t.message.toString())
            }
        }
    }

