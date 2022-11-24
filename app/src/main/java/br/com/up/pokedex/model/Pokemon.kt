package br.com.up.pokedex.model

import com.google.gson.annotations.SerializedName

data class Pokemon(
    val name:String,
    val url:String,
    val moves:List<Moves>,
    val abilities:List<Abilities>,
    val types:List<Types>,
    val stats:List<Stats>
)
