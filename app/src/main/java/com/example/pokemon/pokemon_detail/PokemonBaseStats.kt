package com.example.pokemon.pokemon_detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokemon.data.remote.responses.Pokemon
import com.example.pokemon.util.parseStatToAbbr
import com.example.pokemon.util.parseStatToColor

@Composable
fun PokemonBaseStats(
    pokemonInfo: Pokemon,
    animDelayPerItem: Int = 100
) {
    val maxBaseStat = remember {
        pokemonInfo.stats.maxOf { it.base_stat }
    }
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Base stats: ",
            fontSize = 20.sp,
            color = MaterialTheme.colors.onSurface,
        )
        Spacer(modifier = Modifier.height(4.dp))

        for(i in pokemonInfo.stats.indices) {
            val stat = pokemonInfo.stats[i]
            PokemonStat(
                statName = parseStatToAbbr(stat),
                statValue = stat.base_stat,
                statMaxValue = maxBaseStat,
                statColor = parseStatToColor(stat),
                animDelay = animDelayPerItem
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}