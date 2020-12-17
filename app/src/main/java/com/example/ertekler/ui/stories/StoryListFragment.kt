package com.example.ertekler.ui.stories

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.ertekler.R
import com.example.ertekler.core.addVerticalDivider
import com.example.ertekler.data.StoriesDatabase
import com.example.ertekler.data.model.Story
import kotlinx.android.synthetic.main.fragment_story_list.*

class StoryListFragment : Fragment(R.layout.fragment_story_list), StoryListView {

    companion object {
        const val STORY_TYPE = "storyType"
    }

    private val adapter = StoryListAdapter()
    private lateinit var presenter: StoryListPresenter



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        storyList.adapter = adapter
        storyList.addVerticalDivider(requireContext())
        val dao = StoriesDatabase.getInstance(requireContext()).dao()
        presenter = StoryListPresenter(this, dao)
        val storyType = requireArguments().getInt(STORY_TYPE)
        presenter.getStoriesByTypeId(storyType)
    }

    override fun setStories(stories: List<Story>) {
        adapter.models = stories
    }
}