package thiha.aung.boilerplate.photo.presentation

import androidx.lifecycle.ViewModel
import thiha.aung.boilerplate.photo.domain.interactors.PhotoInteractors

class PhotosViewModel (val interactors: PhotoInteractors): ViewModel() {

    fun fetchPhotos(){
        interactors.getPhotos()
    }

    fun refreshPhotos() {
        interactors.refreshPhotos()
    }
}