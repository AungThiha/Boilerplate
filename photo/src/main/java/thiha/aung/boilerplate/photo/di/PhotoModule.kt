package thiha.aung.boilerplate.photo.di

import org.koin.core.qualifier.named
import org.koin.dsl.module
import thiha.aung.boilerplate.core.data.remote.RetrofitClientFactory
import thiha.aung.boilerplate.core.di.DI_PICSUM_API_FACTORY
import thiha.aung.boilerplate.photo.data.remote.PhotoApiService

val remoteDataSourceModule = module {

    single<PhotoApiService> {
        get<RetrofitClientFactory>(named(DI_PICSUM_API_FACTORY)).build()
    }

}
