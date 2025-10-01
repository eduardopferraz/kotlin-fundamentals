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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.viewmodels.data.PersonViewModel
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
fun Person(
    modifier: Modifier = Modifier,
    viewModel: PersonViewModel = viewModel()
) {

    val uiState by viewModel.uiState.collectAsState()

    Column(modifier = modifier.padding(16.dp)) {
        Surface(shadowElevation = 10.dp) {
            Image(
                painter = painterResource(id = uiState.person.image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(10.dp),
                contentScale = ContentScale.Crop
            )
        }

        Text(text = uiState.person.name)

        Text(text = uiState.person.desc, modifier = Modifier.padding(vertical = 8.dp))

        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Button(onClick = { viewModel.previousPerson() } , modifier = Modifier.padding(end = 8.dp)) {
                Text(stringResource(R.string.previous))
            }
            Button(onClick = { viewModel.nextPerson() } ) {
                Text(stringResource(R.string.next))
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PersonWithStatePreview() {
    ViewModelsTheme {
        Person()
    }
}