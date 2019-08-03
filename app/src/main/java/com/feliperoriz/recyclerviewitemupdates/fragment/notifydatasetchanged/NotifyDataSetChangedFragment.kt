package com.feliperoriz.recyclerviewitemupdates.fragment.notifydatasetchanged

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.feliperoriz.recyclerviewitemupdates.R
import com.feliperoriz.recyclerviewitemupdates.common.model.PlanetUIData
import com.feliperoriz.recyclerviewitemupdates.fragment.notifydatasetchanged.recyclerview.NotifyDataSetChangedAdapter
import kotlinx.android.synthetic.main.notify_dataset_changed_fragment.*

class NotifyDataSetChangedFragment: Fragment(R.layout.notify_dataset_changed_fragment) {

    private lateinit var planetAdapter: NotifyDataSetChangedAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }

    private fun setup() {
        setupClickListeners()

        planetAdapter = NotifyDataSetChangedAdapter(layoutInflater)
        planetAdapter.onClickPlanet = this::onClickPlanet

        recycler_view.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = planetAdapter
            setHasFixedSize(true)
        }

        val dataset: List<PlanetUIData> = getInitialDataSet()
        planetAdapter.planets = dataset
    }

    private fun setupClickListeners() {
        select_all_button.setOnClickListener {
            selectAllPlanets()
        }
        deselect_all_button.setOnClickListener {
            deselectAllPlanets()
        }
    }

    private fun onClickPlanet(clickedPlanetData: PlanetUIData) {
        val currentDataSet = planetAdapter.planets

        // Update selected state
        val updatedPlanet = clickedPlanetData.copy(isSelected = !clickedPlanetData.isSelected)

        val updatedDataset =
            currentDataSet
                .filter { it != clickedPlanetData } // Remove the clicked planet
                .toMutableList()
                .apply { add(updatedPlanet) } // Add the new updated clicked planet
                .sortedBy { it.order } // Re-sort the list

        planetAdapter.planets = updatedDataset
    }

    private fun selectAllPlanets() {
        bulkSelectPlanets(true)
    }

    private fun deselectAllPlanets() {
        bulkSelectPlanets(false)
    }

    private fun bulkSelectPlanets(shouldSelect: Boolean) {
        val currentDataSet = planetAdapter.planets


        val updatedDataset =
            currentDataSet
                .map { it.copy(isSelected = shouldSelect) }
                .sortedBy { it.order } // Re-sort the list

        planetAdapter.planets = updatedDataset
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