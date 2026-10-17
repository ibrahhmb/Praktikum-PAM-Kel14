package com.example.pinjemin

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform