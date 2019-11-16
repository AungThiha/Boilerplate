package thiha.aung.boilerplate.photo.domain.interactors

import io.reactivex.Completable
import thiha.aung.boilerplate.core.ext.with
import thiha.aung.boilerplate.core.network.NetworkProvider
import thiha.aung.boilerplate.core.scheduler.SchedulerProvider
import thiha.aung.boilerplate.photo.data.PhotoRepository

interface RefreshPhotos {
    operator fun invoke(): Completable
}

class RefreshPhotosImpl(
    private val networkProvider: NetworkProvider,
    private val schedulerProvider: SchedulerProvider,
    private val photoRepository: PhotoRepository
)  : RefreshPhotos {

    override fun invoke(): Completable {
        return photoRepository.run {
            networkProvider.isInternetOn()
                .andThen(getRemotePhotos())
                .doOnSuccess(::savePhotos)
                .with(schedulerProvider)
                .ignoreElement()
        }
    }

}