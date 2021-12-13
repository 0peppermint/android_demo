# android_demo
Personal Android demo (from some trick)

## Introduction

一个自己的Android demo库，用来实现一些黑魔法（大概

[好用的Android resource](https://cs.android.com/android/platform/superproject/+/master:frameworks/base/core/java/android/view/SurfaceView.java;drc=master;l=1065?q=SurfaceView)

## Model

- **View-Scale MVP**

尝试实现一个view级别的mvp，方便热插拔

设计初衷是要

```kotlin
功能上希望做到
- 同级node之间解耦
- 可嵌套
- node只感知自己的child
- node间通信尽可能简单且便于控制

然后
- 可读性
- 扩展性
```

- **aptproject、BaseAnnotation**

实现一个注解生成代码的demo
使用annotation+javapoet
有三种写法分别是：
```kotlin
- javapoet
- javaasset
- asm
```
都可以尝试下一下

- **translate_activity_demo**

这个是想做一个类似闲鱼-会玩中点击切换activity的效果（有点酷炫


