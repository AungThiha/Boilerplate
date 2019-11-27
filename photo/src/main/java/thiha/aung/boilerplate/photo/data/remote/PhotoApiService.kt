package thiha.aung.boilerplate.photo.data.remote

import io.reactivex.Single
import retrofit2.http.GET
import thiha.aung.boilerplate.core.data.remote.PHOTO_LIST

interface PhotoApiService {

    @GET(PHOTO_LIST)
    fun getPhotos(): Single<List<RemotePhoto>>

}