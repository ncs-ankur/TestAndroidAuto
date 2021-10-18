package com.example.testandroidauto

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.sharedmodule.*
import com.example.sharedmodule.RxEvent.postEvent

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        postEvent(ShowHomeScreen())
    }

    protected fun popAllFragments() {
        for (i in 0 until supportFragmentManager.getBackStackEntryCount()) {
            supportFragmentManager.popBackStack()
        }
    }

    private fun addHomeFragment() {
        popAllFragments()
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

    override fun onEventFromCar(event: TestEvent) {
        super.onEventFromCar(event)
        when (event) {
            is ShowHomeScreen -> {
                addHomeFragment()
            }

            is ShowSearch -> {
                addSearchFragment()
            }

            is CancelSearch -> {
                addHomeFragment()
            }

            is ShowRoutePlanning -> {
                addRoutePlanningFragment()
            }

            is CancelRoutePlanning -> {
                addHomeFragment()
            }

            is StartCruiseMode -> {
                addCruiseModeFragment()
            }

            is StopCruiseMode -> {
                addHomeFragment()
            }

            is StartNavigation -> {
                addNavigationFragment()
            }

            is StopNavigation -> {
                addHomeFragment()
            }
        }

    }
}