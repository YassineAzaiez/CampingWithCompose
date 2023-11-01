package com.example.campingwithcompose.ui.screens.onBoarding

import OnBoardingPage
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.campingwithcompose.core.ui.navigation.comospables.LoginButton
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(onLoginClick: () -> Unit, onRegisterClick: () -> Unit) {
    val pagerState = rememberPagerState(initialPage = 0) {
        onBoardingPages.size
    }
    val coroutineScope = rememberCoroutineScope()

    val onBoardingScreensList = onBoardingPages
    val count = onBoardingScreensList.size
    HorizontalPager(
        state = pagerState
    ) { page ->


        TaskScreen(
            screen = onBoardingScreensList[page],
            count = count,
            currentPage = pagerState.currentPage,
            onArrowBackWardClick = {

                if (pagerState.currentPage >= 0) coroutineScope.launch {
                    val prevPageIndex = pagerState.currentPage - 1
                    pagerState.animateScrollToPage(prevPageIndex)


                }

            }, {
                if (pagerState.currentPage < count - 1) coroutineScope.launch {
                    val nextPageIndex = pagerState.currentPage + 1
                    pagerState.animateScrollToPage(nextPageIndex)
                } else {
                    onLoginClick()


                }
            }, onLoginClick
        )


    }
}

@Composable
fun TaskScreen(
    screen: OnBoardingScreenItem,
    count: Int,
    currentPage: Int,
    onArrowBackWardClick: () -> Unit,
    onArrowForWardClick: () -> Unit,
    action: () -> Unit
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
                    text = screen.description, fontSize = 16.sp, textAlign = TextAlign.Center,
                )

                OnBoardingPage(
                    modifier = Modifier.padding(top = 35.dp),
                    count = count,
                    currentPage = currentPage,
                    onArrowForWardClick = onArrowForWardClick,
                    onArrowBackWardClick = onArrowBackWardClick,
                )
                LoginButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 25.dp),
                    action
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

