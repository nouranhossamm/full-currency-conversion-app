package com.example.currencyconversionapp2.api.model

data class ConversionRateResponse(

    val data :Data
)

data class Data(
    val base_code: String,
    val target_codes: List<String>,
    val result: String,

    val conversion_rates: Map<String, Double>,

    )