package com.feliperoriz.recyclerviewitemupdates.fragment.changepayload.recyclerview

import androidx.recyclerview.widget.DiffUtil
import com.feliperoriz.recyclerviewitemupdates.common.model.PlanetUIData

class PlanetWithChangePayloadItemCallback: DiffUtil.ItemCallback<PlanetUIData>() {

    override fun areItemsTheSame(oldItem: PlanetUIData, newItem: PlanetUIData): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: PlanetUIData, newItem: PlanetUIData): Boolean {
        return oldItem.isSelected == newItem.isSelected
    }

    override fun getChangePayload(oldItem: PlanetUIData, newItem: PlanetUIData): Any? {
        return PlanetDataChangePayload(newItem)
    }
}