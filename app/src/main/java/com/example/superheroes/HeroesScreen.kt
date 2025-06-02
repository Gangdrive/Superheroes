package com.example.superheroes

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.superheroes.data.Hero


@Composable
fun SuperheroesItem(
    hero: Hero,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(
                dimensionResource(R.dimen.padding_8)
            )
            .defaultMinSize(minHeight = dimensionResource(R.dimen.padding_72))
            .clip(MaterialTheme.shapes.medium),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(dimensionResource(R.dimen.padding_8))
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                HeroInformation(hero.name, hero.description, modifier = Modifier.weight(1f))
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
    Column(
        modifier = modifier,
    ) {
        Text(
            text = stringResource(heroName),
            style = MaterialTheme.typography.displaySmall,
            modifier = Modifier
        )
        Text(
            text = stringResource(heroDescription),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier,
            maxLines = 2, // Ограничим описание двумя строками
            overflow = TextOverflow.Ellipsis // Добавим троеточие, если текст не помещается
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
            .size(dimensionResource(R.dimen.image_size_64))
            .clip(MaterialTheme.shapes.small),
        painter = painterResource(heroIcon),
        contentDescription = null
    )
}