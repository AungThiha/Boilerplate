package thiha.aung.boilerplate.photos.data.remote

import org.junit.Assert.assertEquals
import org.junit.Test
import thiha.aung.boilerplate.photos.domain.entities.Photo

class RemotePhotoMapperTest {

    private val mapper = RemotePhotoMapper()

    @Test
    fun mapFromRemote() {
        val remote0 = RemotePhoto(
            id = "0",
            author = "Aung Thiha",
            width = 300,
            height = 100,
            url = "https://s.gravatar.com/avatar/cbeeae6356c14e10987d0c68044e8e03?s=80",
            downloadUrl = "https://s.gravatar.com/avatar/cbeeae6356c14e10987d0c68044e8e03?s=80"
        )
        val entity0 = mapper.mapFromRemote(remote0)
        remoteEqualsEntity(remote0, entity0)

        val remote1 = RemotePhoto(
            id = "1",
            author = "Khin Thiri Soe",
            width = 300,
            height = 100,
            url = "https://s.gravatar.com/avatar/63242bae7a878e226fd50c1533b01ba3?s=80",
            downloadUrl = "https://s.gravatar.com/avatar/63242bae7a878e226fd50c1533b01ba3?s=80"
        )
        val entity1 = mapper.mapFromRemote(remote1)
        remoteEqualsEntity(remote1, entity1)
    }

    private fun remoteEqualsEntity(remote: RemotePhoto, entity: Photo) {
        assertEquals(remote.id, entity.id)
        assertEquals(remote.author, entity.author)
        assertEquals(remote.downloadUrl, entity.url)
    }
}