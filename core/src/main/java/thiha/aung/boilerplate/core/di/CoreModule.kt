package thiha.aung.boilerplate.core.di

import org.koin.core.qualifier.named
import retrofit2.Converter
import retrofit2.converter.gson.GsonConverterFactory
import org.koin.dsl.module
import retrofit2.CallAdapter
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import thiha.aung.boilerplate.core.data.remote.DataSourceProperties
import thiha.aung.boilerplate.core.data.remote.OkHttpClientFactory
import thiha.aung.boilerplate.core.data.remote.RetrofitClientFactory

const val DI_BASE_URL = "DI_BASE_URL"
const val DI_GSON = "DI_GSON"
const val DI_RX_ADAPTER = "DI_RX_ADAPTER"

val coreModule = module {

    single(named(DI_BASE_URL)) { DataSourceProperties.BASE_URL }

    single { OkHttpClientFactory().build() }

    single<Converter.Factory>(named(DI_GSON)) {
        GsonConverterFactory.create()
    }

    single<CallAdapter.Factory>(named(DI_RX_ADAPTER)) {
        RxJava2CallAdapterFactory.create()
    }

    single {
        RetrofitClientFactory(
            url = get(named(DI_BASE_URL)),
            okHttpClient = get(),
            converterFactory = get(named(DI_GSON)),
            callAdapterFactory = get(named(DI_RX_ADAPTER))
        )
    }

}