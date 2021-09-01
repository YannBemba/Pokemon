package com.example.pokemon.pokemon_detail

import androidx.lifecycle.ViewModel
import com.example.pokemon.data.remote.responses.Pokemon
import com.example.pokemon.repository.PokemonRepository
import com.example.pokemon.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
): ViewModel() {

    suspend fun getPokemonInfo(pokemon: String ): Resource<Pokemon,> {
        return repository.getPokemonInfo(pokemon)
    }

}