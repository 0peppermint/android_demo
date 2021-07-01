package com.demo.apt

import com.demo.baseannotation.BaseAnnotation


@BaseAnnotation(name = "AptTestClass", type = "class")
class AptTest {

    @BaseAnnotation(name = "AptTestParams", type = "params")
    val a = 1

    @BaseAnnotation(name = "AptTestFunction", type = "Function")
    fun output(): Int {
        return a;
    }

    fun getDeclaredClass(): String {
        val str = StringBuilder()
        str.append("Declared Class Name")
        str.append(this::class.java.getAnnotation(BaseAnnotation::class.java).name)
        str.append(" and ")
        str.append(this.javaClass.getAnnotation(BaseAnnotation::class.java).type)
        return str.toString()
    }
}