package hu.marton.schpangli.network

import android.content.Context
import hu.marton.schpangli.model.Hen
import hu.marton.schpangli.model.ResponseHen
import io.reactivex.Observable
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST
import java.util.concurrent.TimeUnit

interface ApiService {

    @POST("getHenAPI.php")
    fun getHens(): Observable<Response<ResponseHen>>

    companion object Factory {

        private fun getBaseUrl(): String {
            return "http://77.234.64.61/"
        }

        fun create(context: Context): ApiService {
            val header = Interceptor { chain ->
                val request = chain.request()?.newBuilder()
                    ?.build()
                chain.proceed(request!!)
            }

            val client = OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(header)
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()

            val retrofit = Retrofit.Builder()
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(getBaseUrl())
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}