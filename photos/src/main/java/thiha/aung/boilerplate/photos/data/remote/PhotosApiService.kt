package thiha.aung.boilerplate.photos.data.remote

import io.reactivex.Single
import retrofit2.http.GET
import thiha.aung.boilerplate.core.data.remote.RemoteDataProperties
import thiha.aung.boilerplate.photos.domain.entities.Photo

interface PhotosApiService {

    @GET(RemoteDataProperties.PICSUM_VERSION_2_LIST)
    fun getPhotos(): Single<List<Photo>>

}