package thiha.aung.boilerplate.photos.domain.interactors

import io.reactivex.Completable

interface RefreshPhotos {
    operator fun invoke(): Completable
}