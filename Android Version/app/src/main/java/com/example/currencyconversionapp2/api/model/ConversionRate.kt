package com.example.currencyconversionapp.api.model

data class ConversionRate(
    val base_code: String,
    val target_code: String,
    val conversion_rate: Double
)