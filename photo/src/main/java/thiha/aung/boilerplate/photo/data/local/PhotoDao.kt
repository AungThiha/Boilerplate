package thiha.aung.boilerplate.photo.data.local

import androidx.room.*
import io.reactivex.Flowable
import thiha.aung.boilerplate.core.data.local.FROM
import thiha.aung.boilerplate.core.data.local.SELECT
import thiha.aung.boilerplate.core.data.local.DELETE

@Dao
abstract class PhotoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun save(photos: List<LocalPhoto>)

    @Query("$SELECT * $FROM $TABLE_PHOTO")
    abstract fun getPhotos(): Flowable<List<LocalPhoto>>

    @Query("$DELETE $FROM $TABLE_PHOTO")
    abstract fun clear()

    @Transaction
    open fun clearAndSave(photos: List<LocalPhoto>) {
        clear()
        save(photos)
    }

}