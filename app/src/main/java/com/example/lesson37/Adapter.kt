package com.example.lesson37

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lesson37.databinding.GameItemBinding

class Adapter :
    RecyclerView.Adapter<Adapter.GameViewHolder>() {

    private var games = mutableListOf<Game>()

    fun addImage(game: MutableList<Game>) {
        games = game
    }

    inner class GameViewHolder(private val binding: GameItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(game: Game) = with(binding) {
            Glide.with(image)
                .load(game.image)
                .placeholder(R.id.image_url_input.toDrawable())
                .into(image)
            name.text = game.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        return GameViewHolder(
            GameItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.onBind(games[position])
    }

    override fun getItemCount() = games.size
}
