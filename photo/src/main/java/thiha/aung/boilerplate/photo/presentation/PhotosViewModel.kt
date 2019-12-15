package thiha.aung.boilerplate.photo.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import thiha.aung.boilerplate.core.domain.entities.ErrorResponse
import thiha.aung.boilerplate.photo.domain.entities.Photo
import thiha.aung.boilerplate.photo.domain.interactors.PhotoInteractors

class PhotosViewModel (val interactors: PhotoInteractors): ViewModel() {

    private val disposables = CompositeDisposable()

    private var _photos = MutableLiveData<List<Photo>>()
    val photos: LiveData<List<Photo>>
        get() = _photos

    fun fetchPhotos(){
        interactors.getPhotos()
            .subscribe({ photos ->
                _photos.value = photos
            }, { error ->
                if (error is Throwable) {
                    if (error is ErrorResponse.NoInternetConnection) {

                    } else {

                    }
                }
            }).addTo(disposables)

    }

    fun refreshPhotos() {
        interactors.refreshPhotos()

    }
}