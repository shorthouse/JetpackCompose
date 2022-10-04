package com.example.jetpackcomposeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeplayground.model.Dog
import com.example.jetpackcomposeplayground.model.dogs
import com.example.jetpackcomposeplayground.ui.theme.Green100
import com.example.jetpackcomposeplayground.ui.theme.JetpackComposePlaygroundTheme

class DogListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposePlaygroundTheme {
                WoofApp()
            }
        }
    }
}

@Composable
fun WoofApp() {
    Scaffold(
        topBar = {
            WoofTopAppBar()
        }
    ) {
        LazyColumn(
            modifier = Modifier.background(MaterialTheme.colors.background)
        ) {
            items(dogs) {
                DogItem(dog = it)
            }
        }
    }
}

@Composable 
private fun DogItemButton(
    expanded: Boolean,
    onClick: () -> Unit, 
    modifier: Modifier = Modifier
) {
    IconButton(onClick = onClick) {
        Icon (
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            tint = MaterialTheme.colors.secondary,
            contentDescription = stringResource(R.string.expand_button_content_description)
        )
    }
}

@Composable
fun WoofTopAppBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.primary),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image (
            modifier = Modifier
                .size(64.dp)
                .padding(8.dp),
            painter = painterResource(R.drawable.ic_woof_logo),
            contentDescription = null
        )

        Text (
            text = stringResource(R.string.title_activity_dog_list),
            style = MaterialTheme.typography.h1
        )
    }
}

@Composable
fun DogItem(dog: Dog, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }

    val color by animateColorAsState(
        targetValue = if (expanded) Green100 else MaterialTheme.colors.surface)

    Card(
        modifier = modifier
            .padding(8.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioHighBouncy,
                        stiffness = Spring.StiffnessVeryLow
                    )
                )
                .background(color)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)

            ) {
                DogIcon(dog.imageResourceId)
                DogInformation(dog.name, dog.age)
                Spacer(Modifier.weight(1f))
                DogItemButton(expanded, onClick = { expanded = expanded.not() })
            }
            if (expanded) {
                DogHobby(dog.hobbies)
            }

        }

    }

}

@Composable
fun DogHobby(@StringRes dogHobby: Int, modifier:Modifier = Modifier) {
    Column (
        modifier = modifier.padding(
            start = 16.dp,
            top = 8.dp,
            bottom = 16.dp,
            end = 16.dp
        )
    ) {
        Text (
            text = stringResource(R.string.about),
            style = MaterialTheme.typography.h3,
        )
        Text (
            text = stringResource(dogHobby),
            style = MaterialTheme.typography.body1
        )
    }
}

@Composable
fun DogIcon(@DrawableRes dogIcon: Int, modifier: Modifier = Modifier) {
    Image(
        modifier = modifier
            .size(64.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(50)),
        painter = painterResource(dogIcon),
        contentDescription = null,
        contentScale = ContentScale.Crop,
    )
}

@Composable
fun DogInformation(@StringRes dogName: Int, dogAge: Int, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = stringResource(dogName),
            style = MaterialTheme.typography.h2,
            modifier = modifier.padding(top = 8.dp),
        )
        Text(
            text = stringResource(R.string.years_old, dogAge),
            style = MaterialTheme.typography.body1
        )
    }
}

@Preview
@Composable
fun WoofPreview() {
    JetpackComposePlaygroundTheme(darkTheme = false) {
        WoofApp()
    }
}

@Preview
@Composable
fun DarkThemePreview() {
    JetpackComposePlaygroundTheme(darkTheme = true) {
        WoofApp()
    }
}
