package com.example.myfirstapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfirstapp.ui.theme.MyFirstAppTheme

class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    HydrationWithState()
                }
            }
        }
    }
}


@Composable
fun Hydration(modifier: Modifier = Modifier) {

    Surface (
       modifier = modifier
           .padding(16.dp)
           .windowInsetsPadding(WindowInsets.statusBars)
    ) {
        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            var counter by remember { mutableIntStateOf(0) }

            Text(
                modifier = Modifier.padding(vertical = 16.dp),
                text = "You drunk $counter cups of water.",
                style = MaterialTheme.typography.headlineSmall
            )

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { counter++ },
                enabled = counter < 10
            ) {
                Text(
                    text = "Drink water",
                    style = MaterialTheme.typography.headlineSmall
                )
            }
        }
    }
}

@Composable
fun HydrationWithoutState(
    counter: Int,
    onValueChange: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(16.dp)) {
        Text("You drunk $counter cups today!")
        Button(
            onClick = { onValueChange() }, enabled = counter < 10
        ) {
            Text("Drink")
        }
    }
}

@Composable
fun HydrationWithState(modifier: Modifier = Modifier) {
    var waterCounter by rememberSaveable { mutableIntStateOf(0) }
    var juiceCounter by rememberSaveable { mutableIntStateOf(0) }
    Column(modifier= modifier.fillMaxSize()) {
        HydrationWithoutState(counter = waterCounter, onValueChange = { waterCounter++ })
        HydrationWithoutState(counter = juiceCounter, onValueChange = { juiceCounter++ })
    }
}



@Preview(showBackground = true)
@Composable
private fun HydrationPreview() {
    HydrationWithState()
}