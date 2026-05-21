package com.example.lojadejogos.ui.library

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lojadejogos.data.GameData
import com.example.lojadejogos.databinding.FragmentLibraryBinding
import com.example.lojadejogos.ui.adapter.GameAdapter
import com.google.android.material.tabs.TabLayout

class LibraryFragment : Fragment() {

    private var _binding: FragmentLibraryBinding? = null
    private val binding get() = _binding!!
    private var gameAdapter: GameAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLibraryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupTabs()
        updateList(0) // Default: TODOS
    }

    private fun setupRecyclerView() {
        gameAdapter = GameAdapter(emptyList()) { game ->
            val action = LibraryFragmentDirections.actionLibraryToDetail(game)
            findNavController().navigate(action)
        }
        binding.rvLibraryGames.layoutManager = LinearLayoutManager(context)
        binding.rvLibraryGames.adapter = gameAdapter
    }

    private fun setupTabs() {
        binding.libraryTabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                updateList(tab?.position ?: 0)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }

    private fun updateList(position: Int) {
        val gamesToShow = when(position) {
            0 -> GameData.games.filter { it.isPurchased } // TODOS (Comprados)
            1 -> GameData.games.filter { it.isInstalled } // INSTALADOS
            2 -> GameData.games.filter { it.isFavorite }  // FAVORITOS
            else -> GameData.games.filter { it.isPurchased }
        }

        gameAdapter?.updateData(gamesToShow)
    }

    override fun onResume() {
        super.onResume()
        updateList(binding.libraryTabs.selectedTabPosition)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
