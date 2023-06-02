package com.demo.communicate.multithread

data class ThreadItem(
    val workType: Int,
    val action: Runnable
)

const val WORKING_TYPE_EARN_MONEY = 0
const val WORKING_TYPE_SLEEP = 1
const val WORKING_TYPE_EAT = 2