package thiha.aung.boilerplate.photo.data.remote

import io.reactivex.Single
import retrofit2.http.GET
import thiha.aung.boilerplate.core.data.remote.RemoteDataProperties
import thiha.aung.boilerplate.photo.domain.entities.Photo

interface PhotoApiService {

    @GET(RemoteDataProperties.PICSUM_VERSION_2_LIST)
    fun getPhotos(): Single<List<Photo>>

}