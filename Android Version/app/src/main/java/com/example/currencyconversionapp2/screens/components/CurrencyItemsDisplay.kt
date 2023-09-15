package com.example.currencyconversionapp2.screens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.example.currencyconversionapp.api.model.Currency
import com.example.currencyconversionapp.screens.favourite.RoundedCheckbox
import com.example.currencyconversionapp2.R
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue

@Composable
fun currencyItemsDisplay(currency: Currency) {

    Row {
        AsyncImage(
            modifier = Modifier.size(40.dp),
            model = ImageRequest
                .Builder(LocalContext.current)
                .data(currency.icon_url)
                .decoderFactory(SvgDecoder.Factory())
                .crossfade(true)
                .build(),
            contentDescription = currency.name
        )

        Spacer(modifier = Modifier.width(10.dp))


        Column(
            modifier = Modifier,

            ) {

            Text(
                modifier = Modifier
                    .width(40.dp)
                    .height(24.dp),
                text = currency.code, style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 23.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF121212),
                )
            )


            Spacer(modifier = Modifier.height(1.dp))


            Text(
                text = currency.name, style = TextStyle(
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
            modifier = Modifier.fillMaxWidth().wrapContentSize(Alignment.TopEnd)
        )
        {
            RoundedCheckbox(selected = selected, onChecked = {

                if (selected) {
                    selected = false
                } else {
                    selected = true
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