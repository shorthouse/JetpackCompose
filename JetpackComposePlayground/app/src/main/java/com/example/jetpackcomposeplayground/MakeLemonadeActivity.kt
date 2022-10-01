package com.example.jetpackcomposeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeplayground.ui.theme.Coral
import com.example.jetpackcomposeplayground.ui.theme.JetpackComposePlaygroundTheme

class MakeLemonadeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposePlaygroundTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LemonadePreview()
                }
            }
        }
    }
}

@Composable
fun LemonadeActivity(modifier: Modifier = Modifier) {
    var lemonadeState by remember { mutableStateOf(1) }

    var remainingLemonSqueezes by remember { mutableStateOf((2..4).random())}

    val lemonadeImageId = when(lemonadeState) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    val lemonadeInstructionString = when (lemonadeState) {
        1 -> stringResource(R.string.select_lemon)
        2 -> stringResource(R.string.squeeze_lemon)
        3 -> stringResource(R.string.drink_lemonade)
        else -> stringResource(R.string.restart_lemonade)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text (
            text = lemonadeInstructionString,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(lemonadeImageId),
            contentDescription = "lemon tree",
            modifier = Modifier
                .border(2.dp, Coral)
                .clickable {
                    if (lemonadeState == 2) {
                        remainingLemonSqueezes--

                        if (remainingLemonSqueezes == 0) {
                            remainingLemonSqueezes = (2..4).random()
                            lemonadeState = nextLemonadeState(lemonadeState)
                        }
                    } else {
                        lemonadeState = nextLemonadeState(lemonadeState)
                    }
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadePreview() {
    JetpackComposePlaygroundTheme {
        LemonadeActivity(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        )
    }
}

fun nextLemonadeState(lemonadeState: Int): Int {
    return lemonadeState.plus(1).mod(4)
}