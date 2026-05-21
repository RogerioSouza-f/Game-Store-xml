package com.example.lojadejogos.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lojadejogos.R
import com.example.lojadejogos.databinding.ItemGameBinding
import com.example.lojadejogos.model.Game
import java.util.Locale

class GameAdapter(
    private val games: List<Game>,
    private val onItemClick: (Game) -> Unit
) : RecyclerView.Adapter<GameAdapter.GameViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val binding = ItemGameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GameViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.bind(games[position])
    }

    override fun getItemCount(): Int = games.size

    inner class GameViewHolder(private val binding: ItemGameBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(game: Game) {
            val context = binding.root.context
            binding.gameTitle.text = game.title
            binding.gameCategory.text = game.category
            binding.gamePrice.text = context.getString(R.string.price_format, game.price)
            binding.gameRating.text = String.format(Locale.US, "%.1f", game.rating)
            
            if (game.thumbnailRes != 0) {
                binding.gameThumbnail.setImageResource(game.thumbnailRes)
            }
            
            binding.root.setOnClickListener { onItemClick(game) }
        }
    }
}
