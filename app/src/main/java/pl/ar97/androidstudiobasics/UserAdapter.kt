package pl.ar97.androidstudiobasics

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import pl.ar97.androidstudiobasics.databinding.DeveloperRowBinding

class UserAdapter(
    private val users: List<User>,
    private val onUserClick: (User) -> Unit
): RecyclerView.Adapter<UserAdapter.AppViewHolder>() {

    inner class AppViewHolder(binding: DeveloperRowBinding): ViewHolder(binding.root) {
        val image = binding.imageViewRow
        val name = binding.nameTv
        val technology = binding.technologyTv

        init {
            binding.root.setOnClickListener {
                onUserClick(users[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        return AppViewHolder(binding = DeveloperRowBinding
            .inflate(LayoutInflater
                .from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: AppViewHolder, position: Int) {
        holder.image.setImageResource(users[position].image)
        holder.name.text = users[position].name
        holder.technology.text = users[position].technology
    }
}