package thiha.aung.boilerplate.photos.data.remote

import io.reactivex.Single
import retrofit2.http.GET
import thiha.aung.boilerplate.core.config.DataSourceProperties
import thiha.aung.boilerplate.photos.data.entities.Photo

interface PhotosDataSource {

    @GET(DataSourceProperties.PICSUM_VERSION_2_LIST)
    fun getPhotos(): Single<List<Photo>>

}