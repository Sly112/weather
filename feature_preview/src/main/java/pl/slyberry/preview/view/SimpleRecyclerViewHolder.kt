package pl.slyberry.preview.view

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import pl.slyberry.common.inflateNoAttach
import pl.slyberry.common.layoutInflater

abstract class SimpleRecyclerViewHolder(
  @LayoutRes resId: Int, parent: ViewGroup
) : RecyclerView.ViewHolder(parent.layoutInflater().inflateNoAttach(resId, parent))
