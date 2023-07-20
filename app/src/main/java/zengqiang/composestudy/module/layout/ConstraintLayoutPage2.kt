package zengqiang.composestudy.module.layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Preview
@Composable
fun ConstraintLayoutPage2() {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val guideline = createGuidelineFromTop(0.2f)
        val (userPortraitBackgroundRef, userPortraitBackground2Ref, userPortraitImgRef) = remember {
            createRefs()
        }
        Box(modifier = Modifier
            .constrainAs(userPortraitBackgroundRef) {
                top.linkTo(parent.top)
                bottom.linkTo(guideline)
                height = Dimension.fillToConstraints
                width = Dimension.matchParent
            }
            .background(Color(0xFF1E9FFF)))
        Box(modifier = Modifier
            .constrainAs(userPortraitBackground2Ref) {
                top.linkTo(guideline)
                bottom.linkTo(parent.bottom)
                height = Dimension.fillToConstraints
                width = Dimension.matchParent
            }
            .background(Color(0xFF1EEFFF)))

        Image(imageVector = Icons.Default.AccountCircle,
            contentDescription = null,
            modifier = Modifier
                .constrainAs(userPortraitImgRef) {
                    top.linkTo(guideline)
                    bottom.linkTo(guideline)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .size(100.dp)
                .clip(CircleShape)
                .border(
                    width = 2.dp, color = Color(0xFF5FB878), shape = CircleShape
                ))

        val (firstLineRef, secondLineRef, thirdLineRef, forthLineRef) = remember {
            createRefs()
        }

        createVerticalChain(
            firstLineRef, secondLineRef, thirdLineRef, forthLineRef, chainStyle = ChainStyle.Spread
        )


        Text(text = "寄蜉蝣于天地", color = Color.White, modifier = Modifier.constrainAs(firstLineRef) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })
        Text(text = "渺沧海之一粟", color = Color.White, modifier = Modifier.constrainAs(secondLineRef) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })
        Text(text = "哀吾生之须臾", color = Color.White, modifier = Modifier.constrainAs(thirdLineRef) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })
        Text(text = "羡长江之无穷", color = Color.White, modifier = Modifier.constrainAs(forthLineRef) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })


    }

}