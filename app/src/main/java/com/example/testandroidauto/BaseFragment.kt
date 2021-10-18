package com.example.testandroidauto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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

        val action1 = rootView.findViewById<Button>(R.id.action1)
        if (getActionTitle1() != null) {
            action1.visibility = View.VISIBLE
            action1.setText(getActionTitle1())
            action1.setOnClickListener {
                doAction1()
            }
        } else {
            action1.visibility = View.GONE
        }

        val action2 = rootView.findViewById<Button>(R.id.action2)
        if (getActionTitle2() != null) {
            action2.visibility = View.VISIBLE
            action2.setText(getActionTitle2())
            action2.setOnClickListener {
                doAction2()
            }
        } else {
            action2.visibility = View.GONE
        }

        return rootView
    }

    protected abstract fun getTitle(): String
    protected abstract fun getIcon(): Int

    protected open fun doAction1() {}
    protected open fun doAction2() {}

    protected open fun getActionTitle1(): String? {
        return null
    }

    protected open fun getActionTitle2(): String? {
        return null
    }

}