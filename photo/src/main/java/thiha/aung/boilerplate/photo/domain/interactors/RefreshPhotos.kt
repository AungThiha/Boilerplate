package thiha.aung.boilerplate.photo.domain.interactors

import io.reactivex.Completable

interface RefreshPhotos {
    operator fun invoke(): Completable
}