package com.example.campingwithcompose.ui.screens.onBoarding

import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.campingwithcompose.R
import com.example.campingwithcompose.ui.navigation.screenDestination.Screen
import com.example.campingwithcompose.utils.noRippleClickable
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun onBoardingScreen(navController: NavController) {
    val pagerState = rememberPagerState(initialPage = 0)
    val coroutineScope = rememberCoroutineScope()

    val onBoardingScreensList = listOf(
        OnBoardingScreenItem(
            R.drawable.ic_task,
            title = "Your Tasks",
            "I always reminds you about your planned activities. which " +
                    "is always my priority and your importance."
        ),
        OnBoardingScreenItem(
            R.drawable.ic_momentes,
            title = "Capture Your Memories",
            "We know that catching photos are necessary in your trip. that’s why we have built-in camera and gallery feature."
        ),
        OnBoardingScreenItem(
            R.drawable.ic_track_activity,
            title = "Track Your Fitness",
            "Fitness is one of the main thing which is really inportant to your body and we track it in every second."
        ),
        OnBoardingScreenItem(
            R.drawable.ic_camping_tente,
            title = "There Is Much More",
            "We have bunch of other cool features. which is super helpful for your next camping trip. so what are you waiting for?"
        )
    )
    val count = onBoardingScreensList.size
    HorizontalPager(
        pageCount = count, state = pagerState
    ) { page ->


        TaskScreen(screen = onBoardingScreensList[page],
            count = count,
            currentPage = pagerState.currentPage,
            onArrowBackWardClick = {

                if (pagerState.currentPage >= 0) coroutineScope.launch {
                    val prevPageIndex = pagerState.currentPage - 1
                    pagerState.animateScrollToPage(prevPageIndex)


                }

            }) {
            if (pagerState.currentPage < count - 1) coroutineScope.launch {
                val nextPageIndex = pagerState.currentPage + 1
                pagerState.animateScrollToPage(nextPageIndex)
            } else {
                navController.navigate(Screen.Login.route) {
                    popUpTo(Screen.OnBoarding.route) { inclusive = true }

                    launchSingleTop = true
                    restoreState = true
                }

            }
        }


    }
}

@Composable
fun TaskScreen(
    screen: OnBoardingScreenItem,
    count: Int,
    currentPage: Int,
    onArrowBackWardClick: () -> Unit,
    onArrowForWardClick: () -> Unit
) {
    val scrollState = rememberLazyListState()
    LazyColumn(modifier = Modifier.fillMaxSize(), state = scrollState) {
        item {

            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.15F)
                        .padding(start = 47.dp, end = 47.dp, top = 80.dp),
                    painter = painterResource(id = screen.image), contentDescription = screen.title
                )
                Text(
                    modifier = Modifier.padding(top = 40.dp),
                    text = screen.title, fontSize = 24.sp, fontWeight = FontWeight.Bold
                )

                Text(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .wrapContentHeight(Alignment.Bottom),
                    text = screen.Description, fontSize = 16.sp, textAlign = TextAlign.Center,
                )

                CustomLayout(
                    modifier = Modifier.padding(top = 35.dp),
                    count = count,
                    currentPage = currentPage,
                    onArrowForWardClick = onArrowForWardClick,
                    onArrowBackWardClick = onArrowBackWardClick,
                )
                LoginButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 25.dp)
                )

                Text(
                    text = "Don’t have an Account? Register", modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 16.dp), fontSize = 14.sp
                )
            }

        }
    }
}

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
                animationSpec = tween(500, easing = EaseInOut)
            )

            if (selectedPage == it)
                Box(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.background)
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
    modifier: Modifier

) {

    Box(
        modifier = modifier
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

@Composable
fun CustomLayout(
    currentPage: Int,
    count: Int,
    onArrowBackWardClick: () -> Unit,
    onArrowForWardClick: () -> Unit,
    modifier: Modifier
) {
    Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {

        if (currentPage != 0)
            ArrowIcon(
                isGoNext = false,
                modifier = Modifier.noRippleClickable {
                    onArrowBackWardClick.invoke()
                }

            )
        else Spacer(modifier)




        PagerIndicator(
            modifier = Modifier
                .padding(start = 42.dp, end = 42.dp)
                .requiredWidth(150.dp),
            count = count,
            selectedPage = currentPage,
        )


        ArrowIcon(
            isGoNext = true,
            modifier = Modifier.noRippleClickable {
                onArrowForWardClick.invoke()
            }

        )


    }
}



@Composable
fun LoginButton(
    modifier: Modifier,
) {
    Button(
        modifier = modifier,
        onClick = { /*TODO*/ }) {
        Text("Log in")
    }
}


@Preview(showBackground = true)
@Composable
private fun OnBoardingScreenPreview() {
//    CampingWithComposeTheme {
//        TaskScreen(
//            screen = OnBoardingScreenItem(
//                R.drawable.ic_task,
//                title = "Your Tasks",
//                "I always reminds you about your planned activities. which " +
//                        "is always my priority and your importance."
//            )
//        )
//    }
}

