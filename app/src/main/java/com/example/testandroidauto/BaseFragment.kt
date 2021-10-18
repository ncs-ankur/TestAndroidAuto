package com.example.testandroidauto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)
        rootView.findViewById<TextView>(R.id.title).setText(getTitle())
        rootView.findViewById<ImageView>(R.id.icon).setImageResource(getIcon())
        rootView.findViewById<View>(R.id.action).setOnClickListener {
            doAction()
        }
        return rootView
    }

    protected abstract fun doAction()
    protected abstract fun getTitle(): String
    protected abstract fun getIcon(): Int

}