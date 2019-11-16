package thiha.aung.boilerplate.core.scheduler

import io.reactivex.Scheduler

/**
 * Rx Scheduler Provider
 */
interface SchedulerProvider {
    fun new(): Scheduler
    fun io(): Scheduler
    fun ui(): Scheduler
    fun computation(): Scheduler
}