package com.example.notiq.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.notiq.R
import com.example.notiq.databinding.ItemNotesBinding
import com.example.notiq.model.Notes
import com.example.notiq.ui.fragments.HomeFragmentDirections

class NotesAdapter(val requireContext: Context, val notesList: List<Notes>): RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    class NotesViewHolder(val binding: ItemNotesBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        return NotesViewHolder(ItemNotesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val data = notesList[position]
        holder.binding.notesTitle.text = notesList[position].title
        holder.binding.notesSubtitle.text = notesList[position].subtitle
        holder.binding.notesDate.text = notesList[position].date

        when(data.priority){
            "1" -> {
                holder.binding.notesPriority.setBackgroundResource(R.drawable.low_priority)
            }

            "2" -> {
                holder.binding.notesPriority.setBackgroundResource(R.drawable.medium_priority)
            }

            "3" -> {
                holder.binding.notesPriority.setBackgroundResource(R.drawable.high_priority)
            }
        }

        holder.binding.root.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToEditNotesFragment(data)
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return notesList.size
    }


}