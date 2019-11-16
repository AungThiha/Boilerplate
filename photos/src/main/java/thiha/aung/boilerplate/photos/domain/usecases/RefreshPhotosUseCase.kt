package thiha.aung.boilerplate.photos.domain.usecases

import io.reactivex.Completable

interface RefreshPhotosUseCase {
    fun execute(): Completable
}