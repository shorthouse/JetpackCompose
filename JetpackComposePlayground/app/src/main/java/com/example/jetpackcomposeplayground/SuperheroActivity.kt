package com.example.jetpackcomposeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeplayground.data.SuperheroDataSource
import com.example.jetpackcomposeplayground.model.Superhero
import com.example.jetpackcomposeplayground.ui.theme.JetpackComposePlaygroundTheme

class SuperheroActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposePlaygroundTheme {
                SuperheroApp()
            }
        }
    }
}

@Composable
fun SuperheroApp() {
    Scaffold(
        topBar = { SuperheroTopAppBar() }
    ) {
        SuperheroList(superheroes = SuperheroDataSource.heroes)
    }
}

@Composable
fun SuperheroTopAppBar(modifier: Modifier = Modifier) {
    Row (
        modifier = modifier
            .height(56.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(R.string.activity_name_superheroes),
            style = MaterialTheme.typography.h1
        )
    }
}

@Composable
fun SuperheroList(superheroes: List<Superhero>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(superheroes) {
            SuperheroItem(superhero = it)
        }
    }
}

@Composable
fun SuperheroItem(superhero: Superhero, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .height(105.dp)
            .fillMaxWidth(),
        elevation = 2.dp,
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = stringResource(superhero.nameRes),
                    style = MaterialTheme.typography.h3
                )
                Text(
                    text = stringResource(superhero.descriptionRes),
                    style = MaterialTheme.typography.body1
                )
            }
            Spacer(Modifier.width(16.dp))
            Image(
                painter = painterResource(superhero.imageRes),
                contentDescription = null,
                modifier = Modifier.clip(RoundedCornerShape(8.dp))
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SuperheroPreview() {
    JetpackComposePlaygroundTheme {
        SuperheroApp()
    }
}

