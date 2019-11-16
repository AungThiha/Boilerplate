package thiha.aung.boilerplate.photo.data.local

import androidx.room.*
import io.reactivex.Flowable
import thiha.aung.boilerplate.core.data.local.ALL
import thiha.aung.boilerplate.core.data.local.FROM
import thiha.aung.boilerplate.core.data.local.SELECT
import thiha.aung.boilerplate.core.data.local.DELETE
import thiha.aung.boilerplate.photo.domain.entities.Photo

@Dao
abstract class PhotoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun save(photos: List<Photo>)

    @Query("$SELECT $ALL $FROM $TABLE_PHOTO")
    abstract fun getPhotos(id: String): Flowable<Photo>

    @Query("$DELETE $FROM $TABLE_PHOTO")
    abstract fun clear()

    @Transaction
    fun clearAndSave(photos: List<Photo>) {
        clear()
        save(photos)
    }

}