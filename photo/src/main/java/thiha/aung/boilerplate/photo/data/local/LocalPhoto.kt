package thiha.aung.boilerplate.photo.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

const val TABLE_PHOTO = "photo"

@Entity(tableName = TABLE_PHOTO)
data class LocalPhoto(
    @PrimaryKey
    val id: String,
    val author: String,
    val url: String
)