package thiha.aung.boilerplate

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import thiha.aung.boilerplate.di.appModule


class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            // Android context
            androidContext(this@MainApplication)
            // modules
            modules(appModule)
        }
    }

}