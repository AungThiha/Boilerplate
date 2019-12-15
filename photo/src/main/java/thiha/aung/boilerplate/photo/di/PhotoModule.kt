package thiha.aung.boilerplate.photo.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import thiha.aung.boilerplate.core.data.remote.RetrofitClientFactory
import thiha.aung.boilerplate.core.di.DI_PICSUM_V2_API_FACTORY
import thiha.aung.boilerplate.photo.data.PhotoRepository
import thiha.aung.boilerplate.photo.data.PhotoRepositoryImpl
import thiha.aung.boilerplate.photo.data.local.LocalPhotoMapper
import thiha.aung.boilerplate.photo.data.remote.PhotoApiService
import thiha.aung.boilerplate.photo.data.remote.RemotePhotoMapper
import thiha.aung.boilerplate.photo.domain.interactors.*
import thiha.aung.boilerplate.photo.presentation.PhotosViewModel

val dataModule = module {

    single<PhotoApiService> {
        get<RetrofitClientFactory>(named(DI_PICSUM_V2_API_FACTORY)).build()
    }

    factory { RemotePhotoMapper() }

    factory { LocalPhotoMapper() }

    factory<PhotoRepository> { PhotoRepositoryImpl(get(), get(), get(), get()) }

}

val domainModule = module {

    factory<GetPhotos> { GetPhotosImpl(get(), get(), get()) }

    factory<RefreshPhotos> { RefreshPhotosImpl(get(), get(), get()) }

    factory<PhotoInteractors> { PhotoInteractors(get(), get()) }

}

val presentationModule = module {

    viewModel { PhotosViewModel(interactors = get()) }

}

val photoModule = listOf(dataModule, domainModule, presentationModule)