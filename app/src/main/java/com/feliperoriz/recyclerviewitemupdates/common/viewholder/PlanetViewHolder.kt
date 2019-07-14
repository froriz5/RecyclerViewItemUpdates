package com.feliperoriz.recyclerviewitemupdates.common.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.feliperoriz.recyclerviewitemupdates.common.model.PlanetUIData

import kotlinx.android.extensions.LayoutContainer

import kotlinx.android.synthetic.main.planet_row_item.*

class PlanetViewHolder(override val containerView: View): RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bindName(name: String) {
        title.text = name
    }

    fun bindSelected(isSelected: Boolean) {
        checkbox.isChecked = isSelected
    }

    inline fun setClickListener(crossinline onClick: () -> Unit) {
        containerView.setOnClickListener { onClick() }
    }
}