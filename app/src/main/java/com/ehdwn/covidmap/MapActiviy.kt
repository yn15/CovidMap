package com.ehdwn.covidmap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.UiThread
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.MapFragment
import com.naver.maps.map.NaverMap
import com.naver.maps.map.OnMapReadyCallback
import com.naver.maps.map.overlay.Marker
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MapActiviy : AppCompatActivity(), OnMapReadyCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        val fm = supportFragmentManager
        val mapFragment = fm.findFragmentById(R.id.map) as MapFragment?
            ?: MapFragment.newInstance().also {
                fm.beginTransaction().add(R.id.map, it).commit() }

        mapFragment.getMapAsync(this)
    }

    @UiThread
    override fun onMapReady(naverMap: NaverMap) {
        for(i in 1..10){
            getCovidStatus(naverMap, i)
        }
    }

    private fun getCovidStatus(naverMap: NaverMap, i:Int){
        RetrofitObject.getApiService().getInfo(10, i).enqueue(object : Callback<CovidBody> {
            // api 호출 성공시
            override fun onResponse(call: Call<CovidBody>, response: Response<CovidBody>) {
                Log.d("hihi", response.body().toString())
                response.body()?.data?.forEach{
                    val marker = Marker()
                    marker.position = LatLng(it.lat.toDouble(), it.lng.toDouble())
                    marker.map = naverMap
                }

            }

            // api 호출 실패시
            override fun onFailure(call: Call<CovidBody>, t: Throwable) {
                Log.e("retrofit onFailure", "${t.printStackTrace()}")
                Toast.makeText(applicationContext, "fail", Toast.LENGTH_SHORT).show()
            }
        })
    }
}