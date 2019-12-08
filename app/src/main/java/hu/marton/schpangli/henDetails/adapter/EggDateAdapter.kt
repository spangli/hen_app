package hu.marton.schpangli.henDetails.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hu.marton.schpangli.R
import hu.marton.schpangli.network.model.Egg
import kotlinx.android.synthetic.main.item_eggs.view.*

class EggDateAdapter: RecyclerView.Adapter<EggDateAdapter.EggDateViewHolder>() {

	private var itemList = mutableListOf<Egg>()

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EggDateViewHolder {
		val view = LayoutInflater.from(parent.context)
				.inflate(R.layout.item_eggs, parent, false)
		return EggDateViewHolder(view)
	}

	override fun onBindViewHolder(holder: EggDateViewHolder, position: Int) {
		holder.bind(itemList[position])
	}

	override fun getItemCount(): Int {
		return itemList.size
	}

	inner class EggDateViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
		var item: Egg? = null

		fun bind(item: Egg) = with(itemView) {
			this@EggDateViewHolder.item = item
			tv_date.text = item.date

		}
	}

	fun setList(itemList: List<Egg>) {
		this.itemList.clear()
		this.itemList.addAll(itemList)
		notifyDataSetChanged()
	}
}