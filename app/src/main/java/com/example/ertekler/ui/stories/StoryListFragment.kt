package com.example.ertekler.ui.stories

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.ertekler.R
import com.example.ertekler.core.addVerticalDivider
import com.example.ertekler.data.StoriesDatabase
import com.example.ertekler.data.model.Story
import kotlinx.android.synthetic.main.fragment_story_list.*

class StoryListFragment : Fragment(R.layout.fragment_story_list), StoryListView {

    private val adapter = StoryListAdapter()
    private val safeArgs: StoryListFragmentArgs by navArgs()
    private lateinit var presenter: StoryListPresenter
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        storyList.adapter = adapter
        storyList.addVerticalDivider(requireContext())
        val dao = StoriesDatabase.getInstance(requireContext()).dao()
        presenter = StoryListPresenter(this, dao)
        val storyType = safeArgs.storyType
        presenter.getStoriesByTypeId(storyType)
    }

    override fun setStories(stories: List<Story>) {
        adapter.models = stories
    }
}