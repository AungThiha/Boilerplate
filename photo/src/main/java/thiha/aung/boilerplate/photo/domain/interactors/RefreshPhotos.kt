package thiha.aung.boilerplate.photo.domain.interactors

import io.reactivex.Completable
import thiha.aung.boilerplate.core.ext.with
import thiha.aung.boilerplate.core.scheduler.SchedulerProvider
import thiha.aung.boilerplate.photo.data.PhotoRepository

interface RefreshPhotos {
    operator fun invoke(): Completable
}

class RefreshPhotosImpl(
    private val schedulerProvider: SchedulerProvider,
    private val photoRepository: PhotoRepository
)  : RefreshPhotos {

    override fun invoke(): Completable {
        return photoRepository.run {
            getRemotePhotos()
                .with(schedulerProvider)
                .doOnSuccess(::savePhotos)
                .ignoreElement()
        }
    }

}