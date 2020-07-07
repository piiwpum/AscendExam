package com.piiwpum.ascendexam.ui

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.piiwpum.ascendexam.R
import com.piiwpum.ascendexam.model.ProductModel
import com.piiwpum.ascendexam.ui.bindview.ImageProductBindView
import com.piiwpum.ascendexam.viewmodel.ProductDetailViewModel
import kotlinx.android.synthetic.main.product_detail_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class ProductDetailFragment : Fragment() {
    companion object {
        fun newInstance() = ProductDetailFragment()
    }
    private val viewModel: ProductDetailViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.product_detail_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        viewModel.fetchProductDetail(activity?.intent?.getIntExtra("id", 0))
    }

    private fun initViewModel() {
        viewModel.product.observe(viewLifecycleOwner, product)
        viewModel.isLoading.observe(viewLifecycleOwner, isLoading)
        viewModel.isError.observe(viewLifecycleOwner, isError)
    }


    private val product = Observer<ProductModel> {
        lv_content?.visibility = View.VISIBLE
        if (it.isNewProduct) {
            tv_isnew?.visibility = View.VISIBLE
        } else {
            tv_isnew?.visibility = View.GONE
        }
        ImageProductBindView.bindView(img_product, it.image)
        tv_product?.text = "${it.title}"
        tv_price?.text = "${it.price}"
        tv_detail?.text = "${it.content}"

    }

    private val isLoading = Observer<Boolean> {
        if (it) {
            lv_loading?.visibility = View.VISIBLE
        } else {
            lv_loading?.visibility = View.GONE
        }
    }

    private val isError = Observer<Boolean> {
        if (it) {
            lv_blank?.visibility = View.VISIBLE
            lv_content.visibility = View.GONE
            lv_blank?.text = "something is wrong"
        } else {
            lv_blank?.visibility = View.GONE

        }
    }

}