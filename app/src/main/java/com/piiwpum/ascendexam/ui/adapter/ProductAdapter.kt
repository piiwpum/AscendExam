package com.piiwpum.ascendexam.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.piiwpum.ascendexam.model.ProductModel
import com.piiwpum.ascendexam.R
import com.piiwpum.ascendexam.ui.ProductDetailActivity
import com.piiwpum.ascendexam.ui.bindview.ImageProductBindView

class ProductAdapter(val context: Context?, val mProductLs: MutableList<ProductModel>) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvIsNew: TextView = view.findViewById(R.id.tv_isnew)
        val imgProduct: ImageView = view.findViewById(R.id.iv_product)
        val tvProductName: TextView = view.findViewById(R.id.tv_product)
        val tvPrice: TextView = view.findViewById(R.id.tv_price)

        fun bind(position: Int) {
            val product = mProductLs.get(position)
            if (product.isNewProduct) {
                tvIsNew.visibility = View.VISIBLE
            } else {
                tvIsNew.visibility = View.GONE
            }
            ImageProductBindView.bindView(imgProduct, product.image)
            tvProductName.text = "${product.title}"
            tvPrice.text = "${product.price}"


        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.single_item_product, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = mProductLs.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
        holder.itemView.setOnClickListener {
            val intent = Intent(context, ProductDetailActivity::class.java)
            intent.putExtra("id", mProductLs.get(position).id)
            context?.startActivity(intent)
        }
    }
}