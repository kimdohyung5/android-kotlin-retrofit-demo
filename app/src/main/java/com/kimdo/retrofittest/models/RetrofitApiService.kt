package com.kimdo.retrofittest.models

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitApiService {
    @GET("/todos/{userId}")
    fun getData(
        @Path("userId") id: String
    ): Call<ResponseData>

//        @GET("/posts)
//            fun getSecond(
//                @Query("userId") id:String
//            ): Call<List<ResponseGet>>
//
//            @FormUrlEncoded
//            @POST("/posts")
//            fun postFirst(
//                @Field("title") title: String,
//                @Field("author") author: String
//            ): Call<ResponseGet>

}