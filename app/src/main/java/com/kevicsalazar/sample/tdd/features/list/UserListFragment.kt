package com.kevicsalazar.sample.tdd.features.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kevicsalazar.sample.tdd.R
import com.kevicsalazar.sample.tdd.features.registry.UserRegistryFragment
import kotlinx.android.synthetic.main.fragment_user_list.*


class UserListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initEvents()
    }

    private fun initEvents() {
        btnAdd?.setOnClickListener {
            goToUserRegistry()
        }
    }

    private fun goToUserRegistry() {
        val dialogFragment = UserRegistryFragment()
        dialogFragment.show(childFragmentManager, dialogFragment.javaClass.name)
    }

}