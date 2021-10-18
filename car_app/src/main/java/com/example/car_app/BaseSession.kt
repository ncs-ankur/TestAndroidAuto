package com.example.car_app

import androidx.car.app.Session
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.example.sharedmodule.RxEvent
import com.example.sharedmodule.TestEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

abstract class BaseSession : Session() {

    var compositeDisposable: CompositeDisposable = CompositeDisposable()

    init {
        lifecycle.addObserver(object : DefaultLifecycleObserver {
            override fun onCreate(owner: LifecycleOwner) {
            }

            override fun onStart(owner: LifecycleOwner) {
                compositeDisposable.add(
                    RxEvent.listenEventFromCar(TestEvent::class.java)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe {
                            handleEvent(it)
                        })
            }

            override fun onResume(owner: LifecycleOwner) {
            }

            override fun onPause(owner: LifecycleOwner) {
            }

            override fun onStop(owner: LifecycleOwner) {
                compositeDisposable.dispose()
            }

            override fun onDestroy(owner: LifecycleOwner) {
            }
        })
    }

    protected open fun handleEvent(event: TestEvent?) {}
}