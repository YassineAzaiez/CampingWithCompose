package com.example.campingwithcompose.ui.screens.onBoarding

import androidx.annotation.DrawableRes
import com.example.campingwithcompose.R


data class OnBoardingScreenItem(
    @DrawableRes val image: Int,
    val title: String,
    val description: String,
)

val onBoardingPages = listOf(
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

