package thiha.aung.boilerplate.photos.domain.usecases

import io.reactivex.Flowable
import thiha.aung.boilerplate.photos.domain.entities.Photo

interface GetPhotosUseCase {
    fun execute(): Flowable<List<Photo>>
}