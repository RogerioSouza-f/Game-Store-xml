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
    
    // O erro de referência desaparecerá após o "Build > Make Project"
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
        
        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
