package com.example.testandroidauto

import android.os.Bundle
import android.widget.Toast

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

    override fun doAction() {
        Toast.makeText(requireContext(), "Action performed", Toast.LENGTH_SHORT).show()
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