package com.feliperoriz.recyclerviewitemupdates

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

import com.feliperoriz.recyclerviewitemupdates.fragment.changepayload.ChangePayloadFragment
import com.feliperoriz.recyclerviewitemupdates.fragment.diffutil.DiffUtilFragment
import com.feliperoriz.recyclerviewitemupdates.fragment.notifydatasetchanged.NotifyDataSetChangedFragment

class FragmentPagerAdapter(fm: FragmentManager): FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> NotifyDataSetChangedFragment()
            1 -> DiffUtilFragment()
            else -> ChangePayloadFragment()
        }
    }

    override fun getCount(): Int = 3

}