package com.minwook.mypracticeapp.model

import io.reactivex.Single

interface DataModel {
    fun getData(url: String): Single<ShortenUrl>
}