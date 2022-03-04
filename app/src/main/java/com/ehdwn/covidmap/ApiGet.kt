package com.ehdwn.covidmap

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiGet {
    @GET("/api/15077586/v1/centers")
    fun getInfo(
        @Query("perPage")PerPage:Int,
        @Query("page")Page:Int,
        @Query("serviceKey")ServiceKey:String = "eQie+njqKcm6zzSRwjqT5u7M1tSMd+wk+rdBbS1xzjSneAi1v9GU+ejltUfk5sjM4fVD6cWJNJwuOsE2AN7mYA=="
    ): Call<CovidBody>
}