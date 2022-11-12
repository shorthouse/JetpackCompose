package com.example.jetpackcomposeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeplayground.data.YogaPoseDataSource
import com.example.jetpackcomposeplayground.model.YogaPose
import com.example.jetpackcomposeplayground.ui.theme.JetpackComposePlaygroundTheme


class YogaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposePlaygroundTheme {
                YogaApp()
            }
        }
    }
}

@Composable
fun YogaApp() {
    Scaffold(
        topBar = { TopAppBar() }
    ) {
        YogaPoseList(YogaPoseDataSource.yogaPoses)
    }
}

@Composable
fun TopAppBar(modifier: Modifier = Modifier) {
    Row(
        modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(MaterialTheme.colors.primary),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Text(
            text = stringResource(R.string.activity_name_yoga),
            style = MaterialTheme.typography.h1
        )
    }
}

@Composable
fun YogaPoseList(yogaPoses: List<YogaPose>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(yogaPoses) {
            YogaPoseCard(yogaPose = it)
        }
    }
}

@Composable
fun YogaPoseCard(yogaPose: YogaPose, modifier: Modifier = Modifier) {
    var isCardExpanded by remember { mutableStateOf(false) }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { isCardExpanded = !isCardExpanded },
        elevation = 4.dp,
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .padding(8.dp)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioLowBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                ),
        ) {
            Text(
                text = stringResource(yogaPose.nameRes),
                style = MaterialTheme.typography.h2,
            )
            Image(
                painter = painterResource(yogaPose.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.FillBounds
            )
            if (isCardExpanded) {
                Text(
                    text = stringResource(yogaPose.instructionRes),
                    style = MaterialTheme.typography.body1
                )
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun YogaPreview() {
    JetpackComposePlaygroundTheme {
        YogaApp()
    }
}