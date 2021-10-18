package com.example.testandroidauto

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //postEvent(ShowHomeScreen())
        //addHomeFragment()
    }

    private fun addHomeFragment() {
        replaceFragment(FragmentHome.newInstance("", ""))
    }

    private fun addCruiseModeFragment() {
        replaceFragment(FragmentCruiseMode.newInstance("", ""))
    }

    private fun addRoutePlanningFragment() {
        replaceFragment(FragmentRoutePlanning.newInstance("", ""))
    }

    private fun addNavigationFragment() {
        replaceFragment(FragmentNavigation.newInstance("", ""))
    }

    private fun addSearchFragment() {
        replaceFragment(FragmentSearch.newInstance("", ""))
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.container, fragment)
            .addToBackStack(fragment.javaClass.name)
            .commit()
    }
}