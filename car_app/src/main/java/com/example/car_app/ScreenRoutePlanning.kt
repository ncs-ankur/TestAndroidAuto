package com.example.car_app

import androidx.car.app.CarContext
import androidx.car.app.model.*
import androidx.core.graphics.drawable.IconCompat
import com.example.sharedmodule.CancelRoutePlanning
import com.example.sharedmodule.RxEvent
import com.example.sharedmodule.StartNavigation

class ScreenRoutePlanning(
    carContext: CarContext
) : BaseScreenCar(carContext) {

    override fun onGetTemplate(): Template {
        return MessageTemplate.Builder(
            "ROUTE PLANNING"
        ).setIcon(
            CarIcon.Builder(
                IconCompat.createWithResource(
                    carContext,
                    R.drawable.ic_vc_route
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
                    .setTitle("Start Navigation")
                    .setOnClickListener {
                        RxEvent.postEvent(StartNavigation())
                    }
                    .build()
            ).addAction(
                Action.Builder()
                    .setTitle("Cancel")
                    .setOnClickListener {
                        RxEvent.postEvent(CancelRoutePlanning())
                    }
                    .build()
            ).build()
    }

//    override fun onReceiverEventFromApp(event: TestEvent?) {
//        super.onReceiverEventFromApp(event)
//    }
}
