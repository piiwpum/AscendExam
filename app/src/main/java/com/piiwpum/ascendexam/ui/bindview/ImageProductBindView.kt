package com.piiwpum.ascendexam.ui.bindview

import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.piiwpum.ascendexam.R
object ImageProductBindView {
    open fun bindView(imageView: ImageView, path: String) {
        Picasso.get().load(path)
            .placeholder(R.drawable.ic_baseline_image_24)
            .error(R.drawable.ic_baseline_image_24)
            .into(imageView)
    }
}