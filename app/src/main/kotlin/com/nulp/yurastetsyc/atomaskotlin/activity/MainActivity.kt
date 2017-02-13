package com.nulp.yurastetsyc.atomaskotlin.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.nulp.yurastetsyc.atomaskotlin.R
import com.nulp.yurastetsyc.atomaskotlin.adapter.Adapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        val list: RecyclerView = this.recyclerView
        list.layoutManager = LinearLayoutManager(this)

        list.adapter = Adapter()
    }
}
