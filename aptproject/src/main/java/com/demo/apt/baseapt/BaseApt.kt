package com.demo.apt.baseapt


@MustBeDocumented
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.CLASS,
    AnnotationTarget.FIELD
)
@Retention(AnnotationRetention.RUNTIME)
annotation class BaseApt(val name: String, val type: String)