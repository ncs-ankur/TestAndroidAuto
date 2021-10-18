package com.example.car_app

import androidx.car.app.CarContext
import androidx.car.app.model.*
import androidx.core.graphics.drawable.IconCompat
import com.example.sharedmodule.RxEvent
import com.example.sharedmodule.StopNavigation

class ScreenNavigation(
    carContext: CarContext
) : BaseScreenCar(carContext) {

    override fun onGetTemplate(): Template {
        return MessageTemplate.Builder(
            "NAVIGATION"
        ).setIcon(
            CarIcon.Builder(
                IconCompat.createWithResource(
                    carContext,
                    R.drawable.ic_vc_home
                )
            ).setTint(
                CarColor.createCustom(
                    carContext.getColor(R.color.color_tint),
                    carContext.getColor(R.color.color_tint)
                )
            )
                .build()
        )
            .setTitle(carContext.getString(R.string.app_name))
            .addAction(
                Action.Builder()
                    .setTitle("Stop Navigation")
                    .setOnClickListener {
                        RxEvent.postEvent(StopNavigation())
                    }
                    .build()
            ).build()
    }

//    override fun onReceiverEventFromApp(event: TestEvent?) {
//        super.onReceiverEventFromApp(event)
//    }
}
