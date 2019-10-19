package thiha.aung.boilerplate.core.data.remote

import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit

class RetrofitClientFactory(
    val url: String,
    val okHttpClient: OkHttpClient,
    val converterFactory: Converter.Factory, // typically gson
    val callAdapterFactory: CallAdapter.Factory // typically RxAdapter
) {
    inline fun <reified T> build(): T {
        return Retrofit.Builder()
            .baseUrl(url)
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .addCallAdapterFactory(callAdapterFactory)
            .build()
            .create(T::class.java)
    }
}