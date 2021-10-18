package com.example.testandroidauto

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.sharedmodule.*
import com.example.sharedmodule.RxEvent.postEvent


class MainActivity : BaseActivity() {

    lateinit var adapter: StackAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initBackStack()

        adapter = StackAdapter(ArrayList())
        findViewById<RecyclerView>(R.id.list_stack).adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        postEvent(ShowHomeScreen())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.search) {
            postEvent(ShowSearch())
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initBackStack() {
        supportFragmentManager.addOnBackStackChangedListener {
            val stackItems = ArrayList<String>()
            for (fragment in supportFragmentManager.fragments) {
                stackItems.add(getFragmentTitle(fragment))
            }
            adapter.updateItems(stackItems)
        }
    }

    protected fun getFragmentTitle(fragment: Fragment): String {
        if (fragment is BaseFragment) {
            return fragment.getTitle()
        } else {
            return fragment.javaClass.name
        }
    }

    private fun popAllFragments() {
        for (i in 0 until supportFragmentManager.getBackStackEntryCount()) {
            supportFragmentManager.popBackStack()
        }
    }

    private fun popTopFragments() {
        for (i in 0 until supportFragmentManager.getBackStackEntryCount()) {
            supportFragmentManager.popBackStack()
            break
        }
    }

    private fun addHomeFragment() {
        popAllFragments()
        replaceFragment(FragmentHome.newInstance("", ""))
    }

    private fun addCruiseModeFragment() {
        addFragment(FragmentCruiseMode.newInstance("", ""))
    }

    private fun addRoutePlanningFragment() {
        addFragment(FragmentRoutePlanning.newInstance("", ""))
    }

    private fun addNavigationFragment() {
        addFragment(FragmentNavigation.newInstance("", ""))
    }

    private fun addSearchFragment() {
        addFragment(FragmentSearch.newInstance("", ""))
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .addToBackStack(fragment.javaClass.name)
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
                popTopFragments()
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