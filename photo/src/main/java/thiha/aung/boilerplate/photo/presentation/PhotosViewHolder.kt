package thiha.aung.boilerplate.photo.presentation

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.item_photo.view.*
import thiha.aung.boilerplate.photo.R
import thiha.aung.boilerplate.photo.domain.entities.Photo

class PhotosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    fun onBind(photo: Photo) {
        Glide.with(itemView.context)
            .load(photo.url)
            .placeholder(R.drawable.placeholder)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .into(itemView.photoView)

        itemView.photoName.text = photo.author
    }
}
