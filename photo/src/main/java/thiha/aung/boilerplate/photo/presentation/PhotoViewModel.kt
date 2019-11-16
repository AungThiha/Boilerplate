package thiha.aung.boilerplate.photo.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import thiha.aung.boilerplate.core.domain.entities.ErrorResponse
import thiha.aung.boilerplate.core.lifecycle.SingleLiveEvent
import thiha.aung.boilerplate.photo.domain.entities.Photo
import thiha.aung.boilerplate.photo.domain.interactors.PhotoInteractors

class PhotoViewModel(
    private val photosInteractors: PhotoInteractors
) : ViewModel() {

    private val disposable = CompositeDisposable()

    val showProgress = MutableLiveData<Boolean>()
    val showNetworkError = MutableLiveData<Boolean>()
    val showErrorMessage = MutableLiveData<Boolean>()
    val photos = MutableLiveData<List<Photo>>()
    val hidePullToRefreshLoading = SingleLiveEvent<Unit>()

    fun subscribePhotos() {
        showProgress.value = true
        photosInteractors.getPhotos()
            .subscribeBy(
                onNext = { result ->
                    showProgress.value = false
                    photos.value = result
                },
                onError = { error ->
                    if(error is ErrorResponse) {
                        when(error) {
                            ErrorResponse.NoInternetConnection -> {
                                showProgress.value = false
                                showNetworkError.value = true
                            } else -> {
                                showProgress.value = false
                                showErrorMessage.value = true
                            }
                        }
                    }
                }
            ).addTo(disposable)
    }

    fun refreshPhotos() {
        showProgress.value = true
        photosInteractors.refreshPhotos()
            .subscribeBy(
                onComplete = {
                    showProgress.value = false
                    hideLoading()
                },
                onError = { error ->
                    if(error is ErrorResponse) {
                        when(error) {
                            ErrorResponse.NoInternetConnection -> {
                                showProgress.value = false
                                showNetworkError.value = true
                            } else -> {
                                showProgress.value = false
                                showErrorMessage.value = true
                            }
                        }
                    }
                }
            ).addTo(disposable)
    }

    private fun hideLoading() {
        showProgress.value = false
        hidePullToRefreshLoading.call()
    }
}