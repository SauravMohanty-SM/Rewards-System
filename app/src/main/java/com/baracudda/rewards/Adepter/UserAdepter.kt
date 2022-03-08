package com.baracudda.rewards.Adepter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.baracudda.rewards.ModelView.UserViewModel
import com.baracudda.rewards.R
import com.baracudda.rewards.models.UserDetails

class UserAdepter(private val userList : ArrayList<UserDetails>,
                  private val listener: NameClicked) : RecyclerView.Adapter<UserViewModel>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewModel {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.recyle_view, parent, false)
        val viewHolder = UserViewModel(itemView)
        return UserViewModel(itemView)
    }

    override fun onBindViewHolder(holder: UserViewModel, position: Int) {
        holder.name.text = userList[position].userName
        holder.name.setOnClickListener {
            listener.onItemClicked(userList[position].userID, userList[position].userName)
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    interface NameClicked {
        fun onItemClicked(item: Long, name: String)
    }
}

