package hu.marton.schpangli.model

import com.google.gson.annotations.SerializedName
import hu.marton.schpangli.network.model.Egg

class ResponseEggs {
	@SerializedName("eggs")
	val eggsList: ArrayList<Egg>? = null
}