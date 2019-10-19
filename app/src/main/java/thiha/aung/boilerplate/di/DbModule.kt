package thiha.aung.boilerplate.di

import androidx.room.Room
import org.koin.dsl.module
import thiha.aung.boilerplate.data.local.AppDatabase

val dbModule = module {

    single {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            "app_room_db"
        ).fallbackToDestructiveMigration().build()
    }

    // single { get<AppDatabase>().example1Dao() }

}