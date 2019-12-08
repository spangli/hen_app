package hu.marton.schpangli.henDetails

import hu.marton.schpangli.network.model.Egg

interface HenDetailsScreen {
	fun loadHenDetails(eggsList: ArrayList<Egg>?, sumEgg: Int?)
	fun showMessage(message: String)
}