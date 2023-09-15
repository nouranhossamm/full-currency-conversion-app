package com.example.currencyconversionapp.api.model
data class CurrencyResponse(
    val data: List<Currency>,

)

data class Currency(
    val name: String,
    val code: String,
    val icon_url: String
)