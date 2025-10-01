package com.example.viewmodels

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.viewmodels.data.DataSource
import com.example.viewmodels.ui.theme.ViewModelsTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ViewModelsTheme {

            }
        }
    }
}

@Composable
fun PersonWithoutState(
    personIndex: Int,
    onPrevious: () -> Unit,
    onNext: () -> Unit,
    modifier: Modifier = Modifier
) {
    val person = DataSource.people[personIndex]

    Column(modifier = modifier.padding(16.dp)) {
        Surface(shadowElevation = 10.dp) {
            Image(
                painter = painterResource(id = person.image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(10.dp),
                contentScale = ContentScale.Crop
            )
        }

        Text(text = person.name)
        Text(text = person.desc, modifier = Modifier.padding(vertical = 8.dp))

        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Button(onClick = onPrevious, modifier = Modifier.padding(end = 8.dp)) {
                Text("Anterior")
            }
            Button(onClick = onNext) {
                Text("Próximo")
            }
        }
    }
}

@Composable
fun PersonWithState(modifier: Modifier = Modifier) {
    var personCounter by rememberSaveable { mutableIntStateOf(0) }
    val totalPeople = DataSource.people.size

    PersonWithoutState(
        personIndex = personCounter,
        onPrevious = {
            personCounter =  (personCounter - 1).mod(DataSource.people.size)
        },
        onNext = {
            personCounter =  (personCounter + 1).mod(DataSource.people.size)
        },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun PersonWithStatePreview() {
    ViewModelsTheme {
        PersonWithState()
    }
}