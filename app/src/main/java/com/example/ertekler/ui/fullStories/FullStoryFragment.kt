package com.example.ertekler.ui.fullStories

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavArgs
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.ertekler.R
import com.example.ertekler.data.StoriesDatabase
import com.example.ertekler.data.dao.StoriesDao
import kotlinx.android.synthetic.main.fragment_full_story.*

class FullStoryFragment: Fragment(R.layout.fragment_full_story), FullStoryView {

    private lateinit var dao: StoriesDao
    private lateinit var navController: NavController
    private val safeArgs: FullStoryFragmentArgs by navArgs()
    private lateinit var presenter : FullStoryPresenter
    private var storyId: Int = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        storyId = safeArgs.id
        dao = StoriesDatabase.getInstance(requireContext()).dao()
        presenter = FullStoryPresenter(this, dao)
        presenter.getContent(storyId)
    }

    override fun setContent(content: String) {
        tvStory.text = dao.getStoryById(storyId).content
    }
}