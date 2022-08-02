package com.nadafeteiha.weatherapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nadafeteiha.weatherapp.api.domain.Data
import com.nadafeteiha.weatherapp.databinding.ItemDaysForecastBinding

class MainAdapter: ListAdapter<Data, MainAdapter.DailyViewHolder>(MainDiffCallback) {

    companion object MainDiffCallback : DiffUtil.ItemCallback<Data>() {
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.datetime == newItem.datetime
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyViewHolder {
        return DailyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: DailyViewHolder, position: Int) {
        val data = getItem(position)
        holder.bind(data)
    }

    class DailyViewHolder(private var binding: ItemDaysForecastBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Data) {
            binding.data = data
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): DailyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemDaysForecastBinding.inflate(layoutInflater, parent, false)
                return DailyViewHolder(binding)
            }
        }
    }
}