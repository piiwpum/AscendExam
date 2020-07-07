package com.piiwpum.ascendexam.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.piiwpum.ascendexam.R
import com.piiwpum.ascendexam.data.NetworkClient
import com.piiwpum.ascendexam.model.ProductModel
import com.piiwpum.ascendexam.repo.ProductRepo
import com.piiwpum.ascendexam.ui.adapter.ProductAdapter
import com.piiwpum.ascendexam.viewmodel.ProductListViewModel
import kotlinx.android.synthetic.main.product_list_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductListFragment : Fragment() {
    companion object {
        fun newInstance() = ProductListFragment()
    }

    private  val productViewModel: ProductListViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.product_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
    }

    private fun initViewModel() {
        productViewModel.isLoading.observe(viewLifecycleOwner, isLoading)
        productViewModel.productLs.observe(viewLifecycleOwner, productLs)
        productViewModel.isError.observe(viewLifecycleOwner, isError)
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
            lv_blank?.text = "something is wrong"
        } else {
            lv_blank?.visibility = View.GONE

        }
    }

    private val productLs = Observer<MutableList<ProductModel>> {
        if (it.isEmpty()) {
            lv_blank.visibility = View.VISIBLE
            lv_blank?.text = "no data"
            rv_product?.visibility = View.GONE
        } else {
            lv_blank?.visibility = View.GONE
            rv_product?.visibility = View.VISIBLE
            setProductAdapter(it)

        }
    }

    private fun setProductAdapter(it: MutableList<ProductModel>) {
        rv_product?.layoutManager = GridLayoutManager(context, 2)
        rv_product?.adapter = ProductAdapter(context, it)

    }

}