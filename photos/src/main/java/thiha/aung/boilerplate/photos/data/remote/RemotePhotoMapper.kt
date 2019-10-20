package thiha.aung.boilerplate.photos.data.remote

import thiha.aung.boilerplate.core.data.remote.RemoteEntityMapper
import thiha.aung.boilerplate.photos.domain.entities.Photo

class RemotePhotoMapper : RemoteEntityMapper<RemotePhoto, Photo> {
    override fun mapFromRemote(remote: RemotePhoto): Photo {
        return Photo(remote.id, remote.author, remote.downloadUrl)
    }
}