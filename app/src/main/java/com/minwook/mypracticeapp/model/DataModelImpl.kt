package com.minwook.mypracticeapp.model

import com.minwook.mypracticeapp.api.Api
import com.minwook.mypracticeapp.api.ShortenUrlResponse
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class DataModelImpl(): DataModel {
    val retrofit = Retrofit.Builder()
        .addCallAdapterFactory(
            RxJava2CallAdapterFactory.create())
        .addConverterFactory(
            GsonConverterFactory.create())
        .baseUrl("https://en.wikipedia.org/w/")
        .build()

    private val api:Api = retrofit.create()
    override fun getData(url: String): Single<ShortenUrl> {
        return api.shorturl(url).map {
                shortenUrlResponse ->
            shortenUrlResponse.result
        }

    }
}