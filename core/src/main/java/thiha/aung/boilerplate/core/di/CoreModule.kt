package thiha.aung.boilerplate.core.di

import org.koin.core.qualifier.named
import retrofit2.Converter
import retrofit2.converter.gson.GsonConverterFactory
import org.koin.dsl.module
import retrofit2.CallAdapter
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import thiha.aung.boilerplate.core.config.PICSUM_V2_API
import thiha.aung.boilerplate.core.config.SECONDARY_API
import thiha.aung.boilerplate.core.data.remote.OkHttpClientFactory
import thiha.aung.boilerplate.core.data.remote.RetrofitClientFactory
import thiha.aung.boilerplate.core.network.AppNetworkProvider
import thiha.aung.boilerplate.core.network.NetworkProvider
import thiha.aung.boilerplate.core.scheduler.AppSchedulerProvider
import thiha.aung.boilerplate.core.scheduler.SchedulerProvider

const val DI_GSON = "DI_GSON"
const val DI_RX_ADAPTER = "DI_RX_ADAPTER"
const val DI_PICSUM_V2_API_FACTORY = "DI_PICSUM_API_FACTORY"
const val DI_SECONDARY_API_FACTORY = "DI_SECONDARY_API_FACTORY"

val networkModule = module {

    single { OkHttpClientFactory().build() }

    single<Converter.Factory>(named(DI_GSON)) {
        GsonConverterFactory.create()
    }

    single<CallAdapter.Factory>(named(DI_RX_ADAPTER)) {
        RxJava2CallAdapterFactory.create()
    }

    single(named(DI_PICSUM_V2_API_FACTORY)) {
        RetrofitClientFactory(
            url = PICSUM_V2_API,
            okHttpClient = get(),
            converterFactory = get(named(DI_GSON)),
            callAdapterFactory = get(named(DI_RX_ADAPTER))
        )
    }

    single(named(DI_SECONDARY_API_FACTORY)) {
        RetrofitClientFactory(
            url = SECONDARY_API,
            okHttpClient = get(),
            converterFactory = get(named(DI_GSON)),
            callAdapterFactory = get(named(DI_RX_ADAPTER))
        )
    }

    single<NetworkProvider> { AppNetworkProvider(get()) }
}

val schedulerModule = module {
    single<SchedulerProvider> { AppSchedulerProvider() }
}

val coreModule = listOf(networkModule, schedulerModule)
