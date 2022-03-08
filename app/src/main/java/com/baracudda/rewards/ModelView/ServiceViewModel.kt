package com.baracudda.rewards.ModelView

import android.view.TextureView
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.baracudda.rewards.R

class ServiceViewModel(itemView : View) : RecyclerView.ViewHolder(itemView) {
    val SerName = itemView.findViewById<TextView>(R.id.ServiceName)
    val SerDesc = itemView.findViewById<TextView>(R.id.ServiceDescription)
    val SerRewd = itemView.findViewById<TextView>(R.id.ServiceReward)
}