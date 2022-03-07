package com.kimdo.retrofittest.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.kimdo.retrofittest.R
import com.kimdo.retrofittest.databinding.ActivityMainBinding
import com.kimdo.retrofittest.models.ResponseData
import com.kimdo.retrofittest.models.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {


            RetrofitClient.instance.getData("1")
                .enqueue( object: Callback<ResponseData> {
                    override fun onResponse(
                        call: Call<ResponseData>,
                        response: Response<ResponseData>
                    ) {
                        if(response.isSuccessful.not()) {
                            Log.d(TAG, "response.isSuccessful is not ")
                            return
                        }

                        response.body()?.let {
                            Log.d(TAG, it.toString() )
                            Log.d(TAG, it.title)
                        }

                    }

                    override fun onFailure(call: Call<ResponseData>, t: Throwable) {
                        Log.e("RETRO_ERR", "Error")
                    }

                })
        }


    }
}