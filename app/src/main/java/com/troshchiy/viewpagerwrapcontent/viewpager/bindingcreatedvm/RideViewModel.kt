package com.troshchiy.viewpagerwrapcontent.viewpager.bindingcreatedvm

import com.troshchiy.viewpagerwrapcontent.Ride


class RideViewModel(val ride: Ride) {

    fun textFun() = ride.text + ride.text

    val text = ride.text

}