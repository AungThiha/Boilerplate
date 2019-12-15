package thiha.aung.boilerplate.photo.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.koin.android.viewmodel.ext.android.viewModel
import thiha.aung.boilerplate.photo.R

class PhotosActivity : AppCompatActivity() {

    private val viewModel: PhotosViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photos)

        viewModel.fetchPhotos()
    }
}
