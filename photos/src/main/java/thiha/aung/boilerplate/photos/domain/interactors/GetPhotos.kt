package thiha.aung.boilerplate.photos.domain.interactors

import io.reactivex.Flowable
import thiha.aung.boilerplate.photos.domain.entities.Photo

interface GetPhotos {
    operator fun invoke(): Flowable<List<Photo>>
}