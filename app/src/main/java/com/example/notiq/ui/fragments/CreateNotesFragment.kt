package com.example.notiq.ui.fragments

import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.notiq.R
import com.example.notiq.databinding.FragmentCreateNotesBinding
import com.example.notiq.model.Notes
import com.example.notiq.viewmodel.NotesViewModel
import java.util.Date

class CreateNotesFragment : Fragment() {

    lateinit var binding: FragmentCreateNotesBinding
    var priority: String = "1"
    val viewModel: NotesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCreateNotesBinding.inflate(layoutInflater, container, false)

        binding.priorityLow.setImageResource(R.drawable.baseline_done_24)

        binding.priorityLow.setOnClickListener {
            binding.priorityLow.setImageResource(R.drawable.baseline_done_24)
            binding.priorityMedium.setImageResource(0)
            binding.priorityHigh.setImageResource(0)
            priority = "1"
        }

        binding.priorityMedium.setOnClickListener {
            binding.priorityMedium.setImageResource(R.drawable.baseline_done_24)
            binding.priorityLow.setImageResource(0)
            binding.priorityHigh.setImageResource(0)
            priority = "2"
        }

        binding.priorityHigh.setOnClickListener {
            binding.priorityHigh.setImageResource(R.drawable.baseline_done_24)
            binding.priorityMedium.setImageResource(0)
            binding.priorityLow.setImageResource(0)
            priority = "3"
        }

        binding.btnSaveNotes.setOnClickListener {
            createNotes(it)
        }

        return binding.root
    }

    private fun createNotes(it: View?) {
        val title = binding.title.text
        val subtitle = binding.subtitle.text
        val note = binding.note.text

        val d = Date()
        val date: CharSequence = DateFormat.format("MMMM d, yyyy", d.time)


        val notes = Notes(0, title = title.toString(),
            subtitle = subtitle.toString(),
            note = note.toString(),
            date = date.toString(),
            priority = priority
        )

        viewModel.addNotes(notes)

        Toast.makeText(context, "Noted Successfully", Toast.LENGTH_SHORT).show()

        Navigation.findNavController(it!!).navigate(R.id.action_createNotesFragment_to_homeFragment)
    }


}