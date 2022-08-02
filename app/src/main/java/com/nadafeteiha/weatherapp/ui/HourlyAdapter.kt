package com.nadafeteiha.weatherapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nadafeteiha.weatherapp.api.domain.Data
import com.nadafeteiha.weatherapp.api.domain.DataHourly
import com.nadafeteiha.weatherapp.databinding.ItemHourlyListBinding

class HourlyAdapter : ListAdapter<DataHourly, HourlyAdapter.HourlyViewHolder>(HourlyDiffCallback) {

    companion object HourlyDiffCallback : DiffUtil.ItemCallback<DataHourly>() {
        override fun areItemsTheSame(oldItem: DataHourly, newItem: DataHourly): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: DataHourly, newItem: DataHourly): Boolean {
            return oldItem.timestamp_local == newItem.timestamp_local
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourlyViewHolder {
        return HourlyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: HourlyViewHolder, position: Int) {
        val data = getItem(position)
        holder.bind(data)
    }

    class HourlyViewHolder(private var binding: ItemHourlyListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DataHourly) {
            binding.data = data
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): HourlyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemHourlyListBinding.inflate(layoutInflater, parent, false)
                return HourlyViewHolder(binding)
            }
        }
    }
}