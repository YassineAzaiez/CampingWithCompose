package com.example.campingwithcompsoe.common.utils

import com.example.campingwithcompsoe.common.FORGET_PASSWORD_SOURCE
import com.example.campingwithcompsoe.common.REGISTRATION_SOURCE

enum class OtpSource(val source: String) {
    FORGET_PASSWORD(source = FORGET_PASSWORD_SOURCE),
    REGISTRATION(source = REGISTRATION_SOURCE),
}