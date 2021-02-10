package com.example.ertekler.ui.fullStories

import android.os.Bundle
import android.view.*
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
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
    private lateinit var presenter: FullStoryPresenter
    private var storyId: Int = 0


    override fun onCreateView(
        inflater: LayoutInflater,
        parent: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View = inflater.inflate(R.layout.fragment_full_story, parent, false)
        setHasOptionsMenu(true)
        return v
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_fullstory, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        storyId = safeArgs.id
        dao = StoriesDatabase.getInstance(requireContext()).dao()
        presenter = FullStoryPresenter(this, dao)
        presenter.getContent(storyId)
        svText.setOnScrollChangeListener { view, i, scrollY, i3, oldScrollY ->
            if (scrollY < oldScrollY) {
                val animation = AnimationUtils.loadAnimation(requireContext(), R.anim.anim_hide)
                bottomView.startAnimation(animation)
            } else {
                val animation = AnimationUtils.loadAnimation(requireContext(), R.anim.anim_show)
                bottomView.startAnimation(animation)
            }
        }
    }



    override fun setContent(content: String) {
        tvStory.text = dao.getStoryById(storyId).content
    }

}
