package thiha.aung.boilerplate.core.scheduler

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Application providers
 */
class AppSchedulerProvider : SchedulerProvider {

    override fun new() = Schedulers.newThread()

    override fun io() = Schedulers.io()

    override fun ui() = AndroidSchedulers.mainThread()

    override fun computation() = Schedulers.computation()
}