package com.example.currencyconversionapp.screens.compare

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.currencyconversionapp2.R


/**
 * CUSTOM TOGGLE BUTTON
 * UNDER CONSTRUCTION!
 */


@Composable
fun CustomSwitch(
    width: Dp = 275.dp,
    height: Dp = 60.dp,
    cornerSize: Int = 50,
) {

    // this is to disable the ripple effect
    val interactionSource = remember {
        MutableInteractionSource()
    }

    // state of the switch
    var switchOn by remember {
        mutableStateOf(true)
    }

    // for moving the thumb
    val alignment by animateAlignmentAsState(if (switchOn) 1f else -1f)

    // outer rectangle with border
    Card(
        modifier = Modifier
            .height(260.dp)
            .fillMaxWidth()
            .offset(x = -0.00001.dp, y = 3.dp)
            .wrapContentSize(Alignment.BottomCenter)
            .size(width = width, height = height)
            .clip(RoundedCornerShape(cornerSize))
            .background(color = Color.White)
            .clickable(
                indication = null,
                interactionSource = interactionSource
            ) {
                switchOn = !switchOn
            },

        ) {


        Row(
            Modifier
                .offset(x = -0.00001.dp, y = 3.dp)
                .width(275.dp)
                .height(46.dp),
            horizontalArrangement = Arrangement.spacedBy(25.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
        )
// Child views.
        {
            Card(modifier = Modifier
                .width(107.dp)
                .height(46.dp)
                .background(color = Color.White, shape = RoundedCornerShape(size = 20.dp))
                .padding(start = 9.dp, top = 9.dp, end = 9.dp, bottom = 9.dp))  {
                Text(
                    text = "Convert",
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF141414),
                    )
                )
            }
            Text(text = "Compare",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF141414),
                )
            )
        }
    }
}


@Composable
private fun animateAlignmentAsState(
    targetBiasValue: Float
): State<BiasAlignment> {

    val bias by animateFloatAsState(targetBiasValue)
    return remember { derivedStateOf { BiasAlignment(horizontalBias = bias, verticalBias = 0f) } }
}
