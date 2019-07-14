package com.feliperoriz.recyclerviewitemupdates.fragment.notifydatasetchanged.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.feliperoriz.recyclerviewitemupdates.R
import com.feliperoriz.recyclerviewitemupdates.common.viewholder.PlanetViewHolder
import com.feliperoriz.recyclerviewitemupdates.common.model.PlanetUIData

class NotifyDataSetChangedAdapter(private val inflator: LayoutInflater): RecyclerView.Adapter<PlanetViewHolder>() {

    var onClickPlanet: (PlanetUIData) -> Unit = {}

    var planets: List<PlanetUIData> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetViewHolder {
        val view = inflator.inflate(R.layout.planet_row_item, parent, false)
        return PlanetViewHolder(view)
    }

    override fun getItemCount(): Int = planets.size

    override fun onBindViewHolder(holder: PlanetViewHolder, position: Int) {
        val planetData = planets[position]
        holder.bindName(planetData.name)
        holder.bindSelected(planetData.isSelected)
        holder.apply {
            bindName(planetData.name)
            bindSelected(planetData.isSelected)
            setClickListener { onClickPlanet(planetData) }
        }
    }
}