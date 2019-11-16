package thiha.aung.boilerplate.photo.domain.interactors

import io.reactivex.Flowable
import thiha.aung.boilerplate.photo.domain.entities.Photo

interface GetPhotos {
    operator fun invoke(): Flowable<List<Photo>>
}