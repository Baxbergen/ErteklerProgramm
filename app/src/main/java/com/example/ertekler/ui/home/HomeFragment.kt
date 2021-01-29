package com.example.ertekler.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.ertekler.R
import com.example.ertekler.data.StoriesDatabase
import com.example.ertekler.data.dao.StoriesDao
import com.example.ertekler.data.model.Story
import com.example.ertekler.data.model.StoryType
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home), HomeListView {

    private lateinit var dao: StoriesDao
    private val myAdapter = HomeListAdapter()
    private lateinit var presenter: HomeListPresenter
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvHome.adapter=myAdapter
        navController = Navigation.findNavController(view)
        myAdapter.setOnItemCLickListener(onClick)
        dao = StoriesDatabase.getInstance(requireContext()).dao()
        presenter = HomeListPresenter(this, dao)
        presenter.getData()
    }

    private val onClick = { storyType: StoryType ->
        val action = HomeFragmentDirections.actionNavHomeToStoryListFragment(storyType.id)
        navController.navigate(action)
    }

    override fun setData(storyType: List<StoryType>) {
        myAdapter.models = storyType
    }
}