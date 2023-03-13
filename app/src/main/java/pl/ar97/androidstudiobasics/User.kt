package pl.ar97.androidstudiobasics

import androidx.annotation.DrawableRes

data class User(
    val name: String,
    val surname:String,
    val technology:String,
    val birthDate:String,
    val city:String,
    @DrawableRes val image: Int
)
