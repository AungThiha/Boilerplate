package thiha.aung.boilerplate.photo.domain.interactors

import io.reactivex.Flowable
import thiha.aung.boilerplate.core.ext.with
import thiha.aung.boilerplate.core.network.NetworkProvider
import thiha.aung.boilerplate.core.scheduler.SchedulerProvider
import thiha.aung.boilerplate.photo.data.PhotoRepository
import thiha.aung.boilerplate.photo.domain.entities.Photo

interface GetPhotos {
    operator fun invoke(): Flowable<List<Photo>>
}

class GetPhotosImpl(
    private val networkProvider: NetworkProvider,
    private val schedulerProvider: SchedulerProvider,
    private val photoRepository: PhotoRepository
) : GetPhotos {

    override fun invoke(): Flowable<List<Photo>> {
        return photoRepository.run {
            getLocalPhotos()
                .filter { it.isNotEmpty() }
                .mergeWith(
                    networkProvider.isInternetOn()
                        .andThen(getRemotePhotos())
                        .doOnSuccess(::savePhotos)
                        .subscribeOn(schedulerProvider.io())
                )
                .with(schedulerProvider)
        }
    }

}