package br.com.up.pokedex

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.com.up.pokedex.network.Api
import com.squareup.picasso.Picasso

class ActivityPokeDetalhes : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_infos_pokedex)

        val id = intent.getStringExtra("id")

        val txtDetalhePokedex: TextView = findViewById(R.id.pokeInfos)
        val imgsDaPokedex: ImageView = findViewById(R.id.pokeImg)
        var informacoesTxt: String = ""

        Api().getDetailsPokemons(id!!) { pokemons ->
            if(pokemons != null){
                informacoesTxt += "Name: "
                informacoesTxt += pokemons.name

                informacoesTxt += "\nMovies: "
                for (ItemPokemon: Int in pokemons.moves.indices){
                    informacoesTxt += pokemons.moves[ItemPokemon].move.name
                }

                informacoesTxt += "\nAbilities: "
                for (ItemPokemon in pokemons.abilities.indices) {
                    informacoesTxt += pokemons.abilities[ItemPokemon].ability.name
                }

               informacoesTxt += "\nTypes: "
               for (ItemPokemon: Int in pokemons.types.indices){
                    informacoesTxt += pokemons.types[ItemPokemon].type.name
                }

                informacoesTxt += "\nStats: "
                for (ItemPokemon: Int in pokemons.stats.indices){
                    informacoesTxt += pokemons.stats[ItemPokemon].stat.name
                }

                val url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${id!!}.png"
                Picasso.get().load(url).into(imgsDaPokedex)

                txtDetalhePokedex.setText(informacoesTxt)
            }
        }

    }

}
