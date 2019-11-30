package hu.marton.schpangli.eggs.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import hu.marton.schpangli.R
import hu.marton.schpangli.model.Chicken
import kotlinx.android.synthetic.main.item_chicken.view.*

class ChickenAdapter(val listener: OnChickenClick): RecyclerView.Adapter<ChickenAdapter.ChickenViewHolder>() {

    private var itemList = mutableListOf<Chicken>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChickenViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_chicken, parent, false)
        return ChickenViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChickenViewHolder, position: Int) {
        holder.bind(itemList[position])

        holder.mView.setOnClickListener { view ->
            holder.item?.let {
                holder.bind(itemList[position])
                listener?.onChickenClick(it)
            }
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ChickenViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        var item: Chicken? = null

        fun bind(item: Chicken) = with(itemView) {
            this@ChickenViewHolder.item = item
            tv_name.text = "Chicken eggs: " + item.numberOfEggs?.toString()

        }
    }

    fun setList(itemList: List<Chicken>) {
        this.itemList.clear()
        this.itemList.addAll(itemList)
        notifyDataSetChanged()
    }

    interface OnChickenClick {
        fun onChickenClick(item: Chicken)
    }
}