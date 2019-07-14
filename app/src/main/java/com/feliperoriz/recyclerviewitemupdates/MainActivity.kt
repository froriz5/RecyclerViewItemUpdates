package com.feliperoriz.recyclerviewitemupdates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupTabLayout()
    }

    private fun setupTabLayout() {
        view_pager.adapter = FragmentPagerAdapter(supportFragmentManager)
        tab_layout.setupWithViewPager(view_pager)
    }
}
