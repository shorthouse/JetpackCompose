package com.example.jetpackcomposeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeplayground.ui.theme.Coral
import com.example.jetpackcomposeplayground.ui.theme.JetpackComposePlaygroundTheme

class BusinessCardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposePlaygroundTheme() {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
private fun BusinessCard() {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxHeight()
            .background(Coral),
    ) {
        PersonInfo()
        ContactInfo()
    }
}

@Composable
private fun PersonInfo() {
    Column(
        modifier = Modifier
            .padding(top = 256.dp)
    ) {
        AndroidIcon()
        DeveloperName(name = "Harry Shorthouse")
        JobTitle(jobTitle = "Grad Software Dev")
    }
}

@Composable
private fun ContactInfo() {
    Column(
        modifier = Modifier
            .padding(bottom = 32.dp)
    ) {
        ContactInfoCard(iconId = R.drawable.ic_email, contactInfo = "shorthouse20@gmail.com")
        ContactInfoCard(iconId = R.drawable.ic_camera, contactInfo = "@harryshorthouse")
        ContactInfoCard(iconId = R.drawable.ic_phone, contactInfo = "0121 255 9382")
    }
}

@Composable
private fun AndroidIcon() {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = "Android icon",
            modifier = Modifier
                .padding(bottom = 8.dp)
                .size(100.dp)
        )
    }

}

@Composable
private fun DeveloperName(name: String) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = name,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun JobTitle(jobTitle: String) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(text = jobTitle)
    }
}



@Composable
private fun ContactInfoCard(iconId: Int, contactInfo: String) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 4.dp)
    ) {
        Image(
            painter = painterResource(iconId),
            contentDescription = "Contact info icon",
            modifier = Modifier
                .padding(start = 32.dp)
        )
        Text(
            text = contactInfo,
            modifier = Modifier
                .padding(end = 32.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    JetpackComposePlaygroundTheme() {
        BusinessCard()
    }
}