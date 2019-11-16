package thiha.aung.boilerplate.photo.data

import io.reactivex.Flowable
import io.reactivex.Single
import thiha.aung.boilerplate.photo.data.local.LocalPhotoMapper
import thiha.aung.boilerplate.photo.data.local.PhotoDao
import thiha.aung.boilerplate.photo.data.remote.PhotoApiService
import thiha.aung.boilerplate.photo.data.remote.RemotePhotoMapper
import thiha.aung.boilerplate.photo.domain.entities.Photo

interface PhotoRepository {
    fun getLocalPhotos(): Flowable<List<Photo>>
    fun getRemotePhotos(): Single<List<Photo>>
    fun savePhotos(photos: List<Photo>)
}

class PhotoRepositoryImpl(
    private val photoDao: PhotoDao,
    private val localPhotoMapper: LocalPhotoMapper,
    private val photoApiService: PhotoApiService,
    private val remotePhotoMapper: RemotePhotoMapper
) : PhotoRepository {

    override fun getLocalPhotos(): Flowable<List<Photo>> {
        return photoDao.getPhotos()
            .map {
                it.map { localPhoto -> localPhotoMapper.mapFromLocal(localPhoto) }
            }

    }

    override fun getRemotePhotos(): Single<List<Photo>> {
        return photoApiService.getPhotos()
            .map {
                it.map { remotePhoto -> remotePhotoMapper.mapFromRemote(remotePhoto) }
            }
    }

    override fun savePhotos(photos: List<Photo>) {
        return photoDao.clearAndSave(photos.map { localPhotoMapper.mapToLocal(it) })
    }

}