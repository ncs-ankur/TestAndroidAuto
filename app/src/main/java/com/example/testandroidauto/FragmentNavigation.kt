package com.example.testandroidauto

import android.os.Bundle
import android.widget.Toast
import com.example.sharedmodule.RxEvent
import com.example.sharedmodule.StartNavigation
import com.example.sharedmodule.StopNavigation

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FragmentNavigation : BaseFragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun getActionTitle1(): String? {
        return "Stop Navigation"
    }

    override fun doAction1() {
        RxEvent.postEvent(StopNavigation())
    }

    override fun getTitle(): String {
        return "NAVIGATION"
    }

    override fun getIcon(): Int {
        return R.drawable.ic_vc_navigation
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentNavigation().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}