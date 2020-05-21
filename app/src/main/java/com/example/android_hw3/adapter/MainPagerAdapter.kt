package com.example.android_hw3.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.android_hw3.fragment.HomeFragment
import com.example.android_hw3.fragment.LibraryFragment
import com.example.android_hw3.fragment.MyPageFragment

class MainPagerAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> HomeFragment()
            1 -> LibraryFragment()
            else -> MyPageFragment()
        }
    }

    override fun getCount(): Int = 3
}