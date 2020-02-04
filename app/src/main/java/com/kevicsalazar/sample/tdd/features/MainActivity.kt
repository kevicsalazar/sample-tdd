package com.kevicsalazar.sample.tdd.features

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kevicsalazar.sample.tdd.R
import com.kevicsalazar.sample.tdd.features.list.UserListFragment

class MainActivity : AppCompatActivity() {

    private val userListFragment by lazy { UserListFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startFragments()
    }

    private fun startFragments() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, userListFragment)
            .commit()
    }

}
