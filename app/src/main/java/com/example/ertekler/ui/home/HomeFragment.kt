package com.example.ertekler.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.ertekler.R
import com.example.ertekler.data.StoriesDatabase
import com.example.ertekler.data.dao.StoriesDao
import com.example.ertekler.ui.gallery.GalleryViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {


    private val myAdapter = HomeListAdapter()
    private lateinit var dao: StoriesDao

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvHome.adapter=myAdapter
        rvHome.addItemDecoration(DividerItemDecoration(requireContext(),DividerItemDecoration.VERTICAL))
        dao = StoriesDatabase.getInstance(requireContext()).dao()
        setData()
    }
    private fun setData() {
        myAdapter.models = dao.getAllTypes()
    }
}