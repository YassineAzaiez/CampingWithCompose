import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.campingwithcompose.ui.screens.onBoarding.components.ArrowIcon
import com.example.campingwithcompose.ui.screens.onBoarding.components.PagerIndicator

@Composable
fun OnBoardingPage(
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
                onCLick = onArrowBackWardClick
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
            onCLick = onArrowForWardClick
        )


    }
}