package com.example.lojadejogos.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.lojadejogos.R
import com.example.lojadejogos.databinding.FragmentDetailBinding
import java.util.Locale

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    

    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val game = args.game
        
        setupUI(game)
        setupListeners(game)
    }

    private fun setupUI(game: com.example.lojadejogos.model.Game) {
        binding.detailTitle.text = game.title
        binding.detailDeveloper.text = game.developer
        binding.chipCategory.text = game.category
        binding.detailPrice.text = getString(R.string.price_format, game.price)
        binding.detailRating.text = String.format(Locale.US, "%.1f", game.rating)
        binding.detailDescription.text = game.description
        
        if (game.bannerRes != 0) {
            binding.detailBanner.setImageResource(game.bannerRes)
        }
        if (game.thumbnailRes != 0) {
            binding.detailThumbnail.setImageResource(game.thumbnailRes)
        }

        updateBuyButton(game)
        updateFavoriteButton(game)
    }

    private fun setupListeners(game: com.example.lojadejogos.model.Game) {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        binding.btnBuy.setOnClickListener {
            val globalGame = com.example.lojadejogos.data.GameData.games.find { it.id == game.id }
            
            if (!game.isPurchased) {
                // Comprar jogo
                globalGame?.isPurchased = true
                game.isPurchased = true
                android.widget.Toast.makeText(context, "${game.title} comprado!", android.widget.Toast.LENGTH_SHORT).show()
            } else if (!game.isInstalled) {
                // Instalar jogo
                globalGame?.isInstalled = true
                game.isInstalled = true
                android.widget.Toast.makeText(context, "Instalando ${game.title}...", android.widget.Toast.LENGTH_SHORT).show()
            } else {
                // Desinstalar jogo
                globalGame?.isInstalled = false
                game.isInstalled = false
                android.widget.Toast.makeText(context, "${game.title} desinstalado", android.widget.Toast.LENGTH_SHORT).show()
            }
            updateBuyButton(game)
        }

        binding.btnFavorite.setOnClickListener {
            val newState = !game.isFavorite
            com.example.lojadejogos.data.GameData.games.find { it.id == game.id }?.let {
                it.isFavorite = newState
                game.isFavorite = newState
            }
            updateFavoriteButton(game)
        }
    }

    private fun updateBuyButton(game: com.example.lojadejogos.model.Game) {
        when {
            !game.isPurchased -> {
                binding.btnBuy.text = getString(R.string.buy_now)
                binding.btnBuy.isEnabled = true
                binding.btnBuy.setBackgroundColor(requireContext().getColor(R.color.accent_blue))
            }
            !game.isInstalled -> {
                binding.btnBuy.text = getString(R.string.install)
                binding.btnBuy.isEnabled = true
                binding.btnBuy.setBackgroundColor(requireContext().getColor(R.color.primary_blue))
            }
            else -> {
                binding.btnBuy.text = getString(R.string.uninstall)
                binding.btnBuy.isEnabled = true
                binding.btnBuy.setBackgroundColor(requireContext().getColor(R.color.divider))
            }
        }
    }

    private fun updateFavoriteButton(game: com.example.lojadejogos.model.Game) {
        val iconRes = if (game.isFavorite) {
            R.drawable.ic_star_filled
        } else {
            R.drawable.ic_star_outline
        }
        binding.btnFavorite.setIconResource(iconRes)
        
        val colorRes = if (game.isFavorite) R.color.accent_blue else R.color.text_secondary
        binding.btnFavorite.setIconTintResource(colorRes)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
