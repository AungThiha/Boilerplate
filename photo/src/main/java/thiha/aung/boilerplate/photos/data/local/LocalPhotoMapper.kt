package thiha.aung.boilerplate.photos.data.local

import thiha.aung.boilerplate.core.data.local.LocalEntityMapper
import thiha.aung.boilerplate.photos.domain.entities.Photo

class LocalPhotoMapper : LocalEntityMapper<LocalPhoto, Photo> {

    override fun mapFromLocal(local: LocalPhoto) =
        Photo(local.id, local.author, local.url)

    override fun mapToLocal(entity: Photo) =
        LocalPhoto(entity.id, entity.author, entity.url)

}