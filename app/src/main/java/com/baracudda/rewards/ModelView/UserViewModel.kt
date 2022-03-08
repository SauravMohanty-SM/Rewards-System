package com.baracudda.rewards.ModelView

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.baracudda.rewards.R

class UserViewModel(itemView : View) : RecyclerView.ViewHolder(itemView) {
    val name = itemView.findViewById<TextView>(R.id.Name)
}