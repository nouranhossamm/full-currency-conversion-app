package com.example.currencyconversionapp2.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyconversionapp.api.model.Currency
import com.example.currencyconversionapp2.api.data.APIRemoteData
import com.example.currencyconversionapp2.api.data.network.APIClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher

class FavouritesViewModel : ViewModel(){

        private val mutableCurrenciesFlow = MutableStateFlow<List<Currency>>(mutableListOf())
    val currenciesFlow: StateFlow<List<Currency>> = mutableCurrenciesFlow


    var currenciesList: List<Currency> by mutableStateOf(listOf())
var errorMessage: String by mutableStateOf("")

    fun getAddToFavouritesList(){
        viewModelScope.launch {
            val apiService = APIClient.getClient()?.create(APIRemoteData::class.java)
            try {
                val currencyList = apiService?.getCurrencies()


                withContext(Dispatchers.Main){
                    currencyList?.let {  mutableCurrenciesFlow.value = it.data }

                }


            }catch (e : Exception){
                errorMessage = e.message.toString()
            }


        }

    }




}