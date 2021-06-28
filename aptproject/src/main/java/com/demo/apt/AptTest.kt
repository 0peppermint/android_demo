package com.demo.apt

import com.demo.apt.baseapt.BaseApt

@BaseApt(name = "AptTestClass", type = "class")
class AptTest {

    @BaseApt(name = "AptTestParams", type = "params")
    val a = 1

    @BaseApt(name = "AptTestFunction", type = "Function")
    fun output(): Int {
        return a;
    }

    fun getDeclaredClass(): String {
        val str = StringBuilder()
        str.append("Declared Class Name")
        str.append(this::class.java.getAnnotation(BaseApt::class.java).name)
        str.append(" and ")
        str.append(this.javaClass.getAnnotation(BaseApt::class.java).type)
        return str.toString()
    }
}