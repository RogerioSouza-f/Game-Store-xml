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

class LibraryFragment : Fragment() {

    private var _binding: FragmentLibraryBinding? = null
    private val binding get() = _binding!!

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
    }

    private fun setupRecyclerView() {

        val installedGames = GameData.games.filter { it.isInstalled }
        
        val adapter = GameAdapter(installedGames) { game ->
            val action = LibraryFragmentDirections.actionLibraryToDetail(game)
            findNavController().navigate(action)
        }
        binding.rvLibraryGames.layoutManager = LinearLayoutManager(context)
        binding.rvLibraryGames.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
