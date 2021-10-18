package com.example.testandroidauto

import android.os.Bundle
import android.widget.Toast
import com.example.sharedmodule.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FragmentRoutePlanning : BaseFragment() {
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
        return "Start Navigation"
    }

    override fun getActionTitle2(): String? {
        return "Cancel"
    }

    override fun doAction1() {
        RxEvent.postEvent(StartNavigation())
    }

    override fun doAction2() {
        RxEvent.postEvent(CancelRoutePlanning())
    }

    override fun getTitle(): String {
        return "ROUTE PLANNING"
    }

    override fun getIcon(): Int {
        return R.drawable.ic_vc_route
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentRoutePlanning().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}