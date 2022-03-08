package com.baracudda.rewards.Adepter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.baracudda.rewards.ModelView.ServiceViewModel
import com.baracudda.rewards.R
import com.baracudda.rewards.models.Services

class ServiceAdepter(private val serviceList : ArrayList<Services>) : RecyclerView.Adapter<ServiceViewModel>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewModel {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.recycle_view_for_services, parent, false)
        return ServiceViewModel(itemView)
    }

    override fun onBindViewHolder(holder: ServiceViewModel, position: Int) {
        holder.SerName.text = serviceList[position].ServiceName
        holder.SerDesc.text = serviceList[position].ServiceDesc
        holder.SerRewd.text = serviceList[position].ServiceReward.toString()
    }

    override fun getItemCount(): Int {
        return serviceList.size
    }
}