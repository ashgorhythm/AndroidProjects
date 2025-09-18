package com.ashgorhythm.randomquote.api

import com.ashgorhythm.randomquote.data.QuoteData
import retrofit2.Response
import retrofit2.http.GET

interface QuoteImageApi {
    @GET("random")
    suspend fun getQuote() : Response<List<QuoteData>>

    @GET("image")
    suspend fun getImage()
}