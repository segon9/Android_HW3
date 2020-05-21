package com.example.android_hw3

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class itemDecoration(private val verti : Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.bottom += verti

        if(parent.getChildAdapterPosition(view) == 0) {
//            outRect.top += verti
        }
    }
}