package com.example.notiq.ui.fragments

import android.os.Bundle
import android.text.format.DateFormat
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.notiq.R
import com.example.notiq.databinding.FragmentEditNotesBinding
import com.example.notiq.model.Notes
import com.example.notiq.viewmodel.NotesViewModel
import java.util.Date


class EditNotesFragment : Fragment() {

    val notes by navArgs<EditNotesFragmentArgs>()
    lateinit var binding: FragmentEditNotesBinding
    val viewModel: NotesViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEditNotesBinding.inflate(layoutInflater, container, false)

        binding.editTitle.setText(notes.data.title)
        binding.editSubtitle.setText(notes.data.subtitle)
        binding.editNote.setText(notes.data.note)

        when(notes.data.priority){
            "1" -> {
                binding.editPriorityLow.setImageResource(R.drawable.baseline_done_24)
                binding.editPriorityMedium.setImageResource(0)
                binding.editPriorityHigh.setImageResource(0)
                notes.data.priority = "1"
            }

            "2" -> {
                binding.editPriorityMedium.setImageResource(R.drawable.baseline_done_24)
                binding.editPriorityLow.setImageResource(0)
                binding.editPriorityHigh.setImageResource(0)
                notes.data.priority = "2"
            }

            "3" -> {
                binding.editPriorityHigh.setImageResource(R.drawable.baseline_done_24)
                binding.editPriorityMedium.setImageResource(0)
                binding.editPriorityLow.setImageResource(0)
                notes.data.priority = "3"
            }
        }

//        for updating priority
        binding.editPriorityLow.setOnClickListener {
            binding.editPriorityLow.setImageResource(R.drawable.baseline_done_24)
            binding.editPriorityMedium.setImageResource(0)
            binding.editPriorityHigh.setImageResource(0)
            notes.data.priority = "1"
        }

        binding.editPriorityMedium.setOnClickListener {
            binding.editPriorityMedium.setImageResource(R.drawable.baseline_done_24)
            binding.editPriorityLow.setImageResource(0)
            binding.editPriorityHigh.setImageResource(0)
            notes.data.priority = "2"
        }

        binding.editPriorityHigh.setOnClickListener {
            binding.editPriorityHigh.setImageResource(R.drawable.baseline_done_24)
            binding.editPriorityMedium.setImageResource(0)
            binding.editPriorityLow.setImageResource(0)
            notes.data.priority = "3"
        }

        binding.btnUpdateNotes.setOnClickListener {
            updateNotes(it)
        }

        return binding.root
    }

    private fun updateNotes(it: View?) {

        val title = binding.editTitle.text
        val subtitle = binding.editSubtitle.text
        val note = binding.editNote.text

        val d = Date()
        val date: CharSequence = DateFormat.format("MMMM d, yyyy", d.time)


        val notes = Notes(notes.data.id, title = title.toString(),
            subtitle = subtitle.toString(),
            note = note.toString(),
            date = date.toString(),
            priority = notes.data.priority
        )

        viewModel.updateNotes(notes)

        Toast.makeText(context, "Note Updated Successfully", Toast.LENGTH_SHORT).show()

        Navigation.findNavController(it!!).navigate(R.id.action_editNotesFragment_to_homeFragment)
    }


}