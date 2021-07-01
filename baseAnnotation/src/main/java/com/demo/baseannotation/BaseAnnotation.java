package com.demo.baseannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.TYPE, ElementType.METHOD, ElementType.LOCAL_VARIABLE, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface BaseAnnotation {

    String name();

    String type();
}
