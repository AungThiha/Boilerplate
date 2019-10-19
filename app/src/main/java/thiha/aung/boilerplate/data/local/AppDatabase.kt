package thiha.aung.boilerplate.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [
    //Home entities
    // Example1Item::class, Example2Item::class
], version = 1)
abstract class AppDatabase : RoomDatabase() {
    // abstract fun exampleDao(): ExampleDao
}