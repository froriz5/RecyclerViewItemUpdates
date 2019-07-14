package com.feliperoriz.recyclerviewitemupdates.fragment.diffutil.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter

import com.feliperoriz.recyclerviewitemupdates.R
import com.feliperoriz.recyclerviewitemupdates.common.viewholder.PlanetViewHolder
import com.feliperoriz.recyclerviewitemupdates.common.model.PlanetUIData

class DiffUtilAdapter(itemCallback: PlanetItemCallback,
                      private val inflator: LayoutInflater): ListAdapter<PlanetUIData, PlanetViewHolder>(itemCallback) {

    var onClickPlanet: (PlanetUIData) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetViewHolder {
        val view = inflator.inflate(R.layout.planet_row_item, parent, false)
        return PlanetViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlanetViewHolder, position: Int) {
        val planetData = getItem(position)
        holder.bindName(planetData.name)
        holder.bindSelected(planetData.isSelected)
        holder.apply {
            bindName(planetData.name)
            bindSelected(planetData.isSelected)
            setClickListener { onClickPlanet(planetData) }
        }
    }
}