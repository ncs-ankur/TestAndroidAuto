package com.example.car_app

import androidx.car.app.CarContext
import androidx.car.app.model.*
import androidx.core.graphics.drawable.IconCompat
import com.example.sharedmodule.RxEvent
import com.example.sharedmodule.StopCruiseMode

class ScreenCruiseMode(
    carContext: CarContext
) : BaseScreenCar(carContext) {

    override fun onGetTemplate(): Template {
        return MessageTemplate.Builder(
            "CRUISE MODE"
        ).setIcon(
            CarIcon.Builder(
                IconCompat.createWithResource(
                    carContext,
                    R.drawable.ic_vc_cruise
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
                    .setTitle("End Cruise Mode")
                    .setOnClickListener {
                        RxEvent.postEvent(StopCruiseMode())
                    }
                    .build()
            ).build()
    }

//    override fun onReceiverEventFromApp(event: TestEvent?) {
//        super.onReceiverEventFromApp(event)
//    }
}
