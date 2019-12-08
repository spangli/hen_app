package hu.marton.schpangli.eggs

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import hu.marton.schpangli.model.Hen
import hu.marton.schpangli.model.ResponseEggs
import hu.marton.schpangli.model.ResponseHen
import hu.marton.schpangli.network.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient


class EggsPresenter(val screen: EggsScreen, val context: Context) {

	fun getHens() {
		val hensJSON = "{\"hens\":[{\"id\":\"1\"},{\"id\":\"2\"},{\"id\":\"3\"},{\"id\":\"4\"},{\"id\":\"5\"},{\"id\":\"6\"},{\"id\":\"7\"},{\"id\":\"8\"}]}"

		val henObj = Gson().fromJson(hensJSON, ResponseHen::class.java)

		screen.loadHens(henObj.henList!!)


		ApiService.create(context).getHens()
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe({ response ->
					if (response.isSuccessful) {
						response.body()?.let {
							screen.loadHens(it.henList!!)
						}
					} else {
						screen?.showMessage(response.message())
					}
				}, { error ->
					error.printStackTrace()
				})
	}
}