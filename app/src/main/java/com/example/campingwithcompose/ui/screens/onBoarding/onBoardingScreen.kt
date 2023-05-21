package com.example.campingwithcompose.ui.screens.onBoarding

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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.campingwithcompose.R
import com.example.campingwithcompose.ui.navigation.screenDestination.Screen
import com.example.campingwithcompose.ui.theme.Green100
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun onBoardingScreen(navController: NavController) {
    val pagerState = rememberPagerState(initialPage = 0)
    val coroutineScope = rememberCoroutineScope()
    val currentPage = remember {
        pagerState.currentPage
    }
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
        val scrollState = rememberLazyListState()

        LazyColumn(modifier = Modifier.fillMaxSize(), state = scrollState) {
            item {

                TaskScreen(
                    screen = onBoardingScreensList[page],
                    count = count,
                    currentPage = currentPage,
                    onArrowForWardClick = {
                        if (pagerState.currentPage >= 0) coroutineScope.launch {
                            pagerState.animateScrollToPage(page + 1)
                        }
                    }) {
                    if (pagerState.currentPage < count) coroutineScope.launch {
                        pagerState.animateScrollToPage(page - 1)
                    } else {
                        navController.navigate(Screen.Home.route)
                    }
                }
            }
        }
//        LaunchedEffect(null) {
//            val maxScroll = scrollState.sc
//            s .animateScrollTo(maxScroll)
//        }
    }
}


@Composable
fun TaskScreen(
    screen: OnBoardingScreenItem,
    count: Int,
    currentPage: Int,
    onArrowForWardClick: () -> Unit,
    onArrowBackWardClick: () -> Unit
) {

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Image(
            modifier = Modifier.padding(start = 47.dp, end = 47.dp, top = 80.dp),
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
            onArrowBackWardClick = onArrowBackWardClick
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


@Composable
fun PagerIndicator(
    modifier: Modifier,
    count: Int,
) {
    Row(
        modifier
            .height(50.dp)
            .requiredWidth(150.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(count) {
            //   val color = if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
            Box(
                modifier = Modifier
                    .background(Color.White)
                    .size(15.dp)
                    .border(
                        BorderStroke(1.dp, MaterialTheme.colorScheme.secondary),
                        shape = CircleShape
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
        }
    }
}


@Composable
fun ArrowIcon(
    isGoNext: Boolean,
    onArrowForWardClick: () -> Unit = {},
    onArrowBackWardClick: () -> Unit = {},
    modifier: Modifier

) {

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .size(40.dp)
            .background(
                if (!isGoNext) Green100 else MaterialTheme.colorScheme.onBackground
            )
            .clickable {
                if (isGoNext) onArrowForWardClick() else onArrowBackWardClick()
            }, contentAlignment = Alignment.Center

    ) {
        Icon(
            painter = rememberVectorPainter(if (!isGoNext) Icons.Default.ArrowBack else Icons.Default.ArrowForward),
            contentDescription = "Arrow Back",
            tint =
            if (isGoNext) Green100 else MaterialTheme.colorScheme.onBackground
        )
    }

}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CustomLayout(
    currentPage: Int,
    count: Int,
    onArrowBackWardClick: () -> Unit,
    onArrowForWardClick: () -> Unit,
    modifier: Modifier
) {
    ConstraintLayout(modifier = modifier.fillMaxWidth()) {
        val (leftArrow, pagerIndicator, rightArrow) = createRefs()



        ArrowIcon(
            isGoNext = true,
            onArrowForWardClick = onArrowForWardClick,
            modifier = Modifier
                .constrainAs(leftArrow) {
                    start.linkTo(parent.start)
                }
        )




        PagerIndicator(
            modifier = Modifier
                .constrainAs(pagerIndicator) {
                    start.linkTo(leftArrow.end, margin = 88.dp)
                },
            count = count
        )



        ArrowIcon(
            isGoNext = false,
            onArrowBackWardClick = onArrowBackWardClick,
            modifier = Modifier
                .constrainAs(pagerIndicator) {
                    start.linkTo(leftArrow.end, margin = 88.dp)
                    end.linkTo(parent.end)
                    top.linkTo(leftArrow.top)
                }
        )


    }
}


@Composable
fun LoginButton(
    modifier: Modifier
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

