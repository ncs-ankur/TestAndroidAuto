package com.example.testandroidauto

import androidx.appcompat.app.AppCompatActivity
import com.example.sharedmodule.RxEvent
import com.example.sharedmodule.TestEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

abstract class BaseActivity : AppCompatActivity() {

    open var compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onStart() {
        super.onStart()
        compositeDisposable.add(
            RxEvent.listenEventFromCar(TestEvent::class.java)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    onEventFromCar(it)
                })
    }


    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }

    open fun onEventFromCar(event: TestEvent) {
    }
}