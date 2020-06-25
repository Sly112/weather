package pl.slyberry.common

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

fun View.layoutInflater() = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

fun LayoutInflater.inflateNoAttach(resId: Int, container: ViewGroup?) = inflate(resId, container, false)

val <T> T.exhaustive: T
  get() = this

fun View.makeVisible() {
  visibility = View.VISIBLE
}

fun View.makeGone() {
  visibility = View.GONE
}
