package com.e.shaadi.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.e.shaadi.R
import com.e.shaadi.models.Result
import com.e.shaadi.network.getNetworkService
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class HomeActivity : AppCompatActivity(), onClickHandler {

    private lateinit var profileList: ArrayList<Result>
    private lateinit var adapter: MatchesListAdapter
    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val repository = Repository(getNetworkService())
        viewModel = ViewModelProvider(this, ViewModelFactory(application, repository))
            .get(HomeViewModel::class.java)
        initView()
        fetchData()
    }

    private fun initView() {
        matches_list.layoutManager = LinearLayoutManager(this)
        adapter = MatchesListAdapter().apply {
            setListener(this@HomeActivity)
        }
        matches_list.adapter = adapter
    }

    private fun fetchData() {
        viewModel.getMatches().observe(this, {
            it.data?.let { data ->
                profileList = data
                adapter.setData(data)
            }
        })
    }

    override fun onClickViewItem(data: Result, position: Int) {
        profileList[position] = data
        adapter.setData(profileList)
    }

}