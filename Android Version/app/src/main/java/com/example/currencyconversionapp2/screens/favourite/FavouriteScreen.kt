package com.example.currencyconversionapp.screens.favourite



import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.example.currencyconversionapp2.R
import com.example.currencyconversionapp2.viewModels.FavouritesViewModel


@Composable
fun FavouriteScreen(onClick: () -> Unit,
                    favouritesViewModel: FavouritesViewModel) {


    FavouriteLayout(onClick,  favouritesViewModel)

}




/**
 * LAYOUT FOR DISPLAYING CURRENCIES
 * CALLS DISPLAY CURRENCIES METHOD INSIDE LAZY COLUMN
 *
 * */
@Composable
fun FavouriteLayout(onClick: () -> Unit,
                    favouritesViewModel: FavouritesViewModel) {


        Column(
            modifier = Modifier
                //  .padding(5.dp)
                .fillMaxWidth()
                .height(40.dp)
                .background(Color.White),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.End
        ) {
            Image(
                modifier = Modifier
                    .padding(5.dp)
                    .clickable { onClick.invoke() },
                imageVector = Icons.Filled.Clear,
                contentDescription = "image description",


                )
        }




            Column (modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .wrapContentSize(
                    Alignment.Center
                )){


                    Text(
                        text = "My Favorites",
                        style = TextStyle(
                            fontSize = 17.sp,
                            lineHeight = 23.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFF121212),
                        ),
                        modifier = Modifier
                            .width(200.dp)
                            .height(24.dp)
                    )
Spacer(modifier = Modifier.height(10.dp))

                    Column(
                        modifier = Modifier
                            .background(Color.White)
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState()),
                        horizontalAlignment = Alignment.Start,
                       // contentPadding = PaddingValues(),
                    ) {

                        /**
                         * CALLING DISPLAY CURRENCIES FUNCTION TO DISPLAY EACH CURRENCY OBJECT IN LIST IN
                         * A LAZY COLUMN
                         * */



                        currencyList(favouritesViewModel)
                        favouritesViewModel.getAddToFavouritesList()



                            Spacer(modifier = Modifier.height(14.dp))



                    }


                }
          //  }
        }
   // }


//}

/**
 *
 * DISPLAYS CURRENCY OBJECT ON SCREEN
 *
 *
 *
 *
 * */
@Composable
fun currencyList( favouritesViewModel: FavouritesViewModel ){

    val currencies = favouritesViewModel.currenciesFlow.collectAsState()
    currencies.value?.forEach {
        Row {
            AsyncImage(
                modifier = Modifier.size(40.dp),
                model = ImageRequest
                    .Builder(LocalContext.current)
                    .data(it.icon_url)
                    .decoderFactory(SvgDecoder.Factory())
                    .crossfade(true)
                    .build(),
                contentDescription = it.name
            )

            Spacer(modifier = Modifier.width(10.dp))


            Column(
                modifier = Modifier,

                ) {

                Text(
                    modifier = Modifier
                        .width(40.dp)
                        .height(24.dp),
                    text = it.code, style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 23.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF121212),
                    )
                )


                Spacer(modifier = Modifier.height(1.dp))


                Text(
                    text = it.name, style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 19.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFFB8B8B8),
                    )
                )


            }
            var selected by remember {
                mutableStateOf(false)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.TopEnd)
            )
            {
                RoundedCheckbox(selected = selected, onChecked = {

                    if (selected) {

                        selected = false
                        myPortfolioList.remove(Currencies(it.icon_url, it.code, it.name))

                    } else {
                        selected = true
                        myPortfolioList.add(Currencies(it.icon_url, it.code, it.name))
                    }
                })
            }


                }

        Divider(
            modifier = Modifier
                .width(315.dp)
                .height(0.9633.dp)
                .background(color = Color(0xFFB9C1D9))
        )



    }

}










val myPortfolioList = mutableStateListOf<Currencies>()


data class Currencies(
    var image: String,
    var id: String,
    var title:String,

    )