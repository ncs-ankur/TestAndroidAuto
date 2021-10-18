package com.example.car_app

import android.content.Intent
import androidx.car.app.Screen
import androidx.car.app.ScreenManager
import com.example.sharedmodule.*

class TestCarBreezeSession : BaseSession() {

    lateinit var screenManager: ScreenManager

    override fun onCreateScreen(intent: Intent): Screen {
        screenManager = carContext.getCarService(ScreenManager::class.java)
        return ScreenHome(carContext)
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
    }

//    private fun addHomeFragment() {
//        popAllFragments()
//        screenManager.push(ScreenHome(carContext))
//    }

    private fun addCruiseModeFragment() {
        screenManager.push(ScreenCruiseMode(carContext))
    }

    private fun addRoutePlanningFragment() {
        screenManager.push(ScreenRoutePlanning(carContext))
    }

    private fun addNavigationFragment() {
        screenManager.push(ScreenNavigation(carContext))
    }

    private fun addSearchFragment() {
        screenManager.push(ScreenSearch(carContext))
    }

    private fun popAllFragments() {
        screenManager.popToRoot()
    }

    private fun popTopFragments() {
        screenManager.pop()
    }

    override fun handleEvent(event: TestEvent?) {
        super.handleEvent(event)
        when (event) {
            is ShowHomeScreen -> {
                popAllFragments()
            }

            is ShowSearch -> {
                addSearchFragment()
            }

            is CancelSearch -> {
                popTopFragments()
            }

            is ShowRoutePlanning -> {
                addRoutePlanningFragment()
            }

            is CancelRoutePlanning -> {
                popAllFragments()
            }

            is StartCruiseMode -> {
                addCruiseModeFragment()
            }

            is StopCruiseMode -> {
                popAllFragments()
            }

            is StartNavigation -> {
                addNavigationFragment()
            }

            is StopNavigation -> {
                popAllFragments()
            }
        }
    }
}
