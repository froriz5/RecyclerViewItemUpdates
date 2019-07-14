package com.feliperoriz.recyclerviewitemupdates.fragment.diffutil.recyclerview

import androidx.recyclerview.widget.DiffUtil
import com.feliperoriz.recyclerviewitemupdates.common.model.PlanetUIData

class PlanetItemCallback: DiffUtil.ItemCallback<PlanetUIData>() {

    override fun areItemsTheSame(oldItem: PlanetUIData, newItem: PlanetUIData): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: PlanetUIData, newItem: PlanetUIData): Boolean {
        return oldItem.isSelected == newItem.isSelected
    }

}