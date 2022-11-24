package br.com.up.pokedex.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import br.com.up.pokedex.R
import br.com.up.pokedex.extension.id
import br.com.up.pokedex.model.Pokemon
import com.squareup.picasso.Picasso

class PokeAdapter(
    private val listDePokemon: List<Pokemon>,
    private val listener:(pokemon: Pokemon) -> Unit) :
    RecyclerView.Adapter
    <PokeAdapter.PokeViewHolder>() {

    inner class PokeViewHolder(itemView:View) :
        RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val layout = inflater.inflate(R.layout.view_poke_item, parent, false)

        return PokeViewHolder(layout)
    }

    override fun onBindViewHolder(holder: PokeViewHolder, position: Int) {

        val umPokemon = listDePokemon[position]

        val uri = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${umPokemon.id()}.png"

        val imgView : ImageView = holder.itemView.findViewById(R.id.image_pokemon)

        holder.itemView.setOnClickListener {
            listener(umPokemon)
        }

        Picasso.get().load(uri).into(imgView)
    }

    override fun getItemCount(): Int {
        val quantidadePokemons = listDePokemon.size

        return quantidadePokemons
    }
}