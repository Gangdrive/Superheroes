package com.example.superheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroes.data.heroes
import com.example.superheroes.ui.theme.SuperheroesTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperheroesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    SuperheroesApp()
                }
            }
        }
    }
}

@Composable
fun SuperheroesApp() {
    Scaffold(topBar = {
        SuperheroesTopBarApp()
    }) { it ->
        LazyColumn(contentPadding = it) {
            items(heroes) {
                SuperheroesItem(
                    hero = it,
                    modifier = Modifier.padding(
                        dimensionResource(R.dimen.padding_8)
                    )
                )
            }
        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperheroesTopBarApp(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.superheroes),
                style = MaterialTheme.typography.displayLarge
            )
        },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun SuperheroesPreview() {
    SuperheroesApp()
}

@Preview(showBackground = true)
@Composable
fun SuperheroesDarkThemePreview() {
    SuperheroesTheme(darkTheme = true) {
        SuperheroesApp()
    }

}