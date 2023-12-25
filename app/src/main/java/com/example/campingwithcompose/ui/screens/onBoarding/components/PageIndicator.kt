package com.example.campingwithcompose.ui.screens.onBoarding.components

import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import com.example.campingwithcompose.core.ui.navigation.utils.noRippleClickable

@Composable
fun PagerIndicator(
    modifier: Modifier,
    count: Int,
    selectedPage: Int,
) {
    Row(
        modifier.height(50.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {

        repeat(count) {
            val boxSize by animateDpAsState(
                targetValue = if (selectedPage == it) 15.dp else 0.dp,
                animationSpec = tween(500, easing = EaseInOut), label = ""
            )

            if (selectedPage == it)
                Box(
                    modifier = Modifier

                        .size(boxSize)
                        .border(
                            BorderStroke(
                                1.dp,
                                MaterialTheme.colorScheme.secondary
                            ), shape = CircleShape
                        ),

                    contentAlignment = Alignment.Center

                ) {

                    Box(
                        modifier = Modifier

                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.secondary)
                            .size(7.5.dp)


                    )
                }
            else Box(
                modifier = Modifier

                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.secondary)
                    .size(7.5.dp)


            )
        }
    }
}

@Composable
fun ArrowIcon(
    isGoNext: Boolean,
   onCLick : ()->Unit,
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier.noRippleClickable {  onCLick.invoke()}
            .clip(RoundedCornerShape(12.dp))
            .size(40.dp)
            .background(
                if (!isGoNext) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.onPrimaryContainer
            ), contentAlignment = Alignment.Center

    ) {
        Icon(
            painter = rememberVectorPainter(if (!isGoNext) Icons.Default.ArrowBack else Icons.Default.ArrowForward),
            contentDescription = "Arrow Back",
            tint = if (isGoNext) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.onBackground,

            )
    }

}