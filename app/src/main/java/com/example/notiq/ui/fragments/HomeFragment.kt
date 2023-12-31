package com.example.notiq.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.notiq.R
import com.example.notiq.databinding.FragmentHomeBinding
import com.example.notiq.ui.adapter.NotesAdapter
import com.example.notiq.viewmodel.NotesViewModel


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    val viewModel: NotesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        viewModel.getNote().observe(viewLifecycleOwner) { notesList ->
            binding.rcvAllNotes.layoutManager = GridLayoutManager(context, 2)
            binding.rcvAllNotes.adapter = NotesAdapter(requireContext(), notesList)
        }
        binding.btnAddNotes.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_createNotesFragment)
        }

        return binding.root
    }


}