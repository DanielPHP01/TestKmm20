package com.example.testkmm20

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform