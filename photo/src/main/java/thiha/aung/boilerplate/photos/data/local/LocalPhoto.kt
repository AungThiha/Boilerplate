package thiha.aung.boilerplate.photos.data.local

import androidx.room.Entity

const val TABLE_PHOTO = "photo"

@Entity(tableName = TABLE_PHOTO)
data class LocalPhoto(
    val id: String,
    val author: String,
    val url: String
)