package hu.marton.schpangli.eggs

import android.content.Context
import hu.marton.schpangli.model.Hen
import hu.marton.schpangli.network.ApiService
import hu.marton.schpangli.util.Consts
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.*
import java.io.IOException
import okhttp3.RequestBody



class EggsPresenter(val screen: EggsScreen, val context: Context) {

	private val client = OkHttpClient()

	fun getHens() {
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

//	fun getHens() {
//		val reqbody = RequestBody.create(null, ByteArray(0))
//		val request = Request.Builder()
//				.method("POST",reqbody)
//				.url(Consts.BASE_URL + "getHenAPI.php")
//				.build()
//
//		client.newCall(request).enqueue(object : Callback {
//			override fun onFailure(call: Call, e: IOException) {
//				e.printStackTrace()
//			}
//			override fun onResponse(call: Call, response: Response) {
//				if (response.isSuccessful) {
//					screen.loadHens(response.body() as ArrayList<Hen>)
//				} else {
//					screen.showMessage(response.message())
//				}
//			}
//		})
//	}
}