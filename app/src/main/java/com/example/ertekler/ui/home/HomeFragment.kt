package com.example.ertekler.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.ertekler.R
import com.example.ertekler.data.StoriesDatabase
import com.example.ertekler.data.dao.StoriesDao
import com.example.ertekler.data.model.StoryType
import com.example.ertekler.ui.stories.StoryListFragment
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val myAdapter = HomeListAdapter()
    private lateinit var dao: StoriesDao
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvHome.adapter=myAdapter
        navController = Navigation.findNavController(view)
        dao = StoriesDatabase.getInstance(requireContext()).dao()
        myAdapter.setOnItemCLickListener(onClick)
        setData()
    }

    private fun setData() {
        myAdapter.models = dao.getAllTypes()
    }

    private val onClick = { storyType: StoryType ->
        val action = HomeFragmentDirections.actionNavHomeToStoryListFragment(storyType.id)
        navController.navigate(action)
    }
}