package com.example.sharedmodule

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

sealed class Events

object RxEvent {
    private val publisher = PublishSubject.create<Events>()

    fun postEvent(event: Events) {
        publisher.onNext(event)
    }

    fun <Events> listenEventFromCar(eventType: Class<Events>): Observable<Events> =
        publisher.ofType(eventType)
}

class ShowHomeScreen() : Events()
class ShowSearch() : Events()
class ShowRoutePlanning() : Events()
class StartCruiseMode() : Events()
class StartNavigation() : Events()







