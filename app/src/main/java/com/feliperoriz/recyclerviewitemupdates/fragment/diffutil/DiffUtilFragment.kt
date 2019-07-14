package com.feliperoriz.recyclerviewitemupdates.fragment.diffutil

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.feliperoriz.recyclerviewitemupdates.R
import com.feliperoriz.recyclerviewitemupdates.common.model.PlanetUIData
import com.feliperoriz.recyclerviewitemupdates.fragment.diffutil.recyclerview.DiffUtilAdapter
import com.feliperoriz.recyclerviewitemupdates.fragment.diffutil.recyclerview.PlanetItemCallback
import kotlinx.android.synthetic.main.diff_util_fragment.*

class DiffUtilFragment: Fragment(R.layout.diff_util_fragment) {

    private lateinit var planetAdapter: DiffUtilAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }

    private fun setup() {
        val itemCallback = PlanetItemCallback()
        planetAdapter = DiffUtilAdapter(itemCallback, layoutInflater)
        planetAdapter.onClickPlanet = this::onClickPlanet

        recycler_view.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = planetAdapter
            setHasFixedSize(true)
        }

        val dataset: List<PlanetUIData> = getInitialDataSet()
        planetAdapter.submitList(dataset)
    }

    private fun onClickPlanet(planetData: PlanetUIData) {
        val currentDataSet = planetAdapter.currentList
        val clickedPlanet = currentDataSet.find { it.name == planetData.name }!!

        // Update selected state
        val updatedPlanet = clickedPlanet.copy(isSelected = !clickedPlanet.isSelected)

        val updatedDataset =
            currentDataSet
                .filter { it != clickedPlanet } // Remove the clicked planet
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