package com.example.sharedmodule

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

sealed class TestEvent

object RxEvent {
    private val publisher = PublishSubject.create<TestEvent>()

    fun postEvent(event: TestEvent) {
        publisher.onNext(event)
    }

    fun <Events> listenEventFromCar(eventType: Class<Events>): Observable<Events> =
        publisher.ofType(eventType)
}

class ShowHomeScreen() : TestEvent()
class ShowSearch() : TestEvent()
class CancelSearch() : TestEvent()
class ShowRoutePlanning() : TestEvent()
class CancelRoutePlanning() : TestEvent()
class StartCruiseMode() : TestEvent()
class StopCruiseMode() : TestEvent()
class StartNavigation() : TestEvent()
class StopNavigation() : TestEvent()







