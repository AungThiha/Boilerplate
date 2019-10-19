package thiha.aung.boilerplate.core.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import io.reactivex.Completable
import thiha.aung.boilerplate.core.domain.entities.ErrorResponse

class ApplicationNetworkProvider(
    private val context: Context
) : NetworkProvider {

    /**
     * Made completable to be able to be added into Rx Stream
     * */
    override fun isInternetOn(): Completable {
        var isOn = false
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            cm?.run {
                getNetworkCapabilities(activeNetwork)?.run {
                    isOn = when {
                        hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                        hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                        hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                        else -> false
                    }
                }
            }
        } else {
            isOn = when (cm?.activeNetworkInfo?.type) {
                ConnectivityManager.TYPE_WIFI -> true
                ConnectivityManager.TYPE_MOBILE -> true
                else -> false
            }
        }
        return if (isOn)
            Completable.complete()
        else
            Completable.error(ErrorResponse.NoInternetConnection)
    }

}