package thiha.aung.boilerplate.core.network

import io.reactivex.Completable

interface NetworkProvider {
    fun isInternetOn(): Completable
}