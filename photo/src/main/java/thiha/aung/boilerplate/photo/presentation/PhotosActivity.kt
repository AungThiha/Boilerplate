package thiha.aung.boilerplate.photo.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import kotlinx.android.synthetic.main.activity_photos.*
import org.koin.android.viewmodel.ext.android.viewModel
import thiha.aung.boilerplate.photo.R
import thiha.aung.boilerplate.photo.domain.entities.Photo

class PhotosActivity : AppCompatActivity(), SwipeRefreshLayout.OnRefreshListener {

    private val viewModel: PhotosViewModel by viewModel()

    private val adapter = PhotosAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photos)

        initView()
        viewModel.fetchPhotos()

        swipeRefreshLayout.setOnRefreshListener(this)

        observeData()
    }

    private fun initView() {

        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.defaultMargin)

        val listItemDecoration = SpacingItemDecoration(1, spacingInPixels)

        val layoutManager = LinearLayoutManager(this)
        photoList.layoutManager = layoutManager
        photoList.addItemDecoration(listItemDecoration)
        photoList.adapter = adapter
        photoList.isNestedScrollingEnabled = false
    }

    private fun observeData() {
        viewModel.photos.observe(this, Observer<List<Photo>> { photos ->
            adapter.photoList = photos
        })
    }

    override fun onRefresh() {
        viewModel.refreshPhotos()
    }
}
