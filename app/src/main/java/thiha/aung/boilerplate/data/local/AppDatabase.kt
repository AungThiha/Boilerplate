package thiha.aung.boilerplate.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import thiha.aung.boilerplate.photo.data.local.LocalPhoto
import thiha.aung.boilerplate.photo.data.local.PhotoDao

@Database(entities = [
    LocalPhoto::class
], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun photoDao(): PhotoDao
}