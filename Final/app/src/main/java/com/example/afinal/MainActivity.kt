package com.example.afinal

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.afinal.api.APIService
import com.example.afinal.dao.CountryDao
import com.example.afinal.models.Country
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    lateinit var db: Database
    lateinit var countryDao: CountryDao

    companion object {
        var service = Service()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = MyApplication.instance.getDatabase()!!
        countryDao = db.countryDao()


        (service.service as APIService).get().enqueue(object :
            Callback<ArrayList<Country>> {
            override fun onResponse(call: Call<ArrayList<Country>>, response: Response<ArrayList<Country>>) {
                for(item in response.body()!!){
                    countryDao.insert(item)
                }

                val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
                navHostFragment.navController.setGraph(R.navigation.nav_graph)
                navHostFragment.navController.navigateUp()
            }

            override fun onFailure(call: Call<ArrayList<Country>>, t: Throwable) {
                Log.e("Connection Error", t.message!!)
            }
        })


    }
}