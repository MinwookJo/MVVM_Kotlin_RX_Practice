package com.minwook.mypracticeapp.api

import com.minwook.mypracticeapp.model.ShortenUrl

data class ShortenUrlResponse (val message: String,
                               val result: ShortenUrl,
                               val code: String)