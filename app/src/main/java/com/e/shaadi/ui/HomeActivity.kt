package com.e.shaadi.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
        observeLiveData()
    }

    private fun initView() {
        matches_list.layoutManager = LinearLayoutManager(this)
        adapter = MatchesListAdapter().apply {
            setListener(this@HomeActivity)
        }
        matches_list.adapter = adapter
    }

    private fun observeLiveData() {
        viewModel.profiles.observe(this, {
            if (it.data.isNullOrEmpty()) {
                viewModel.getNewMatches()
            } else {
                val data = it.data
                profileList = data
                adapter.setData(data)
            }
        })
        viewModel.fetchMatchesFromDb()
    }

    override fun onClickViewItem(data: Result, position: Int) {
        profileList[position] = data
        adapter.setData(profileList)
        viewModel.updateProfile(data)
    }

}