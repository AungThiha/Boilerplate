package thiha.aung.boilerplate.photos.di

import org.koin.core.qualifier.named
import org.koin.dsl.module
import thiha.aung.boilerplate.core.data.remote.RetrofitClientFactory
import thiha.aung.boilerplate.core.di.DI_PICSUM_API_FACTORY
import thiha.aung.boilerplate.photos.data.remote.PhotosApiService

val remoteDataSourceModule = module {

    single<PhotosApiService> {
        get<RetrofitClientFactory>(named(DI_PICSUM_API_FACTORY)).build()
    }

}
