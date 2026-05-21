package com.example.lojadejogos.ui.store

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lojadejogos.data.GameData
import com.example.lojadejogos.databinding.FragmentStoreBinding
import com.example.lojadejogos.ui.adapter.GameAdapter

class StoreFragment : Fragment() {

    private var _binding: FragmentStoreBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupBanner()
        setupRecyclerView()
    }

    private fun setupBanner() {
        val featuredGame = GameData.games.find { it.title == "Elden Ring" }
        featuredGame?.let {
            binding.bannerImage.setImageResource(it.bannerRes)
            binding.bannerCard.setOnClickListener { _ ->
                val action = StoreFragmentDirections.actionStoreToDetail(it)
                findNavController().navigate(action)
            }
        }
    }

    private fun setupRecyclerView() {
        val adapter = GameAdapter(GameData.games) { game ->
            val action = StoreFragmentDirections.actionStoreToDetail(game)
            findNavController().navigate(action)
        }
        binding.rvFeaturedGames.layoutManager = LinearLayoutManager(context)
        binding.rvFeaturedGames.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
