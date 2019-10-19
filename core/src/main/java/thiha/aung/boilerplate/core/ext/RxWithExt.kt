package thiha.aung.boilerplate.core.ext

import io.reactivex.Completable
import io.reactivex.Single
import thiha.aung.boilerplate.core.scheduler.SchedulerProvider


/**
 * Use SchedulerProvider configuration for Observable
 */
fun Completable.with(schedulerProvider: SchedulerProvider): Completable =
        this.observeOn(schedulerProvider.ui()).subscribeOn(schedulerProvider.io())

/**
 * Use SchedulerProvider configuration for Single
 */
fun <T> Single<T>.with(schedulerProvider: SchedulerProvider): Single<T> =
        this.observeOn(schedulerProvider.ui()).subscribeOn(schedulerProvider.io())