package com.example.car_app

import androidx.car.app.CarContext
import androidx.car.app.model.Action
import androidx.car.app.model.CarIcon
import androidx.car.app.model.MessageTemplate
import androidx.car.app.model.Template
import androidx.core.graphics.drawable.IconCompat
import com.example.sharedmodule.RxEvent
import com.example.sharedmodule.ShowRoutePlanning
import com.example.sharedmodule.StartCruiseMode
import com.example.sharedmodule.TestEvent

class ScreenMain(
    carContext: CarContext
) : BaseScreenCar(carContext) {

    override fun onGetTemplate(): Template {
        return MessageTemplate.Builder(
            "MAIN SCREEN"
        ).setIcon(
            CarIcon.Builder(
                IconCompat.createWithResource(
                    carContext,
                    R.mipmap.ic_launcher
                )
            )
                .build()
        )
            .setTitle(carContext.getString(R.string.app_name))
            .build()
    }
}
