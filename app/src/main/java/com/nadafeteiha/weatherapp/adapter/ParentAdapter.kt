package com.nadafeteiha.weatherapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nadafeteiha.weatherapp.R
import com.nadafeteiha.weatherapp.databinding.ListHourlyLayoutBinding

class ParentAdapter(private val adapter: HourlyAdapter) :
    RecyclerView.Adapter<ParentAdapter.BaseHomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHomeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_hourly_layout, parent, false)
        return HourlyViewHolder(view)

    }

    override fun onBindViewHolder(holder: BaseHomeViewHolder, position: Int) {
        bindHourly(holder as HourlyViewHolder)
    }

    private fun bindHourly(holder: HourlyViewHolder) {
        holder.binding.apply {
            recyclerHourly.adapter = adapter
        }
    }

    override fun getItemCount(): Int = 1

    abstract class BaseHomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView.rootView)

    class HourlyViewHolder(itemView: View) : BaseHomeViewHolder(itemView) {
        val binding = ListHourlyLayoutBinding.bind(itemView)
    }
}