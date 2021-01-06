package com.example.ertekler.core

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

fun ViewGroup.inflate(resId: Int) : View =
    LayoutInflater.from(this.context).inflate(resId, this, false)

fun RecyclerView.addVerticalDivider(context: Context) {
    this.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
}

fun View.onClick(onClick: (view: View) -> Unit) {
    this.setOnClickListener(onClick)
}