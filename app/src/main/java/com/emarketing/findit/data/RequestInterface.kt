package com.emarketing.findit.data

import io.reactivex.Observable
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*


interface RequestInterface {

    @GET
    fun downlload(@Url fileUrl: String?): Call<ResponseBody>


    @POST("user-register")
    fun register(@Query("name") name:String,
             @Query("email") file_id:String,
             @Query("phone") phone:String,
                 @Query("password") password:String,
             @Query("message") message:String
    ): Observable<RegisterResponse>
}