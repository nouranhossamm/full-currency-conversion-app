package com.example.currencyconversionapp.screens.favourite
import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.AlertDialog
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.currencyconversionapp2.viewModels.FavouritesViewModel

/**
 * CREATES A DIALOGUE THAT CONTAINS OR RETURNS FAVOURITES LIST
 *
 *
 * */
//viewModel: APIViewModel
@Composable
fun CustomDialogUI(modifier: Modifier = Modifier.fillMaxSize().background(Color.Transparent), onClick : () -> Unit,
                    favouritesViewModel: FavouritesViewModel) {

    AlertDialog(
        modifier = Modifier.height(670.dp),
        containerColor = Color.White,
        onDismissRequest = { onClick.invoke() }, confirmButton = {
        Column(
            modifier
                .wrapContentSize(Alignment.Center)
                .background(Color.White),
        ) {

            FavouriteScreen(onClick, favouritesViewModel)


        }
    }, )

        }




@SuppressLint("UnrememberedMutableState")
@Preview(name = "Custom Dialog")
@Composable
fun MyDialogUIPreview() {
    //CustomDialogUI()
}