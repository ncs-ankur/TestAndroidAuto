package com.example.car_app

import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.example.sharedmodule.RxEvent
import com.example.sharedmodule.TestEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable


abstract class BaseScreenCar(carContext: CarContext) : Screen(carContext) {

    var compositeDisposable: CompositeDisposable = CompositeDisposable()

    init {
        lifecycle.addObserver(object : LifecycleObserver {
            @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
            fun onCreate() {
                onCreateScreen()
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            fun onDestroy() {
                onDestroyScreen()
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_START)
            fun onStart() {
                onStartScreen()
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
            fun onResume() {
                compositeDisposable.add(
                    RxEvent.listenEventFromCar(TestEvent::class.java)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe {
                            onReceiverEventFromApp(it)
                        })
                onResumeScreen()
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
            fun onPause() {
                compositeDisposable.dispose()
                onPauseScreen()
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
            fun onStop() {
                onStopScreen()
            }
        })
    }

    open fun onCreateScreen() {}

    open fun onResumeScreen() {}

    open fun onPauseScreen() {}

    open fun onStartScreen() {}

    open fun onStopScreen() {}

    open fun onDestroyScreen() {}

    open fun onReceiverEventFromApp(event: TestEvent?) {

    }
}