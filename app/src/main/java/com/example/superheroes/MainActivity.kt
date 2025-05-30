package com.example.superheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroes.data.Hero
import com.example.superheroes.data.heroes
import com.example.superheroes.ui.theme.SuperheroesTheme
import androidx.compose.foundation.lazy.items

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
    LazyColumn() {
        items(heroes) {it ->
            SuperheroesItem(
                hero = it,
                modifier = Modifier.padding(
                    dimensionResource(R.dimen.padding_small)
                )
            )
        }
    }

}

@Composable
fun SuperheroesItem(
    hero: Hero,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier) {
        Box{
            Row(
                modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium))
            ) {
                HeroInformation(hero.name, hero.description)
                Spacer(Modifier.weight(1f))
                HeroIcon(hero.image)
            }
        }

    }
}

@Composable
fun HeroInformation(
    @StringRes heroName: Int,
    heroDescription: Int,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(heroName),
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier
                .padding(top = dimensionResource(R.dimen.padding_small))
        )
        Text(
            text = stringResource(heroDescription),
            style = MaterialTheme.typography.bodySmall,
        )
    }
}

@Composable
fun HeroIcon(
    @DrawableRes heroIcon: Int,
    modifier: Modifier = Modifier,
) {
    Image(
        modifier = modifier
            .padding(dimensionResource(R.dimen.padding_small))
            .size(dimensionResource(R.dimen.image_size))
            .clip(MaterialTheme.shapes.small),
        painter = painterResource(heroIcon),
        contentDescription = null
    )
}


@Preview(showBackground = true)
@Composable
fun SuperheroesPreview() {
    SuperheroesApp()
}