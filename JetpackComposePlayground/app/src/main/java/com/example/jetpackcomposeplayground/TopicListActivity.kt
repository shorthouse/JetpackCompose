package com.example.jetpackcomposeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeplayground.data.TopicDataSource
import com.example.jetpackcomposeplayground.model.Topic
import com.example.jetpackcomposeplayground.ui.theme.JetpackComposePlaygroundTheme

class TopicListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposePlaygroundTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TopicApp()
                }
            }
        }
    }
}

@Composable
fun TopicApp() {
    TopicGrid()
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TopicGrid() {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(TopicDataSource.topics) { topic ->
            TopicCard(topic)
        }
    }
}

@Composable
fun TopicCard(topic: Topic) {
    Card(
        elevation = 4.dp
    ) {
        Row() {
            Image(
                painter = painterResource(topic.imageResourceId),
                contentDescription = stringResource(topic.topicStringId),
                modifier = Modifier.size(68.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column() {
                Text(
                    text = stringResource(topic.topicStringId),
                    modifier = Modifier
                        .padding(end = 16.dp, top = 16.dp, bottom = 8.dp),
                    style = MaterialTheme.typography.body2,
                )

                Row {
                    Image(
                        painter = painterResource(R.drawable.ic_grain),
                        contentDescription = null,
                        modifier = Modifier.size(12.dp)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = topic.topicNumber.toString(),
                        style = MaterialTheme.typography.caption,
                    )
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun TopicAppPreview() {
    JetpackComposePlaygroundTheme {
        TopicApp()
    }
}