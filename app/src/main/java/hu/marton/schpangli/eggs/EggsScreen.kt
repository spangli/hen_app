package hu.marton.schpangli.eggs

import hu.marton.schpangli.model.Hen


interface EggsScreen {
	fun loadHens(list: ArrayList<Hen>)
	fun showMessage(message: String)
}