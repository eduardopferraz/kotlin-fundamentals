package com.example.myfirstapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
                    ArrangementColumns()
                }
            }
        }
    }
}


@Composable
fun ArrangementColumns(modifier: Modifier = Modifier) {
    Column (
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,

    ) {
        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
        )

        Text(
            text = "Tênis de mesa",
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )

        Text(
            text = "O tênis de mesa surgiu na Inglaterra no século XIX imitando o jogo de tênis em um ambiente fechado.",
            modifier = Modifier
                .padding(horizontal = 16.dp),
            textAlign = TextAlign.Justify
        )

        Text(
            text = "Uma partida de tênis de mesa é disputada em melhor de qualquer número de sets ímpares. Usualmente, torneios nacionais são disputados em melhor de 5 sets e torneios internacionais em melhor de 7 sets, o que significa que o jogador ou dupla que vencer, respectivamente, 3 ou 4 sets vence a partida. Para vencer um set, o jogador ou a dupla precisa conseguir 11 pontos, ou em caso de empate em 10 pontos, somar dois pontos de vantagem em relação ao seu adversário.",
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Justify
        )

    }


}

@Preview(showBackground = true)
@Composable
private fun FundoPreview() {
    ArrangementColumns()
}