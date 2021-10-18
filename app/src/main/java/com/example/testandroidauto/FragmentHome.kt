package com.example.testandroidauto

import android.os.Bundle
import android.widget.Toast
import com.example.sharedmodule.RxEvent
import com.example.sharedmodule.ShowHomeScreen
import com.example.sharedmodule.ShowRoutePlanning

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FragmentHome : BaseFragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun doAction() {
        RxEvent.postEvent(ShowRoutePlanning())
    }

    override fun getTitle(): String {
        return "HOME FRAGMENT"
    }

    override fun getIcon(): Int {
        return R.drawable.ic_vc_home
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentHome().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}