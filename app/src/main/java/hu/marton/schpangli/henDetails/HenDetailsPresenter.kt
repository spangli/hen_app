package hu.marton.schpangli.henDetails

import android.content.Context
import com.google.gson.Gson
import hu.marton.schpangli.model.ResponseEggs
import hu.marton.schpangli.network.ApiService
import hu.marton.schpangli.network.model.Egg
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HenDetailsPresenter(private val screen: HenDetailsScreen, val context: Context) {

	fun getHenDetails(chickenId: String) {

		val hensJSON = "{\"eggs\":[{\"date\":\"2019-11-29\",\"chickenid\":\"2\"}, {\"date\":\"2019-11-01\",\"chickenid\":\"2\"}, {\"date\":\"2019-11-02\",\"chickenid\":\"2\"}, {\"date\":\"2019-11-29\",\"chickenid\":\"4\"},{\"date\":\"2019-11-29\",\"chickenid\":\"1\"},{\"date\":\"2019-11-29\",\"chickenid\":\"6\"},{\"date\":\"2019-11-30\",\"chickenid\":\"3\"},{\"date\":\"2019-11-30\",\"chickenid\":\"2\"},{\"date\":\"2019-11-30\",\"chickenid\":\"5\"},{\"date\":\"2019-11-30\",\"chickenid\":\"8\"},{\"date\":\"2019-11-30\",\"chickenid\":\"7\"}]}"
		val henObj = Gson().fromJson(hensJSON, ResponseEggs::class.java)
		screen.loadHenDetails(getEggsByChicken(chickenId, henObj.eggsList), getEggsByChicken(chickenId, henObj.eggsList).size)


		ApiService.create(context).getEggs()
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe({ response ->
					if (response.isSuccessful) {
						response.body()?.let {
							screen.loadHenDetails(getEggsByChicken(chickenId, it.eggsList),getEggsByChicken(chickenId, it.eggsList).size)
						}
					} else {
						screen.showMessage(response.message())
					}
				}, { error ->
					error.printStackTrace()
				})
	}

	private fun getEggsByChicken(chickenId: String, eggList: ArrayList<Egg>?): ArrayList<Egg> {
		eggList?.let {
			return ArrayList(eggList.filter { it.chickenId == chickenId })
		} ?: run {
			return arrayListOf()
		}
	}
}