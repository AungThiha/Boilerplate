package thiha.aung.boilerplate.photos.data.local

import org.junit.Test

import org.junit.Assert.*
import thiha.aung.boilerplate.photos.domain.entities.Photo

class LocalPhotoMapperTest {

    private val mapper = LocalPhotoMapper()

    @Test
    fun mapFromLocal() {
        val local0 = LocalPhoto(
            id = "0",
            author = "Aung Thiha",
            url = "https://s.gravatar.com/avatar/cbeeae6356c14e10987d0c68044e8e03?s=80"
        )
        val entity0 = mapper.mapFromLocal(local0)
        localEqualsEntity(local0, entity0)


        val local1 = LocalPhoto(
            id = "1",
            author = "Khin Thiri Soe",
            url = "https://s.gravatar.com/avatar/63242bae7a878e226fd50c1533b01ba3?s=80"
        )
        val entity1 = mapper.mapFromLocal(local1)
        localEqualsEntity(local1, entity1)
    }

    @Test
    fun mapToLocal() {
        val entity0 = Photo(
            id = "0",
            author = "Aung Thiha",
            url = "https://s.gravatar.com/avatar/cbeeae6356c14e10987d0c68044e8e03?s=80"
        )
        val local0 = mapper.mapToLocal(entity0)
        localEqualsEntity(local0, entity0)


        val entity1 = Photo(
            id = "1",
            author = "Khin Thiri Soe",
            url = "https://s.gravatar.com/avatar/63242bae7a878e226fd50c1533b01ba3?s=80"
        )
        val local1 = mapper.mapToLocal(entity1)
        localEqualsEntity(local1, entity1)
    }

    private fun localEqualsEntity(local: LocalPhoto, entity: Photo) {
        assertEquals(local.id, entity.id)
        assertEquals(local.author, entity.author)
        assertEquals(local.url, entity.url)
    }
}