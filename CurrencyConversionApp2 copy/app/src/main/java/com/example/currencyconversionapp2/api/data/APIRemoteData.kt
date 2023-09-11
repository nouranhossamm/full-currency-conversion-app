package com.example.currencyconversionapp2.api.data

import com.example.currencyconversionapp.api.model.ConversionRate
import com.example.currencyconversionapp.api.model.ConversionResult
import com.example.currencyconversionapp.api.model.CurrencyResponse
import com.example.currencyconversionapp2.api.model.ComparisonObject
import com.example.currencyconversionapp2.api.model.ConversionRateResponse

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface APIRemoteData {
    @GET("currencies")
    suspend fun getCurrencies(): CurrencyResponse

    @GET("currencies/convert/{current}/{target}")
    suspend fun getConversionRate(@Path("current") current: String,
                                  @Path("target") target: String): ConversionRate

    @GET("currencies/convert/{current}/{target}/{amount}")
     fun getConversionResult(@Path("current") current: String,
                                    @Path("target") target: String,
                                    @Path("amount") amount : Double): Call<ConversionResult>

    @POST("currencies/compare")
    fun compareRates(@Body comparison : ComparisonObject): Call<ConversionRateResponse>


}