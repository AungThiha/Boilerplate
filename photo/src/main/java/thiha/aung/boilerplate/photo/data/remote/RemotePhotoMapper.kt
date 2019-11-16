package thiha.aung.boilerplate.photo.data.remote

import thiha.aung.boilerplate.core.data.remote.RemoteEntityMapper
import thiha.aung.boilerplate.photo.domain.entities.Photo

class RemotePhotoMapper : RemoteEntityMapper<RemotePhoto, Photo> {

    override fun mapFromRemote(remote: RemotePhoto) =
        Photo(remote.id, remote.author, remote.downloadUrl)

}