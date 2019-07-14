package com.feliperoriz.recyclerviewitemupdates.fragment.changepayload

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.feliperoriz.recyclerviewitemupdates.R
import com.feliperoriz.recyclerviewitemupdates.common.model.PlanetUIData
import com.feliperoriz.recyclerviewitemupdates.fragment.changepayload.recyclerview.ChangePayloadAdapter
import com.feliperoriz.recyclerviewitemupdates.fragment.changepayload.recyclerview.PlanetWithChangePayloadItemCallback
import kotlinx.android.synthetic.main.change_payload_fragment.*

class ChangePayloadFragment: Fragment(R.layout.change_payload_fragment) {

    private lateinit var planetAdapter: ChangePayloadAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }

    private fun setup() {
        val itemCallback = PlanetWithChangePayloadItemCallback()
        planetAdapter = ChangePayloadAdapter(itemCallback, layoutInflater)
        planetAdapter.onClickPlanet = this::onClickPlanet

        recycler_view.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = planetAdapter
            setHasFixedSize(true)
        }

        val dataset: List<PlanetUIData> = getInitialDataSet()
        planetAdapter.submitList(dataset)
    }

    private fun onClickPlanet(clickedPlanetData: PlanetUIData) {
        val currentDataSet = planetAdapter.currentList

        // Update selected state
        val updatedPlanet = clickedPlanetData.copy(isSelected = !clickedPlanetData.isSelected)

        val updatedDataset =
            currentDataSet
                .filter { it != clickedPlanetData } // Remove the clicked planet
                .toMutableList()
                .apply { add(updatedPlanet) } // Add the new updated clicked planet
                .sortedBy { it.order } // Re-sort the list

        planetAdapter.submitList(updatedDataset)
    }

    private fun getInitialDataSet(): List<PlanetUIData> {
        return mutableListOf<PlanetUIData>().apply {
            add(PlanetUIData("Mercury", 0))
            add(PlanetUIData("Venus", 1))
            add(PlanetUIData("Earth", 2))
            add(PlanetUIData("Mars", 3))
            add(PlanetUIData("Jupiter", 4))
            add(PlanetUIData("Saturn", 5))
            add(PlanetUIData("Neptune", 6))
            add(PlanetUIData("Uranus", 7))
            add(PlanetUIData("Pluto", 8))
        }
    }
}