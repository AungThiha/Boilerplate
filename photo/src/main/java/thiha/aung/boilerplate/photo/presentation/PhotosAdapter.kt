package thiha.aung.boilerplate.photo.presentation

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import thiha.aung.boilerplate.photo.R
import thiha.aung.boilerplate.photo.domain.entities.Photo
import kotlin.properties.Delegates

class PhotosAdapter : RecyclerView.Adapter<PhotosViewHolder>()  {

    var photoList: List<Photo> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        return PhotosViewHolder(parent.inflate(R.layout.item_photo))
    }

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        holder.bind(photoList[position])
    }

    override fun getItemCount(): Int {
        return photoList.size
    }
}